	package ch.ice.main;

import java.io.IOException;
import java.util.ArrayList;

import ch.ice.compare.ListComparison;
import ch.ice.file.ExcelParser;
import ch.ice.file.ExcelWriter;
import ch.ice.model.Segment;

public class Main {

	public static void main(String[] args) throws IOException {
			
		//	ArrayList<String> ListReg = ExcelParser.readRegisterFile();
	//		ArrayList<String> ListPos = ExcelParser.readPOSFile();
		//ArrayList<String> SegmentedList = ListComparison.compareLists(ListReg, ListPos);
			//ExcelWriter.writeXLSXFile(SegmentedList);
			
			ExcelParser Parser = new ExcelParser();
			ArrayList<Segment> ListReg2 = Parser.readRegisterFile();
			System.out.println("Time to Test if it worked:");
			System.out.println(ListReg2.get(15).getCompanyName());
			System.out.println(ListReg2.get(15).getCompanySegment());
			ArrayList<String> ListPos2 = Parser.readPOSFile();
			ArrayList<String> SegmentedList2 = ListComparison.compareLists(ListReg2, ListPos2);
			//ExcelWriter.writeXLSXFile(SegmentedList2);
	}
}
