package org.ygy.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class POIUtil {
	
	
	public static void createHeader(Sheet sheet , List<String> headers) {
		//标题样式设置
		Workbook wb = sheet.getWorkbook();
		XSSFFont headerFont = (XSSFFont) wb.createFont();
		headerFont.setColor(HSSFColor.WHITE.index);// HSSFColor.VIOLET.index //字体颜色
		headerFont.setFontHeightInPoints((short) 12);
		headerFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); // 字体增粗
		
		CellStyle  headerStyle =  wb.createCellStyle(); 
		headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
		headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
		headerStyle.setFont(headerFont);
		
		//2. 遍历标题
		Row row = sheet.createRow(0);
		for (int index = 0; index < headers.size(); index++) {
			Cell cell = row.createCell(index);
			cell.setCellValue(headers.get(index));
			cell.setCellStyle(headerStyle); 
		}		
	}
	
	public static void createRow(Sheet sheet , List<ArrayList<String>> datas) {
		CellStyle  style =  sheet.getWorkbook().createCellStyle(); 
		XSSFFont font = (XSSFFont) sheet.getWorkbook().createFont();//创建字体对象  
        font.setFontName("微软雅黑");  
        style.setFont(font); 
        
		//3. 遍历内容
		for(int index = 0; index < datas.size(); index++) {
			Row eachRow = sheet.createRow(index+1);
			
			for(int j=0; j<datas.get(index).size(); j++) {
				Cell cell = eachRow.createCell(j);
				cell.setCellStyle(style); 
				cell.setCellValue(datas.get(index).get(j));			
			}
		}
	}
	
	public static void export(String excelName , String sheetName, List<String> headers ,List<ArrayList<String>> datas) {
		try {
			// 1. 生成Sheet
			Workbook wb = new XSSFWorkbook();
			FileOutputStream fileOut = new FileOutputStream(excelName);

			Sheet sheet = wb.createSheet(sheetName);
			sheet.setDefaultColumnWidth(20);
			
			createHeader(sheet , headers);
			createRow(sheet , datas);

			wb.write(fileOut);
			fileOut.close();
			wb.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void createRow2(Sheet sheet , List<String> headers , List<ArrayList<String>> datas,CellStyle  style) {
		Row row = sheet.createRow(0);
		
		Workbook wb = sheet.getWorkbook();
		XSSFFont headerFont = (XSSFFont) wb.createFont();
		headerFont.setColor(HSSFColor.WHITE.index);// HSSFColor.VIOLET.index //字体颜色
		headerFont.setFontHeightInPoints((short) 12);
		headerFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); // 字体增粗
		
		CellStyle  headerStyle =  wb.createCellStyle(); 
		headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
		headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
		headerStyle.setFont(headerFont);
		
		
		
		//2. 遍历标题
		for (int index = 0; index < headers.size(); index++) {
			Cell cell = row.createCell(index);
			cell.setCellValue(headers.get(index));
			cell.setCellStyle(headerStyle); 
					
		}
		
		//3. 遍历内容
		for(int index = 0; index < datas.size(); index++) {
			Row eachRow = sheet.createRow(index+1);
			
			for(int j=0; j<datas.get(index).size(); j++) {
				Cell cell = eachRow.createCell(j);
				cell.setCellStyle(style);
				cell.setCellValue(datas.get(index).get(j));
			}
			
		}
	}
	
	public static void export2(String excelName , String sheetName, List<String> headers ,List<ArrayList<String>> datas) {
		try {
			Workbook wb = new XSSFWorkbook();
			FileOutputStream fileOut = new FileOutputStream(excelName);

			// 1. 生成Sheet
			Sheet sheet = wb.createSheet(sheetName);
			sheet.setDefaultColumnWidth(20);
			
			CellStyle  style =  wb.createCellStyle(); 
			XSSFFont font = (XSSFFont) wb.createFont();//创建字体对象  
	        font.setFontName("微软雅黑");  
	        style.setFont(font); 
	        
	        createRow2(sheet , headers , datas ,style);

			wb.write(fileOut);
			fileOut.close();
			wb.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
