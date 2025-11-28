package com.example.zhh.pojo;

import lombok.Data;

import java.util.List;

@Data
public class ChartConfig {
    private List<Integer> days;
    private Integer totalTasks;
    private Integer completedTasks;
    private Integer totalDuration;
    private Integer averageProgress;

    // 构造函数、getter和setter
    // ...
}

