package com.stone.classloader.log;

import java.io.InputStream;

/**
 *
 * @author yankai913@gmail.com
 * @date 2014-6-12
 */
public class MyClassLoader extends ClassLoader {
    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        try {
            String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
            InputStream is = getClass().getResourceAsStream(fileName);
            if (is == null) {
                return super.loadClass(name);
            }
            byte[] b = new byte[is.available()];
            is.read(b);
            return defineClass(name, b, 0, b.length);
        }
        catch (Exception e) {
            throw new ClassNotFoundException(name);
        }
    }
}