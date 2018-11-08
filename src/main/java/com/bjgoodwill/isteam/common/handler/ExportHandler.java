package com.bjgoodwill.isteam.common.handler;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

/**
 * @ClassName ExportHandler
 * @Description 导出Excel设置接口。
 * @Author LI JUN
 * @Date 2018/11/7 10:47
 * @Version 0.0.1
 */
public interface ExportHandler {
    /**
     * 设置表头样式
     * @param wb 当前Wordbook对象
     * @return 处理后的样式
     */
    CellStyle headCellStyle(SXSSFWorkbook wb);

    /**
     * 设置导出的文件名（无需处理后缀）
     * @param sheetName sheetName
     * @return 处理后的文件名
     */
    String exportFileName(String sheetName);
}
