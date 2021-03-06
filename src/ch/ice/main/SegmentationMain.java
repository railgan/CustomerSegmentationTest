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
		SegmentExcelWriter writer = new SegmentExcelWriter();
		ListComparison Comparer = new ListComparison();

		ArrayList<Segment> listPOS = Parser.readPOSFile();
		ArrayList<Segment> listReg = Parser.readRegisterFile();
		ArrayList<Segment> listSegmented = Comparer.compareLists(listReg, listPOS);

		
		System.out.println("Time to deduplicate");
		listSegmented = Comparer.deDuplicate(listPOS, listSegmented);
		listPOS = null;
		System.out.println("Time to Segment");

				
		writer.writeXLSXFile(listSegmented);
		System.out.println("Done");

	}
}
