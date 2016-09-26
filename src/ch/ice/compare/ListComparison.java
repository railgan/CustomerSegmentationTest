package ch.ice.compare;

import java.util.ArrayList;

public class ListComparison {

	public static String posCompany;
	public static String posSegment;
	public static int medical;
	public static int othercompanies;
	
	public static void compareLists(ArrayList<String> Register, ArrayList<String> POS){
		for (int i = 0; i < POS.size(); i++) {
			posCompany = (POS.get(i));
			if(Register.contains(posCompany)){ 
				//posSegment = "Medical"; 
				medical++;
			}
			else{ 
				posSegment = "Other";
				othercompanies++;
			}
			
			System.out.println("Medical: " + medical + " ; Other: " + othercompanies);
		}
 
	}
}