package com.example.zhh.pojo;

import java.util.HashMap;

public class ResponseBo extends HashMap<String, Object> {

    private static final long serialVersionUID = -8713837118340960775L;

    private int code = 0;
    private String message = "";
    private Object obj = null;

    public ResponseBo(Integer code,String message,Object obj){
        this.code = code;
        this.message = message;
        this.obj = obj;
    }

    public  ResponseBo message(String message) {
        this.put("message", message);
        return this;
    }

    public ResponseBo data(Object data) {
        this.put("data", data);
        return this;
    }

    @Override
    public ResponseBo put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    public static ResponseBo ok(){
        return new ResponseBo(200,"success",null);
    }

    public static ResponseBo error(String message){
        return new ResponseBo(500,message,null);
    }
}
