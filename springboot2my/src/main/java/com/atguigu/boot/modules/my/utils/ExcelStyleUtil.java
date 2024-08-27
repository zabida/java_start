package com.atguigu.boot.modules.my.utils;

import cn.afterturn.easypoi.excel.export.styler.ExcelExportStylerDefaultImpl;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelStyleUtil extends ExcelExportStylerDefaultImpl {

    public ExcelStyleUtil(Workbook workbook) {
        super(workbook);
    }
    /**
     * 标题样式
     */
    @Override
    public CellStyle getTitleStyle(short color) {
        CellStyle cellStyle = super.getTitleStyle(color);
        cellStyle.setFont(getFont(workbook, 11, false));
        return cellStyle;
    }
    /**
     * 单元格的样式
     */
    @Override
    public CellStyle stringSeptailStyle(Workbook workbook, boolean isWarp) {
        CellStyle cellStyle = super.stringSeptailStyle(workbook, isWarp);
        cellStyle.setFont(getFont(workbook, 11, false));
        return cellStyle;
    }
    /**
     * 列表头样式
     */
    @Override
    public CellStyle getHeaderStyle(short color) {
        CellStyle cellStyle =  super.getHeaderStyle(color);
        cellStyle.setFont(getFont(workbook, 11, false));
        return cellStyle;
    }
    /**
     * 单元格的样式
     */
    @Override
    public CellStyle stringNoneStyle(Workbook workbook, boolean isWarp) {
        CellStyle cellStyle = super.stringNoneStyle(workbook, isWarp);
        cellStyle.setFont(getFont(workbook, 11, false));
        return cellStyle;
    }

    /**
     * 字体样式
     *
     * @param size   字体大小
     * @param isBold 是否加粗
     * @return
     */
    private Font getFont(Workbook workbook, int size, boolean isBold) {
        Font font = workbook.createFont();
        //字体样式
        font.setFontName("宋体");
        //是否加粗
        font.setBold(isBold);
        //字体大小
        font.setFontHeightInPoints((short) size);
        return font;
    }

}
