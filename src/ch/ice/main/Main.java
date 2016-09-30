	package ch.ice.main;

import java.io.IOException;
import java.util.ArrayList;

import ch.ice.compare.ListComparison;
import ch.ice.file.ExcelParser;
import ch.ice.file.ExcelWriter;
import ch.ice.model.Segment;

public class Main {

	public static void main(String[] args) throws IOException {
			
			
			
			ExcelParser Parser = new ExcelParser();
			ArrayList<Segment> ListReg2 = Parser.readRegisterFile();
			ArrayList<String> ListPos2 = Parser.readPOSFile();
			
			ArrayList<String> SegmentedList2 = ListComparison.compareLists(ListReg2, ListPos2);
			
			
			
			ExcelWriter.writeXLSXFile(SegmentedList2);
			
			
	}
}
