package com.gwf.custom;

import java.io.*;

/**
 * 自定义类加载器
 * @author gaowenfeng
 * @date 2018/3/30
 */
public class MyClassLoader extends ClassLoader {

    private String baseDir;

    public MyClassLoader(){
        this.baseDir = MyClassLoader.class.getResource("").getPath();
    }

    /**
     * 通过类名称加载类字节码文件到JVM中
     * @param name 类名
     * @return 类的Class独享
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        // 获取类名
        String className = MyClassLoader.class.getPackage().getName()+"."+name;
        if(null == baseDir) {
            throw new ClassNotFoundException();
        }

        // 获取类文件
        File file = new File(baseDir,name+".class");
        if(!file.exists()){
            throw new ClassNotFoundException();
        }

        // 将类文件转换为字节数组
        try(
        FileInputStream in = new FileInputStream(file);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ){
            byte[] buffer = new byte[1024];
            int len;
            while ((len = in.read(buffer))!=-1){
                out.write(buffer,0,len);
            }

            // 调用父类方法生成class实例
            return defineClass(className,out.toByteArray(),0,out.size());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
