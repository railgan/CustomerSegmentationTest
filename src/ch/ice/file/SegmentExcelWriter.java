package ch.ice.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import ch.ice.model.Segment;

public class SegmentExcelWriter {

	DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH");
	 
	Date date = new Date();
	
	
	public void writeXLSXFile(ArrayList<Segment> segmentCustomerList) throws IOException {
		
		
		
		String excelFileName = "C:/Javatest/Segmented"+dateFormat.format(date)+".xlsx";
	//	String oldExcelFile = "C:/Javatest/POS.xlsx";
		String oldExcelFile = "C:/Javatest/SPOSDES_Test.xlsx";
		
		int cellnum;
		int rownum;
		double segmentMargain = 0.01;
		double levenDistance;
						
		InputStream inp = new FileInputStream(oldExcelFile);
		XSSFWorkbook wb = new XSSFWorkbook(inp);
		System.out.println("ExcelFileRead");
		XSSFSheet sheet = wb.getSheetAt(0);
		System.out.println("found wb Sheet");
		
		rownum = 3;
		cellnum = 11;
		
		XSSFRow row = sheet.getRow(2);
		XSSFCell cell = sheet.getRow(row.getRowNum()).createCell(11);
		cell.setCellValue("Segment");
		cell = sheet.getRow(row.getRowNum()).createCell(12);
		cell.setCellValue("Distance");
		cell= sheet.getRow(row.getRowNum()).createCell(13);
		cell.setCellValue("Comparison Name");
		
		
		//iterating r number of rows
		for (Segment object : segmentCustomerList){
				
			levenDistance = object.getLevenDistance();
			
			
			row = sheet.getRow(rownum++);
			if(isRowEmpty(row)){
				continue;
			}
			cell = sheet.getRow(row.getRowNum()).createCell(cellnum);
			
			if(object.isExists()){
			if(object.getLevenDistance()<=segmentMargain){
				cell.setCellValue(object.getCompanySegment());
			} else {
				cell.setCellValue("other");
			}
				cell = sheet.getRow(row.getRowNum()).createCell(cellnum+1);
				cell.setCellValue(levenDistance);
				cell = sheet.getRow(row.getRowNum()).createCell(cellnum+2);
				cell.setCellValue(object.getUnprocessedCompanyName());
			} else { 
				cell.setCellValue("NAN");
				cell = sheet.getRow(row.getRowNum()).createCell(cellnum+1);
				cell.setCellValue("NAN");
				cell = sheet.getRow(row.getRowNum()).createCell(cellnum+2);
				cell.setCellValue("no company name provided");
			}
			}
		
		for (int i = 0; i < 20; i++)
			sheet.autoSizeColumn(i);
		sheet.setColumnWidth(6, 2000);
		sheet.setColumnWidth(8, 2000);
		sheet.setColumnWidth(9, 2000);
		sheet.setColumnWidth(10, 2000);
		
		System.out.println("Ready for fileOut");

		FileOutputStream fileOut = new FileOutputStream(excelFileName);

		//write this workbook to an Outputstream.
		wb.write(fileOut);
	
		fileOut.flush();
		fileOut.close();
		
	}

	public static boolean isRowEmpty(XSSFRow row) {
		
		if (row==null){
			return true;
		}
	    for (int c = row.getFirstCellNum(); c < row.getLastCellNum(); c++) {
	        Cell cell = row.getCell(c);
	        if (cell != null && cell.getCellType() != Cell.CELL_TYPE_BLANK)
	            return false;
	    }
	    return true;
	}
}
