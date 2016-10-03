package ch.ice.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import ch.ice.model.LevenSteinModel;

public class LevenSteinExcelWriter {

	public void writeXLSXFile(ArrayList<LevenSteinModel> segmentCustomerList) throws IOException {
		
		String excelFileName = "C:/Javatest/Segmented.xlsx";
		String oldExcelFile = "C:/Javatest/POS.xlsx";
		System.out.println(segmentCustomerList.size());
		
		
		int cellnum;
		int rownum;
		double segmentMargain;
		double levenDistance;
		
		
		//Copy the existing file
		//copyFile( source, destination);
		
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
		
		//iterating r number of rows
		for (LevenSteinModel object : segmentCustomerList){
			///CODE
			segmentMargain = 0.9;
			levenDistance = object.getLevenDistance();
			
			
			row = sheet.getRow(rownum++);
			cell = sheet.getRow(row.getRowNum()).createCell(cellnum);
			
			if(object.getLevenDistance()>=segmentMargain){
				cell.setCellValue(object.getCompanySegment());
			} else {
				cell.setCellValue("other");
			}
				cell = sheet.getRow(row.getRowNum()).createCell(cellnum+1);
				cell.setCellValue(levenDistance);
				
			
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
	;
		fileOut.flush();
		fileOut.close();
		
	}
	
}
