package com.yqj.agent.core;

import java.lang.instrument.Instrumentation;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2019/12/18
 * Email: yaoqijunmail@foxmail.com
 */
public class AgentBootStrap {

    public static void premain(String args, Instrumentation inst) {
        System.out.println("current pre main content test config");
    }

    public static void agentmain(String args, Instrumentation inst) throws Exception {
        System.out.println("agent main content execution content");
        ToolsUtil.dumpClassFileContent(inst);
    }
}
