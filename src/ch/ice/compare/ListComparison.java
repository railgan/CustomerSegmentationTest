package ch.ice.compare;

import java.util.ArrayList;

import ch.ice.file.SegmentExcelParser;
import ch.ice.model.Customer;
import ch.ice.model.Segment;

public class ListComparison {
	public String posCompany;
	public String posSegment;
	public String regCompany;
	public String companySegment;
	public String companyName;
	public String unprocessedCompanyName;
	
	public Segment regSegment;

	public int dublicates;
	public int dublicates2;
	public int medical;
	public int othercompanies;
	public double stringDistance;
	public double minStringDistance = 1;
	public int indexOfBestResult;
	
	public ArrayList<Segment> segmentedList = new ArrayList<Segment>();
	public ArrayList<String> regList = new ArrayList<String>();
	
	public SegmentExcelParser Parser = new SegmentExcelParser();
	
	public JaroWinkler jaroWinkelr = new JaroWinkler();
	public Segment singleSegment = new Segment();
	
	private Segment createLevensteinSegment(){
		Segment singleSegment = new Segment();
		
		singleSegment.setCompanyName(this.companyName);
		singleSegment.setLevenDistance(minStringDistance);
		singleSegment.setCompanySegment(this.companySegment);
		singleSegment.setUnprocessedCompanyName(this.unprocessedCompanyName);
		return singleSegment;
	
	}
	
	public   ArrayList<Segment> compareLists(ArrayList<Segment> Register, ArrayList<Customer> listPos2){
		regList = readCompanyName(Register);
			
		System.out.println("Now we are comparing Lists");
		for (int i = 0; i < listPos2.size(); i++) {
			
			posCompany = (listPos2.get(i).getFullName());
				for (int k = 0; k<Register.size(); k++){
					
					stringDistance = jaroWinkelr.distance(posCompany, Register.get(k).getCompanyName());
					if(stringDistance < minStringDistance){
						minStringDistance = stringDistance;
						indexOfBestResult = k;
					}
					if (k == Register.size()-1){
						this.companyName =Register.get(indexOfBestResult).getCompanyName();
						this.companySegment = Register.get(indexOfBestResult).getCompanySegment();
						this.unprocessedCompanyName = Register.get(indexOfBestResult).getUnprocessedCompanyName();
						if (minStringDistance <= 0.01){
							medical++;
						}
						segmentedList.add(i,this.createLevensteinSegment());
						minStringDistance = 1;
					}
				
				}		
		
		}
	
		System.out.println(
				"Amount Medical: " + medical + 
				";\nAmount Other: " + othercompanies +
				";\nRegister Size: " + Register.size() +
				";\nTotal Amount of Companies: " + listPos2.size() +
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
			public void deDuplicate(ArrayList<Customer> customers, ArrayList<Segment> segmentedCustomers){
				int d = 1;
				for(int c = 0; c < customers.size()-1; c=d){
					d = c+1;
					while( customers.get(c).getId().equals(customers.get(d).getId())){
						if(segmentedCustomers.get(c).getLevenDistance()<segmentedCustomers.get(d).getLevenDistance()){
							customers.get(c).setUnproceesedFullName(customers.get(c).getUnproceesedFullName() +", " + customers.get(d).getUnproceesedFullName());
							d++;
							System.out.println(customers.get(c).getUnproceesedFullName());
							dublicates++;
						} else {
							
							customers.get(d).setUnproceesedFullName(customers.get(d).getUnproceesedFullName() +", " + customers.get(c).getUnproceesedFullName());
							dublicates2++;
							System.out.println("Special Case: "+customers.get(d).getUnproceesedFullName());
						
						break;
						}
							
				}
				}
			System.out.println("Dublicate count: " +dublicates + "\n Special Case count: "+ dublicates2);
			
			}
			
}


