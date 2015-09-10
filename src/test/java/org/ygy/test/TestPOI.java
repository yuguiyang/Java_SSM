package org.ygy.test;

import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestPOI {
	public static void main(String[] args) throws Exception {
	    Workbook wb = new XSSFWorkbook();
	    FileOutputStream fileOut = new FileOutputStream("BI报表.xlsx");
	    
	    CreationHelper createHelper = wb.getCreationHelper();

	    //1. 生成Sheet
	    Sheet sheet = wb.createSheet("全站注册信息统计表");
	    
	    //2. 新增行
	    Row row = sheet.createRow((short)0);
	    
	    //3. 新增单元格
	    Cell cell = row.createCell(0);
	    cell.setCellValue(1);

	    // Or do it on one line.
	    row.createCell(1).setCellValue(1.2);
	    row.createCell(2).setCellValue( createHelper.createRichTextString("This is a string"));
	    row.createCell(3).setCellValue(true);
	    
	    
	    wb.write(fileOut);
	    fileOut.close();
	    wb.close();
	}
}
