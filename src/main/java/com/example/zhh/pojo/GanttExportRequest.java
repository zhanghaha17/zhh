package com.example.zhh.pojo;


import lombok.Data;

import java.util.List;

@Data
public class GanttExportRequest {
    private ExportOptions exportOptions;
    private List<GanttTask> ganttData;
    private ChartConfig chartConfig;

    // 构造函数、getter和setter
    // ...
}

