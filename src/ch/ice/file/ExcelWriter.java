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





public class ExcelWriter {

	
	
	
	public static void writeXLSXFile(ArrayList<String> segmentCustomerList) throws IOException {
		
		String excelFileName = "C:/Javatest/Segmented.xlsx";
		String oldExcelFile = "C:/Javatest/POS.xlsx";
		System.out.println(segmentCustomerList.size());
		
		
		int cellnum;
		int rownum;
		
		
		//Copy the existing file
		//copyFile( source, destination);
		
		InputStream inp = new FileInputStream(oldExcelFile);
		XSSFWorkbook wb = new XSSFWorkbook(inp);
		System.out.println("ExcelFileRead");
		XSSFSheet sheet = wb.getSheetAt(0);
		System.out.println("found wb Sheet");
		
		rownum = 2;
		cellnum = 5;
		
		
		//iterating r number of rows
		for (String object : segmentCustomerList){
			///CODE
			
			XSSFRow row = sheet.getRow(rownum++);
			

			//iterating c number of columns
		//	for (int c=0;c < segmentCustomerList.size(); c++ )
		//	for (cellnum = 5;cellnum<20;cellnum++)
			
				XSSFCell cell = sheet.getRow(row.getRowNum()).createCell(cellnum);
				
	
				cell.setCellValue(object);
			
				
			
		}
		System.out.println("Ready for fileOut");

		FileOutputStream fileOut = new FileOutputStream(excelFileName);

		//write this workbook to an Outputstream.
		wb.write(fileOut);
		fileOut.flush();
		fileOut.close();
		
		System.out.println("done");
	}
	

	}


