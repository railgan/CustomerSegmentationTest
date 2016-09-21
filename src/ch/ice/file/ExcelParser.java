package ch.ice.file;

import java.awt.List;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelParser {

	private static String companyName;
	private static ArrayList<String> companies = new ArrayList();
	
	public static void readXLSXFile() throws IOException
	{
		
		//Where the Test file has to be located
		InputStream ExcelFileToRead = new FileInputStream("C:/Javatest/Test.xlsx");
		XSSFWorkbook  wb = new XSSFWorkbook(ExcelFileToRead);
		
		XSSFWorkbook test = new XSSFWorkbook(); 
		
		XSSFSheet sheet = wb.getSheetAt(0);
		XSSFRow row; 
		XSSFCell cell;

		Iterator rows = sheet.rowIterator();

		while (rows.hasNext())
		{
			row=(XSSFRow) rows.next();
			if (row.getRowNum() == 0 || row.getRowNum() == 1)
				continue;
			Iterator cells = row.cellIterator();
			while (cells.hasNext())
			{
				cell=(XSSFCell) cells.next();
				if(cell.getColumnIndex()==6){
		
				if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING)
				{
					companyName = cell.getStringCellValue();
					companies.add(companyName);
				}
				else if(cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC)
				{
					System.out.print(cell.getNumericCellValue()+" ");
				}
				else
				{
					//U Can Handel Boolean, Formula, Errors
				}
			}
			System.out.println();
		}
		}
	
	}



}