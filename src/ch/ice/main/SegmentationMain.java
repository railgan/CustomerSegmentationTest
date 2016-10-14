	package ch.ice.main;

import java.io.IOException;
import java.util.ArrayList;

import ch.ice.compare.ListComparison;
import ch.ice.file.SegmentExcelParser;
import ch.ice.file.SegmentExcelWriter;
import ch.ice.model.Segment;

public class SegmentationMain {

	public static void main(String[] args) throws IOException {
						
			
			SegmentExcelParser Parser = new SegmentExcelParser();
					
			ArrayList<Segment> listPOS = Parser.readPOSFile();
			ArrayList<Segment> listReg = Parser.readRegisterFile();
			
			
			ListComparison Comparer = new ListComparison();
			SegmentExcelWriter Writer = new SegmentExcelWriter();
			ArrayList<Segment> ListSegmented= Comparer.compareLists(listReg, listPOS);
			listPOS = Comparer.deDuplicate(listPOS, ListSegmented);
			System.out.println("Time to Segment");
		
			Writer.writeXLSXFile(ListSegmented);
			System.out.println("Done");
			
	}
}
