package model;

public class Account {

	private int accountID;
	private String username;
	private String name;
	private String privilegeLevel;
	
	public Account(int accountID){
		this.accountID = accountID;
	}
	
	public int getAccountID() {
		return accountID;
	}
	
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrivilegeLevel() {
		return privilegeLevel;
	}
	public void setPrivilegeLevel(String privilegeLevel) {
		this.privilegeLevel = privilegeLevel;
	}
}
