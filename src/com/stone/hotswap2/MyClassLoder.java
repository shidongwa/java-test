package com.stone.hotswap2;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * 自定义Java类加载器来实现Java类的热加载
 * @author wy
 */
public class MyClassLoder extends ClassLoader {
    //要加载的Java类的classpath路径
    private String classpath;

    public MyClassLoder(String classpath){
        super(ClassLoader.getSystemClassLoader());
        this.classpath = classpath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] data = this.loadClassData(name);
        return this.defineClass(name, data, 0, data.length);
    }

    /**
     * 加载class文件中的内容
     * @param name
     * @return
     */
    private byte[] loadClassData(String name) {
        try{
            name = name.replace(".", "/");
            FileInputStream inputStream = new FileInputStream(new File(classpath + name + ".class"));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int b = 0;
            while ((b = inputStream.read()) != -1){
                byteArrayOutputStream.write(b);
            }
            inputStream.close();
            return byteArrayOutputStream.toByteArray();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


}
