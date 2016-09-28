package ch.ice.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;





public class ExcelWriter {

	
	
	
	public static void writeXLSXFile(ArrayList<String> segmentCustomerList) throws IOException {
		
		String excelFileName = "C:/Javatest/Segmented.xlsx";
		String oldExcelFile = "C:/Javatest/POS.xlsx";
		File source = new File (oldExcelFile);
		File destination = new File(excelFileName);
		int cellnum;
		int rownum;
		int mapCellNum;
		String fileName;
		CellStyle style = null;
		
		//Copy the existing file
		copyFile( source, destination);
		
		
		String sheetName = "Sheet1";//name of sheet

		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet(sheetName) ;
		
		rownum = 3;
	
		cellnum = 5;
		
		//iterating r number of rows
		for (String object : segmentCustomerList){
			///CODE

			XSSFRow row = sheet.getRow(rownum++);
			

			//iterating c number of columns
			for (int c=0;c < segmentCustomerList.size(); c++ )
			{
				XSSFCell cell = row.createCell(c);
	
				cell.setCellValue(segmentCustomerList.get(c));
			}
		}
		

		FileOutputStream fileOut = new FileOutputStream(excelFileName);

		//write this workbook to an Outputstream.
		wb.write(fileOut);
		fileOut.flush();
		fileOut.close();
	}
	
	public static void copyFile(File source, File dest) throws IOException {
	    Files.copy(source.toPath(), dest.toPath());
	}
	}


