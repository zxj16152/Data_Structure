package com.jvm;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

// 自定义ClassLoader类，继承自ClassLoader
public class CustomClassLoader extends ClassLoader {
    // 定义了类文件的根路径
    private String rootDir;
    // 缓存已经加载的类
    private HashMap<String, Class<?>> loadedClasses;

    /**
     * Constructor
     *
     * @param rootDir 类文件的根目录路径
     */
    public CustomClassLoader(String rootDir) {
        this.rootDir = rootDir;
        // 初始化缓存Hashmap
        loadedClasses = new HashMap<>();
    }

    /**
     * 加载类文件并返回Class实例
     *
     * @param className 类的全限定名
     * @return 加载的类的Class实例
     * @throws ClassNotFoundException 如果类未被找到或加载
     */
    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException {
        // 从已加载的类缓存中查找类
        Class<?> loadedClass = loadedClasses.get(className);
        // 如果类已经被加载，从缓存中返回
        if (loadedClass != null) {
            return loadedClass;
        }
        // 否则读取类文件的字节码
        byte[] classBytes = getClassBytes(className);
        if (classBytes == null) {
            throw new ClassNotFoundException();
        }
        // 在锁定的环境中，定义类并将类放入已加载的类缓存中
        synchronized (loadedClasses) {
            loadedClass = defineClass(className, classBytes, 0, classBytes.length);
            loadedClasses.put(className, loadedClass);
        }
        return loadedClass;
    }

    /**
     * 根据类名读取类文件的字节码
     *
     * @param className 类的全名（包括包名）
     * @return 类文件的字节码
     */
    private byte[] getClassBytes(String className) {
        // 将全名转换为文件名
        String classPath = rootDir + '/' +
                className.replace('.', '/') + ".class";
        FileInputStream fis = null;
        ByteArrayOutputStream baos = null;
        try {
            fis = new FileInputStream(classPath);
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int bytesRead;
            // 循环读取文件直到文件结束
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            // 返回字节流的字节数组
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (fis != null) {
                    fis.close();
                }
                if (baos != null) {
                    baos.close();
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        // 创建新的CustomClassLoader实例
        CustomClassLoader customClassLoader = new CustomClassLoader("/path/to/classes");
        try {
            // 通过自定义的类加载器加载一个类，输出其类名
            Class<?> sampleClass = customClassLoader.loadClass("com.example.SampleClass");
            System.out.println("Class loaded successfully: " + sampleClass.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}