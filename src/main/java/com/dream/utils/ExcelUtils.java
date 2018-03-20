package com.dream.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	private static final String EXCEL_XLS="xls";
	private static final String EXCEL_XLSX="xlsx";
	private static SimpleDateFormat fmt=new SimpleDateFormat("yyyy-mm-dd");

	public static void checkExcelValid(File file) throws Exception{
		if(!file.exists()){
			throw new Exception("文件不存在");
		}
		if(!(file.isFile()&&!(file.getName().endsWith(EXCEL_XLS)))||!(file.getName().endsWith(EXCEL_XLSX))){
			throw new Exception("文件不是Excel");
		}
		
	}
	public static Workbook getWorkbook(File file) throws IOException{
		Workbook wb=null;
		FileInputStream in=new FileInputStream(file);
		if(file.getName().endsWith(EXCEL_XLS)){
			wb=new HSSFWorkbook(in);
		}
		else if(file.getName().endsWith(EXCEL_XLSX)){
			wb=new XSSFWorkbook(in);
		}
		return wb;
	}
	public static String convertCellValueToString(Cell cell){
		int cellType=cell.getCellType();
		String cellValue="";
		switch(cellType){
		case Cell.CELL_TYPE_STRING:
			cellValue=cell.getRichStringCellValue().getString();
			break;
		case Cell.CELL_TYPE_NUMERIC:
			if(DateUtil.isCellDateFormatted(cell)){
				cellValue=fmt.format(cell.getDateCellValue());
			}else{
				cell.setCellType(Cell.CELL_TYPE_STRING);
				cellValue=String.valueOf(cell.getRichStringCellValue());
				
				
			}
			break;
		case Cell.CELL_TYPE_BOOLEAN:
			cellValue=String.valueOf(cell.getBooleanCellValue());
			break;
		case Cell.CELL_TYPE_BLANK:
			cellValue=cell.getStringCellValue();
			break;
		case Cell.CELL_TYPE_ERROR:
			cellValue="错误";
			break;		
		case Cell.CELL_TYPE_FORMULA:
			cell.setCellType(Cell.CELL_TYPE_STRING);
			cellValue=String.valueOf(cell.getRichStringCellValue().getString());
			break;
		default:
			cellValue=cell.getStringCellValue().toString();
		
		}
		return cellValue;
	}
	public static List<TestCase> getUITestData(String filepath){
		List<TestCase> testCases=new ArrayList<TestCase>();
		try {
			String excelPath=System.getProperty("user.dir")+"/testcasedata/"+filepath;
			File excelFile=new File(excelPath);
			checkExcelValid(excelFile);
			Workbook workbook=getWorkbook(excelFile);
			Sheet sheet=workbook.getSheetAt(0);
			Row firstRow=sheet.getRow(0);
			int count=0;
			for(Row row:sheet){
				if(count==0){
					count++;
					continue;
				}
				if(row.getCell(0).toString().equals("")||row.getCell(1).toString().equals("notRun")){
					continue;
				}
				String caseName=convertCellValueToString(row.getCell(0));
				String isCheck=convertCellValueToString(row.getCell(2));
				String expectedResult=convertCellValueToString(row.getCell(3));
				Map<String,String> testData=new HashMap<String,String>();
				int skipNum=0;
				for(Cell cell:row){
					if(skipNum<4){
						skipNum++;
						continue;
					}
					if(cell.toString()==null){
						continue;
					}
					testData.put(convertCellValueToString(firstRow.getCell(skipNum++)), convertCellValueToString(cell));
				}
				testCases.add(new TestCase(caseName,isCheck,expectedResult,testData));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return testCases;
	}
}
