package com.yqj.agent.core;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2019/12/19
 * Email: yaoqijunmail@foxmail.com
 */
public class ClassDumpTransformer implements ClassFileTransformer {

    String filePath = "/Users/yaoqijun/workspace/person/AgentShellClassConfig/build/Student.class";

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        System.out.println(loader);
        System.out.println(className);
        System.out.println(classfileBuffer.length);
        try {
            System.out.println("start out put file");
            File f = new File(filePath);
            FileOutputStream fileOutputStream = new FileOutputStream(f);
            fileOutputStream.write(classfileBuffer);
            System.out.println("finish out put file");
        }catch (Exception e){
            System.out.println("out put file error cause :" + e.toString());
        }
        return null;
    }
}
