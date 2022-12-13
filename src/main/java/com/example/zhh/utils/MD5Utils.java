package com.example.zhh.utils;


import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class MD5Utils {

    protected MD5Utils(){

    }

    private static final String ALGORITH_NAME = "md5";

    private static final int HASH_ITERATIONS = 2;

    public static String encrypt(String password) {
        return new SimpleHash(ALGORITH_NAME, password, ByteSource.Util.bytes(password), HASH_ITERATIONS).toHex();
    }

    public static String encrypt(String username, String password) {
        return new SimpleHash(ALGORITH_NAME, password, ByteSource.Util.bytes(username.toLowerCase() + password),
                HASH_ITERATIONS).toHex();
    }

    public static void main(String[] args) {
        System.out.println(encrypt("scott","123456"));
    }

}