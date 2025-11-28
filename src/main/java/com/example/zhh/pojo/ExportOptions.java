package com.example.zhh.pojo;

import lombok.Data;

@Data
public class ExportOptions {
    private String filename;
    private String sheetName;
    private String type;
    private Boolean includeChart;

    // 构造函数、getter和setter
    // ...
}

