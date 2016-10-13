package ch.ice.model;

public class Segment {

	public  String companySegment;
	public  String companyName;
	public String unprocessedCompanyName;
	public  double levenDistance;
	private boolean exists;
	
	
	public boolean isExists() {
		return exists;
	}

	public void setExists(boolean exists) {
		this.exists = exists;
	}
	
	
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanySegment() {
		return companySegment;
	}
	public void setCompanySegment(String companySegment) {
		this.companySegment = companySegment;
	}
	public double getLevenDistance() {
		return levenDistance;
	}
	public void setLevenDistance(double levenDistance) {
		this.levenDistance = levenDistance;
	}
	public void setUnprocessedCompanyName(String unprocessedCompanyName) {
		this.unprocessedCompanyName = unprocessedCompanyName;
	}
	public String getUnprocessedCompanyName() {
		return unprocessedCompanyName;
	}
}