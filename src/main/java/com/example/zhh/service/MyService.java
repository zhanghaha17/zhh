package com.example.zhh.service;

import com.example.zhh.pojo.HistorySsArchive;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
public interface MyService {
    @WebMethod
    @WebResult
     String show(HistorySsArchive historySsArchive);
}
