package ch.ice.compare;

import java.util.ArrayList;

public class ListComparison {

	public String posCompany;
	public String posSegment;
	public void compareLists(ArrayList<String> Register, ArrayList<String> POS){
		for (int i = 0; i < POS.size(); i++) {
			posCompany = (POS.get(i));
			if(Register.contains(posCompany)){ 
				posSegment = "Medical"; }
			else{ posSegment = "other";}
		}
 
	}
}