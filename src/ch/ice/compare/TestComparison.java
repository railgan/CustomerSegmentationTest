package ch.ice.compare;

import java.util.ArrayList;

import ch.ice.model.LevenSteinModel;
import ch.ice.model.Segment;

public class TestComparison {
	public String posCompany;
	public String posSegment;
	public String regCompany;
	public String companySegment;
	public String companyName;
	
	public Segment regSegment;

	
	public int medical;
	public int othercompanies;
	public double stringDistance;
	public double minStringDistance;
	public int indexOfBestResult;
	
	public ArrayList<LevenSteinModel> segmentedList = new ArrayList<LevenSteinModel>();
	public ArrayList<String> regList = new ArrayList<String>();
	
	public LevenStein levenStein = new LevenStein();
	public LevenSteinModel levenSteinList = new LevenSteinModel();
	
	private LevenSteinModel createLevensteinSegment(){
		LevenSteinModel levenSteinList = new LevenSteinModel();
		
		levenSteinList.setCompanyName(this.companyName);
		levenSteinList.setLevenDistance(minStringDistance);
		levenSteinList.setCompanySegment(this.companySegment);
		return levenSteinList;
	
	}
	
	public   ArrayList<LevenSteinModel> compareLists(ArrayList<Segment> Register, ArrayList<String> POS){
		regList = readCompanyName(Register);
		System.out.println("Now we are comparing Lists");
		for (int i = 0; i < POS.size(); i++) {
			posCompany = (POS.get(i));
				for (int k = 0; k<Register.size(); k++){
					stringDistance = levenStein.similarity(posCompany, Register.get(k).getCompanyName());
					
					if(stringDistance > minStringDistance){
						minStringDistance = stringDistance;
						indexOfBestResult = k;
					}
					if (k == Register.size()-1){
						this.companyName =Register.get(indexOfBestResult).getCompanyName();
						this.companySegment = Register.get(indexOfBestResult).getCompanySegment();
						if (minStringDistance > 0.9){
							medical++;
						}
						segmentedList.add(i,this.createLevensteinSegment());
						minStringDistance = 0;
						indexOfBestResult = 0;
						stringDistance = 0;
					}
				
				}		
		
		}
	
		System.out.println(
				"Amount Medical: " + medical + 
				";\nAmount Other: " + othercompanies +
				";\nRegister Size: " + Register.size() +
				";\nTotal Amount of Companies: " + POS.size() +
				";\nSegmented List size: " +segmentedList.size()
				);
	
		
		return segmentedList;
	}
		public   ArrayList<String> readCompanyName(ArrayList<Segment> Register){
			for (int j = 0; j < Register.size(); j++) {
				regCompany = (Register.get(j).getCompanyName());
				regList.add(j, regCompany);
				
			}
			System.out.println("CompanyNamesRead");
			
			return regList;
			
}
}

