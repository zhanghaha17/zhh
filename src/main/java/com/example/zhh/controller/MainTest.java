package com.example.zhh.controller;


import cn.hutool.core.io.FileUtil;
import com.itextpdf.text.pdf.PdfReader;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.ooxml.POIXMLDocument;
import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;


public class MainTest {

    public static void main(String[] args) throws IOException {
        run();
    }


    public static void run() throws IOException {
        List<File> files = FileUtil.loopFiles("D:\\dlxcfile\\2022\\08\\23\\苏市监调查分析[2022]1号\\3召回实施");
        System.out.println("文件总数：" + files.size());
        int num = 1;
        for (File file : files) {
            int count = 0;
            //System.out.println(file);
            String[] fileTypeArray = file.getName().split("\\.");
            String fileType = fileTypeArray[fileTypeArray.length - 1];
            if ("doc".equals(fileType)) {
                count = countWord2003Page(file.getPath());
            }
            if ("docx".equals(fileType)) {
                count = countWord2007Page(file.getPath());
            }
            if ("pdf".equals(fileType)) {
                count = countPdfPage(file.getPath());
            }
            System.out.println(file + "@" + fileType + "@" + count);
            num++;
        }
    }

    /**
     * 计算PDF格式文档的页数
     */
    public static int countPdfPage(String filepath) {
        int pageCount = 0;
        PdfReader reader = null;
        try {
            reader = new PdfReader(filepath);
            pageCount = reader.getNumberOfPages();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }
        return pageCount;
    }


    /**
     * 计算PPT格式文档的页数
     */
    public static int countPPTPage(String filePath) throws IOException {
        int pageCount = 0;
        ZipSecureFile.setMinInflateRatio(-1.0d);
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(filePath);
            XMLSlideShow pptxFile = new XMLSlideShow(fis);
            pageCount = pptxFile.getSlides().size();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fis.close();
        }
        return pageCount;
    }

    /**
     * 计算WORD2007(*.docx)格式文档的页数
     */
    public static int countWord2007Page(String filePath) {
        int pageCount = 0;
        ZipSecureFile.setMinInflateRatio(-1.0d);
        XWPFDocument docx = null;
        try {
            docx = new XWPFDocument(POIXMLDocument.openPackage(filePath));
            pageCount = docx.getProperties().getExtendedProperties().getUnderlyingProperties().getPages();//总页数
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                docx.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return pageCount;
    }

    /**
     * 计算WORD2003(*.doc)格式文档的页数
     */
    public static int countWord2003Page(String filePath) {
        int pageCount = 0;
        WordExtractor doc = null;
        ZipSecureFile.setMinInflateRatio(-1.0d);
        try {
            doc = new WordExtractor(new FileInputStream(filePath));//.doc格式Word文件提取器
            pageCount = doc.getSummaryInformation().getPageCount();//总页数
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                doc.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return pageCount;
    }


}