package com.yqj.agent.boot;


import com.sun.tools.attach.VirtualMachine;
import com.sun.tools.attach.VirtualMachineDescriptor;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2019/12/18
 * Email: yaoqijunmail@foxmail.com
 */
public class Bootstrap {

    public static void main(String[] args) throws Exception{
        String targetPid = "81013";

        VirtualMachineDescriptor virtualMachineDescriptor = null;
        for (VirtualMachineDescriptor descriptor : VirtualMachine.list()) {
            if (targetPid.equals(descriptor.id())){
                virtualMachineDescriptor = descriptor;
            }
        }
        if (virtualMachineDescriptor == null){
            System.out.println("target pid " + targetPid + " note found");
            return;
        }

        VirtualMachine virtualMachine = VirtualMachine.attach(virtualMachineDescriptor);

        // 通过 load agent 启动方法
        virtualMachine.loadAgent("/Users/yaoqijun/workspace/person/AgentShellClassConfig/build/agent-core-jar-with-dependencies.jar");
    }

}
