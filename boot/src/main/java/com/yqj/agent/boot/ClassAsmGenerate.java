package com.yqj.agent.boot;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.io.FileOutputStream;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2019/12/20
 * Email: yaoqijunmail@foxmail.com
 */
public class ClassAsmGenerate {

    public static void main(String[] args) throws Exception {
        String className = "com.yqj.agent.boot.HelloWorld";

        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
        //声明一个类，使用JDK1.8版本，public的类，父类是java.lang.Object，没有实现任何接口
        cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, className.replace(".", "/"), null, "java/lang/Object", null);

        //初始化一个无参的构造函数
        MethodVisitor constructor = cw.visitMethod(Opcodes.ACC_PUBLIC, "<init>", "()V", null, null);
        constructor.visitVarInsn(Opcodes.ALOAD, 0);
        constructor.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
        constructor.visitInsn(Opcodes.RETURN);
        constructor.visitMaxs(1, 1);
        constructor.visitEnd();

        String message = "hello world";

        MethodVisitor runMethod = cw.visitMethod(Opcodes.ACC_PUBLIC, "run", "()V", null, null);
        runMethod.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        runMethod.visitLdcInsn(message);
        runMethod.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
        runMethod.visitInsn(Opcodes.RETURN);
        runMethod.visitMaxs(1, 1);
        runMethod.visitEnd();

        byte[] classData = cw.toByteArray();

        FileOutputStream fileOutputStream = new FileOutputStream("HelloWorld.class");
        fileOutputStream.write(classData);

    }

}
