package com.example.zhh.practice;

import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        /*String srcFilePath = "C:\\test.properties.txt";//要拷贝的文件路径
        String destFilePath = "D:\\test.properties.txt";//拷贝到的路径，文件名可以自定义
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(srcFilePath);
            fileOutputStream = new FileOutputStream(destFilePath);
            //定义一个字节数组提高效率
            byte[] bytes = new byte[1024];
            int readLen = 0;//一次读取多少个
            while ((readLen = fileInputStream.read(bytes)) != -1) {
                //写入文件，边读边写
                fileOutputStream.write(bytes,0,readLen);
            }
            System.out.println("拷贝成功");
        } catch (IOException e) {
            e.getMessage();//输出异常
        } finally {
            try {//关闭输入流和输出流，释放资源
                if (fileInputStream!=null){
                    fileInputStream.close();
                }
                if (fileOutputStream!=null){
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.getMessage();//输出异常
            }
        }*/

        File file = new File("C:\\Users\\user\\Pictures\\壁纸\\卷宗\\图片");
        File[] files = file.listFiles();
        for (File f:
             files) {
            copyToDir(f,"D:\\work\\test.properties\\"+f.getName());
        }

    }

    private static void copyToDir(File f, String s) {


        try {

            File file = new File(new File(s).getParent());
            if(!file.exists())
                file.mkdirs();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(f));
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(s));
            long l = System.currentTimeMillis();
            byte[] bytes = new byte[1024];
            int size = 0;
            while ((size = bufferedInputStream.read(bytes))!=-1){
                bufferedOutputStream.write(bytes,0,size);
            }
            long l1 = System.currentTimeMillis();
            System.out.println("xixi:"+(l1-l));
        }catch (Exception e){
            e.printStackTrace();
        }

    }


}
