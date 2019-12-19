package com.yqj.agent.core;

import java.lang.instrument.Instrumentation;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2019/12/19
 * Email: yaoqijunmail@foxmail.com
 */
public class ToolsUtil {

    public static void printAllLoadedClass(Instrumentation inst){
        for (Class allLoadedClass : inst.getAllLoadedClasses()) {
            System.out.println(allLoadedClass.getName());
        }
        System.out.println("all class loaded finish");
    }

}
