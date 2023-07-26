package com.example.zhh.service.impl;

import com.example.zhh.pojo.HistorySsArchive;
import com.example.zhh.service.MyService;

import javax.jws.WebService;

@WebService(endpointInterface="com.example.zhh.service.MyService")
public class MyServiceImpl implements MyService {

    @Override
    public String show(HistorySsArchive historySsArchive) {
        System.out.println("客户端传送内容:"+historySsArchive.getArchiveinfo());
        return historySsArchive.getArchiveinfo()!=null?"abc":"def";
    }
}
