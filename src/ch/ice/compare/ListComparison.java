package ch.ice.compare;

import java.util.ArrayList;

public class ListComparison {

	public static String posCompany;
	public static String posSegment;
	public static int medical;
	public static int othercompanies;
	public static ArrayList<String> segmentedList = new ArrayList();
	
	public static ArrayList<String> compareLists(ArrayList<String> Register, ArrayList<String> POS){
		for (int i = 0; i < POS.size(); i++) {
			posCompany = (POS.get(i));
			if(Register.contains(posCompany)){ 
				//posSegment = "Medical"; 
				segmentedList.add(i, "medical");
				medical++;
				System.out.println("Medical Company: " + POS.get(i));
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