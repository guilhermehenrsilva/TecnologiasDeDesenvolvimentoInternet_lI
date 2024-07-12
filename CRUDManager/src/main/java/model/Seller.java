package model;

public class Seller {
	
	private int id;
	private String name;
	private String email;
	private String fone;
	private String campany;
	
	
	public Seller() {
		this(0);
	}
	
	public Seller(int i) {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFone() {
		return fone;
	}
	public void setFone(String fone) {
		this.fone = fone;
	}
	public String getCampany() {
		return campany;
	}
	public void setCampany(String campany) {
		this.campany = campany;
	}
	
	
	

}
