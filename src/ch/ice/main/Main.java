	package ch.ice.main;

import java.io.IOException;
import java.util.ArrayList;

import ch.ice.compare.ListComparison;
import ch.ice.file.SegmentExcelParser;
import ch.ice.file.SegmentExcelWriter;
import ch.ice.model.Segment;

public class Main {

	public static void main(String[] args) throws IOException {
			
			
			
			SegmentExcelParser Parser = new SegmentExcelParser();
			ListComparison Comparer = new ListComparison();
			SegmentExcelWriter Writer = new SegmentExcelWriter();
			
			
			ArrayList<Segment> ListReg2 = Parser.readRegisterFile();
			ArrayList<String> ListPos2 = Parser.readPOSFile();
			ArrayList<Segment> ListSegmented= Comparer.compareLists(ListReg2, ListPos2);
			
			System.out.println("Time to Segment");
		
			Writer.writeXLSXFile(ListSegmented);
			System.out.println("Done");
			
			
			
	}
}
