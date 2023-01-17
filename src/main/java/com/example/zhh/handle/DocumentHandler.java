package com.example.zhh.handle;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Map;

public class DocumentHandler {

    //Configuration存储一些全局常量和常用设置
    private Configuration configuration = null;

    //构造函数生成实例并设置编码
    public DocumentHandler() {
        configuration = new Configuration();
        configuration.setDefaultEncoding("utf-8");
    }


    /**
     * 导出word文档，导出到本地
     * @param tempName，要使用的模板
     * @param dataMap，模板中变量数据
     * @param outFile，输出文档路径
     */
    public boolean exportDoc(String tempName,Map<?, ?> dataMap,File outFile) throws IOException {
        boolean status = false;

        // 设置模本装置方法和路径,FreeMarker支持多种模板装载方法。可以重servlet，classpath，数据库装载，
        configuration.setDirectoryForTemplateLoading(  new File("D:/MyFile/ImportantFile/zhh/zhh/target/classes/template/"));

        Template t = null;

        try{
            // tempName.ftl为要装载的模板
            t = configuration.getTemplate(tempName+".ftl");
            t.setEncoding("utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Writer out = null;
        try{
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "utf-8"));
            status = true;
        }catch(Exception e1) {
            e1.printStackTrace();
        }

        try{
            t.process(dataMap, out);
            out.close();
        }catch(TemplateException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return status;
    }

    /**
     * 导出word文档，响应到请求端
     * @param tempName，要使用的模板
     * @param docName，导出文档名称
     * @param dataMap，模板中变量数据
     * @param resp,HttpServletResponse
     */
    public boolean exportDoc(String tempName, String docName, Map<?, ?> dataMap, HttpServletResponse resp) {
        boolean status = false;
        ServletOutputStream sos = null;
        InputStream fin = null;
        if (resp != null) {
            resp.reset();
        }

        // 设置模本装置方法和路径,FreeMarker支持多种模板装载方法。可以重servlet，classpath，数据库装载。参数2为模板路径
        configuration.setClassForTemplateLoading(this.getClass(), "/cn/hpc/ssm/template");

        Template t = null;

        try {
            // tempName.ftl为要装载的模板
            t = configuration.getTemplate(tempName + ".ftl");
            t.setEncoding("utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 输出文档路径及名称 ,以临时文件的形式导出服务器，再进行下载
        String name = "temp" + (int) (Math.random() * 100000) + ".doc";
        File outFile = new File(name);

        Writer out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "utf-8"));
            status = true;
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        try {
            t.process(dataMap, out);
            out.close();
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            fin = new FileInputStream(outFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // 文档下载
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/msword");
        try {
            docName = new String(docName.getBytes("UTF-8"), "ISO-8859-1");
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        resp.setHeader("Content-disposition", "attachment;filename=" + docName + ".doc");
        try {
            sos = resp.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] buffer = new byte[512]; // 缓冲区
        int bytesToRead = -1;
        // 通过循环将读入的Word文件的内容输出到浏览器中
        try {
            while ((bytesToRead = fin.read(buffer)) != -1) {
                sos.write(buffer, 0, bytesToRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fin != null)
                try {
                    fin.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (sos != null)
                try {
                    sos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (outFile != null)
                outFile.delete(); // 删除临时文件
        }

        return status;
    }

}