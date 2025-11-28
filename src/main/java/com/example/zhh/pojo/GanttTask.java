package com.example.zhh.pojo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

// 2. 数据模型类
@Data
public class GanttTask {
    @Excel(name = "任务ID", width = 10)
    private Integer id;

    @Excel(name = "任务名称", width = 20)
    private String name;

    @Excel(name = "开始天数", width = 12)
    private Integer startDay;

    @Excel(name = "结束天数", width = 12)
    private Integer endDay;

    @Excel(name = "进度(%)", width = 12)
    private Integer progress;

    @Excel(name = "负责人", width = 15)
    private String owner;

    @Excel(name = "开始日期", width = 15, format = "yyyy-MM-dd")
    private String startDate;

    @Excel(name = "结束日期", width = 15, format = "yyyy-MM-dd")
    private String endDate;

    @Excel(name = "状态", width = 12)
    private String status;

    public Integer getDuration() {
        return endDay - startDay + 1;
    }

    // 构造函数、getter和setter
    public GanttTask() {}

    // getter和setter方法...
}
