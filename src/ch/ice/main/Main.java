	package ch.ice.main;

import java.io.IOException;
import java.util.ArrayList;

import ch.ice.compare.ListComparison;
import ch.ice.compare.TestComparison;
import ch.ice.file.ExcelParser;
import ch.ice.file.ExcelWriter;
import ch.ice.file.LevenSteinExcelWriter;
import ch.ice.model.LevenSteinModel;
import ch.ice.model.Segment;

public class Main {

	public static void main(String[] args) throws IOException {
			
			
			
			ExcelParser Parser = new ExcelParser();
			TestComparison Comparer = new TestComparison();
			LevenSteinExcelWriter Writer = new LevenSteinExcelWriter();
			ArrayList<Segment> ListReg2 = Parser.readRegisterFile();
			ArrayList<String> ListPos2 = Parser.readPOSFile();
			ArrayList<LevenSteinModel> ListSegmented= Comparer.compareLists(ListReg2, ListPos2);
			//ArrayList<String> SegmentedList2 = ListComparison.compareLists(ListReg2, ListPos2);
			System.out.println("Time to Segment");
			System.out.println(ListSegmented.get(1).getLevenDistance());
			System.out.println(ListSegmented.get(2).getLevenDistance());
			Writer.writeXLSXFile(ListSegmented);
			System.out.println("Done");
			
			
			//ExcelWriter.writeXLSXFile(SegmentedList2);
			
			
	}
}
