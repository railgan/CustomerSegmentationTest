	package ch.ice.main;

import java.io.IOException;
import java.util.ArrayList;

import ch.ice.compare.ListComparison;
import ch.ice.file.SegmentExcelParser;
import ch.ice.file.SegmentExcelWriter;
import ch.ice.model.Customer;
import ch.ice.model.Segment;

public class SegmentationMain {

	public static void main(String[] args) throws IOException {
						
			
			SegmentExcelParser Parser = new SegmentExcelParser();
					
			ArrayList<Customer> ListPos2 = Parser.readPOSFile();
			ArrayList<Segment> ListReg2 = Parser.readRegisterFile();
			ListComparison Comparer = new ListComparison();
			SegmentExcelWriter Writer = new SegmentExcelWriter();
			Comparer.deDuplicate(ListPos2);
			ArrayList<Segment> ListSegmented= Comparer.compareLists(ListReg2, ListPos2);
			
			System.out.println("Time to Segment");
		
			Writer.writeXLSXFile(ListSegmented);
			System.out.println("Done");
			
			
			
	}
}
