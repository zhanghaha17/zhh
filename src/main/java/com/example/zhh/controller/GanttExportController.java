package com.example.zhh.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.example.zhh.pojo.GanttExportRequest;
import com.example.zhh.pojo.GanttTask;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

// 控制器类 - 修正版本
@RestController
@RequestMapping("/api/export")
public class GanttExportController {

    @PostMapping("/gantt-excel")
    public void exportGanttToExcel(@RequestBody GanttExportRequest request, HttpServletResponse response) {
        try {
            // 设置响应头
            String filename = new String((request.getExportOptions().getFilename() + ".xlsx").getBytes("UTF-8"), "ISO-8859-1");
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setHeader("Content-Disposition", "attachment; filename=" + filename);

            // 创建工作簿
            Workbook workbook = new XSSFWorkbook();

            // 导出横道图数据
            if ("gantt".equals(request.getExportOptions().getType()) || "both".equals(request.getExportOptions().getType())) {
                exportGanttData(workbook, request);
            }

            // 导出项目摘要
            if ("summary".equals(request.getExportOptions().getType()) || "both".equals(request.getExportOptions().getType())) {
                exportProjectSummary(workbook, request);
            }

            // 如果包含图表，添加图表预览
            if (request.getExportOptions().getIncludeChart()) {
                createChartPreview(workbook, request);
            }

            workbook.write(response.getOutputStream());
            response.getOutputStream().flush();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("导出横道图Excel失败", e);
        }
    }

    private void exportGanttData(Workbook workbook, GanttExportRequest request) {
        // 方法1：使用 ExportParams 直接创建sheet
        Sheet sheet = workbook.createSheet(request.getExportOptions().getSheetName() + "-任务列表");

        // 创建表头
        Row headerRow = sheet.createRow(0);
        String[] headers = {"任务ID", "任务名称", "开始天数", "结束天数", "进度(%)", "负责人", "开始日期", "结束日期", "状态", "工期(天)"};
        for (int i = 0; i < headers.length; i++) {
            headerRow.createCell(i).setCellValue(headers[i]);
        }

        // 填充数据
        int rowNum = 1;
        for (GanttTask task : request.getGanttData()) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(task.getId());
            row.createCell(1).setCellValue(task.getName());
            row.createCell(2).setCellValue(task.getStartDay());
            row.createCell(3).setCellValue(task.getEndDay());
            row.createCell(4).setCellValue(task.getProgress());
            row.createCell(5).setCellValue(task.getOwner());
            row.createCell(6).setCellValue(task.getStartDate());
            row.createCell(7).setCellValue(task.getEndDate());
            row.createCell(8).setCellValue(task.getStatus());
            row.createCell(9).setCellValue(task.getEndDay() - task.getStartDay() + 1);
        }

        // 自动调整列宽
        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }
    }

    // 方法2：使用正确的EasyPoi API（如果需要使用EasyPoi的注解功能）
    private void exportGanttDataWithEasyPoi(GanttExportRequest request, HttpServletResponse response) {
        try {
            // 设置响应头
            String filename = new String((request.getExportOptions().getFilename() + ".xlsx").getBytes("UTF-8"), "ISO-8859-1");
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setHeader("Content-Disposition", "attachment; filename=" + filename);

            // 使用EasyPoi导出
            ExportParams params = new ExportParams();
            params.setSheetName(request.getExportOptions().getSheetName());

            // 正确的调用方式 - 不传入workbook，让EasyPoi创建
            Workbook workbook = ExcelExportUtil.exportExcel(params, GanttTask.class, request.getGanttData());

            // 如果需要添加其他sheet，可以继续操作workbook
            if ("both".equals(request.getExportOptions().getType())) {
                exportProjectSummary(workbook, request);
            }

            if (request.getExportOptions().getIncludeChart()) {
                createChartPreview(workbook, request);
            }

            workbook.write(response.getOutputStream());
            response.getOutputStream().flush();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("导出横道图Excel失败", e);
        }
    }

    // 方法3：使用Map参数的版本（如果需要模板导出）
    private void exportGanttDataWithMap(Workbook workbook, GanttExportRequest request) {
        // 创建参数map
        Map<String, Object> map = new HashMap<>();
        map.put("title", "项目横道图数据");
        map.put("ganttList", request.getGanttData());
        map.put("exportDate", new Date());

        // 如果有模板文件，可以这样使用
        // TemplateExportParams params = new TemplateExportParams("template/gantt-template.xlsx");
        // Workbook workbook = ExcelExportUtil.exportExcel(params, map);

        // 对于动态创建，我们使用方法1更合适
    }

    private void exportProjectSummary(Workbook workbook, GanttExportRequest request) {
        Sheet sheet = workbook.createSheet("项目摘要");

        // 创建标题行
        Row titleRow = sheet.createRow(0);
        titleRow.createCell(0).setCellValue("项目统计信息");

        // 创建统计信息
        String[] labels = {"总任务数", "已完成任务", "总工期", "平均进度"};
        String[] values = {
                request.getChartConfig().getTotalTasks().toString(),
                request.getChartConfig().getCompletedTasks().toString(),
                request.getChartConfig().getTotalDuration() + "天",
                request.getChartConfig().getAverageProgress() + "%"
        };

        for (int i = 0; i < labels.length; i++) {
            Row row = sheet.createRow(i + 2);
            row.createCell(0).setCellValue(labels[i]);
            row.createCell(1).setCellValue(values[i]);
        }

        // 自动调整列宽
        sheet.autoSizeColumn(0);
        sheet.autoSizeColumn(1);
    }

    private void createChartPreview(Workbook workbook, GanttExportRequest request) {
        Sheet sheet = workbook.createSheet("横道图预览");

        // 创建标题
        Row titleRow = sheet.createRow(0);
        titleRow.createCell(0).setCellValue("横道图数据预览");

        // 创建表头
        Row headerRow = sheet.createRow(2);
        String[] headers = {"任务名称", "开始天数", "结束天数", "进度", "状态", "可视化进度条"};
        for (int i = 0; i < headers.length; i++) {
            headerRow.createCell(i).setCellValue(headers[i]);
        }

        // 填充任务数据
        int rowNum = 3;
        for (GanttTask task : request.getGanttData()) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(task.getName());
            row.createCell(1).setCellValue(task.getStartDay());
            row.createCell(2).setCellValue(task.getEndDay());
            row.createCell(3).setCellValue(task.getProgress() + "%");
            row.createCell(4).setCellValue(task.getStatus());

            // 创建简单的文本进度条
            int progressBars = task.getProgress() / 10;
            StringBuilder progressBar = new StringBuilder();
            for (int i = 0; i < 10; i++) {
                progressBar.append(i < progressBars ? "█" : "░");
            }
            row.createCell(5).setCellValue(progressBar.toString());
        }

        // 自动调整列宽
        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }
    }
}