package com.example.zhh.handle;

import com.example.zhh.exception.LocalizedMessage;

public class TestChouxiang extends ChouXiang{


    public void aaa(){
        System.out.println(999);
    }

    @Override
    public int test() {
        return 0;
    }

    public static void main(String[] args) throws LocalizedMessage {
//        new TestChouxiang().aaa();
       /* byte[] bytes = new byte[100];
        bytes[0] =  'a';
        char[] chars = new char[100];
        try {
            String s = new String(bytes, "utf-8");
            System.out.println(s);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        final String str1 = "aa";
        final String str2 = "cc";
        String str3 = "aa" + "cc";
        String str5 = str1 + str2;
        String srr4 = "aacc";
        System.out.println(srr4==str5);
        chars[0] = 'a';
        System.out.println(String.valueOf(bytes[0]));*/

        throw new LocalizedMessage();
/*        try {

        }catch (LocalizedMessage e){
            e.getLocalizedMessage();
        }*/

    }
}
