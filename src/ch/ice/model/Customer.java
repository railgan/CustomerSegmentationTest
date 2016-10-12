package ch.ice.model;

/**
 * @author Marco
 *
 */
public class Customer {
	
	private String id;
	private String fullName;
	private String unproceesedFullName;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getFullName() {
		return fullName;
	}
	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getUnproceesedFullName() {
		return unproceesedFullName;
	}

	public void setUnproceesedFullName(String unproceesedFullName) {
		this.unproceesedFullName = unproceesedFullName;
	}
	
}
