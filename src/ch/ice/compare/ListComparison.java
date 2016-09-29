package ch.ice.compare;

import java.util.ArrayList;

import ch.ice.model.Segment;

public class ListComparison {

	public static String posCompany;
	public static String posSegment;
	public static int medical;
	public static int othercompanies;
	public static ArrayList<String> segmentedList = new ArrayList();
	
	public static ArrayList<String> compareLists(ArrayList<Segment> Register, ArrayList<String> POS){
		for (int i = 0; i < POS.size(); i++) {
			posCompany = (POS.get(i));
			if(Register.contains(posCompany)){ 
				//posSegment = "Medical"; 
				segmentedList.add(i, "medical");
				medical++;
			}
			else{ 
				//posSegment = "Other";
				segmentedList.add(i, "other");
				othercompanies++;
			}
			
			
		}
		System.out.println(
				"Amount Medical: " + medical + 
				";\nAmount Other: " + othercompanies +
				";\nRegister Size: " + Register.size() +
				";\nTotal Amount of Companies: " + POS.size()
				);
		return segmentedList;
	}
}