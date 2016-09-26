package ch.ice.file;

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

	//Variables in which SCHURTER's List of Companies can be found
	private static String companyNamePOS;
	private static ArrayList<String> companiesPOS = new ArrayList();
	
	// Variables in which the Corporate List of Companie Names can be Found
	private static String companyNameRegister;
	private static ArrayList<String> companiesRegister = new ArrayList();
	
	public static ArrayList<String> readPOSFile() throws IOException
	{
		
		//Where the Test file has to be located
		InputStream ExcelFileToRead = new FileInputStream("C:/Javatest/POS.xlsx");
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
					companyNamePOS = cell.getStringCellValue();
					companiesPOS.add(companyNamePOS);
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
		 
		}
		}
		System.out.println("POS File Read");
		System.out.println(companiesPOS);
		return companiesPOS;
		
	}
	
	
	
	public static ArrayList<String> readRegisterFile() throws IOException
	{
		//Where the Test file has to be located
		InputStream ExcelFileToRead = new FileInputStream("C:/Javatest/Medical.xlsx");
		XSSFWorkbook  wb = new XSSFWorkbook(ExcelFileToRead);
		
		XSSFWorkbook test = new XSSFWorkbook(); 
		
		XSSFSheet sheet = wb.getSheetAt(0);
		XSSFRow row; 
		XSSFCell cell;
				
				Iterator rows = sheet.rowIterator();

				while (rows.hasNext())
				{ 
					row=(XSSFRow) rows.next();
					Iterator cells = row.cellIterator();
					while (cells.hasNext())
					{
						cell=(XSSFCell) cells.next();
						if(cell.getColumnIndex()==0){
							
				
						if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING)
						{
							companyNameRegister = cell.getStringCellValue();
							companiesRegister.add(companyNameRegister);
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
				 
				}
				}
				System.out.println("CompanieRegisterRead");
				System.out.println(companiesRegister);
		return companiesRegister;
	}
	



}