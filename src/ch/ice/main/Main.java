	package ch.ice.main;

import java.io.IOException;
import java.util.ArrayList;

import ch.ice.compare.ListComparison;
import ch.ice.file.ExcelParser;
import ch.ice.file.ExcelWriter;

public class Main {

	public static void main(String[] args) throws IOException {
			
			ArrayList<String> ListReg = ExcelParser.readRegisterFile();
			
			ArrayList<String> ListPos = ExcelParser.readPOSFile();
						
			ArrayList<String> SegmentedList = ListComparison.compareLists(ListReg, ListPos);
			
			ExcelWriter.writeXLSXFile(SegmentedList);
			
			
	}
}
