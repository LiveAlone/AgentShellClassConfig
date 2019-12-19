package com.yqj.agent.core;

import com.sun.management.HotSpotDiagnosticMXBean;

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

}
