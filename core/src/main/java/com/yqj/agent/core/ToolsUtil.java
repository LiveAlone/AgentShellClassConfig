package com.yqj.agent.core;

import com.sun.management.HotSpotDiagnosticMXBean;
import com.sun.management.VMOption;

import java.lang.instrument.Instrumentation;
import java.lang.management.ManagementFactory;
import java.util.Arrays;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2019/12/19
 * Email: yaoqijunmail@foxmail.com
 */
public class ToolsUtil {

    private static final ClassDumpTransformer classDumpTransform = new ClassDumpTransformer();

    public static void vmOptionsList(){
        HotSpotDiagnosticMXBean hotSpotDiagnosticMXBean = ManagementFactory.getPlatformMXBean(HotSpotDiagnosticMXBean.class);
        for (VMOption diagnosticOption : hotSpotDiagnosticMXBean.getDiagnosticOptions()) {
            System.out.println("vm options list " + diagnosticOption.getName() + " " + diagnosticOption.getValue());
        }
    }

    public static void printAllLoadedClass(Instrumentation inst){
        System.out.println("print all loaded class start");
        Arrays.stream(inst.getAllLoadedClasses()).map(Class::getName).forEach(System.out::println);
        System.out.println("all class loaded finish");
    }

    public static void healDumpToFile() throws Exception{
        System.out.println("start heap dump");
        HotSpotDiagnosticMXBean hotSpotDiagnosticMXBean = ManagementFactory.getPlatformMXBean(HotSpotDiagnosticMXBean.class);
        hotSpotDiagnosticMXBean.dumpHeap("heapdumpTest.hprof", true);
        System.out.println("finish heap dump");
    }

    public static void dumpClassFileContent(Instrumentation inst){
        try {
            System.out.println("start dump class file transform content");
            inst.addTransformer(classDumpTransform);
            inst.retransformClasses(Student.class);
            System.out.println("finish dump class file transform content");
        }catch (Exception e){
            System.out.println("trans form dump fail cause : " + e.toString());
        }finally {
            inst.removeTransformer(classDumpTransform);
        }
    }

}
