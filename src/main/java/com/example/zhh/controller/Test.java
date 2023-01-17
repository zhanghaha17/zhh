package com.example.zhh.controller;

import com.example.zhh.handle.DocumentHandler;
import com.example.zhh.pojo.ResponseBo;
import net.sourceforge.pinyin4j.PinyinHelper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Test {


    public static String getPinYinHeadChar(String str) {

        String convert = "";
        for (int j = 0; j < str.length(); j++) {
            char word = str.charAt(j);
            String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
            if (pinyinArray != null) {
                convert += pinyinArray[0].charAt(0);
            } else {
                convert += word;
            }
        }
        return convert.toLowerCase(Locale.ROOT);
    }


    public static void main(String[] args) throws IOException {
/*
        String state = "1 , 2";
        String stateStr=state.replace(",","").replace(" ","");
        System.out.println(stateStr);
*/


        ResponseBo fault = ResponseBo.fault();
        System.out.println("ok");

/*        String a = "1-2";
        String[] split = a.split(",");
        System.out.println(split[0]);*/


        File file =new File("d:\\test.doc");
        if(!file.exists())
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        Map<String, Object> map =new HashMap<>();
        new DocumentHandler().exportDoc("temp",map,file);





//        String pinyin = getPinYinHeadChar("王语嫣1");
//        System.out.println(pinyin);
//        String encrypt = MD5Utils.encrypt("mrbird","123456");
//        System.out.println("mrbird"+encrypt);

        try{
/*            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection ct= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "system", "oracle");
            Statement sm = ct.createStatement();
            ResultSet rs = sm.executeQuery("select* from DEPT");
            while(rs.next()){
                System.out.println("用户名"+rs.getString(2));
            }
            rs.close();
            sm.close();
            ct.close();*/


            String format = "";
            System.out.println("format:"+format);
        }catch(Exception e)
        {
            e.printStackTrace();
        }



    }
}
