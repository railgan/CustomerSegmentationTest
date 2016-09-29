package ch.ice.compare;

import java.util.ArrayList;

import ch.ice.model.Segment;

public class ListComparison {

	public static String posCompany;
	public static String posSegment;
	public static String regCompany;
	public static Segment regSegment;
	public static int medical;
	public static int othercompanies;
	public static ArrayList<String> segmentedList = new ArrayList();
	public static ArrayList<String> regList = new ArrayList();
	
	public static ArrayList<String> compareLists(ArrayList<Segment> Register, ArrayList<String> POS){
		regList = readCompanyName(Register);
		for (int i = 0; i < POS.size(); i++) {
			posCompany = (POS.get(i));
			if(regList.contains(posCompany) ){ 
			
				segmentedList.add(i, Register.get(i).getCompanySegment());
				medical++;
			}
			else{ 
				
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
		public static ArrayList<String> readCompanyName(ArrayList<Segment> Register){
			for (int j = 0; j < Register.size(); j++) {
				regCompany = (Register.get(j).getCompanyName());
				regList.add(j, regCompany);
				
				System.out.println("CompanyNamesRead");
				
			}
			return regList;
}
}