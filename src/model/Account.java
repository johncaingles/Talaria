package model;

public class Account {

	private int accountID;
	private String username;
	private String first_name;
	private String middle_name;
	private String last_name;
	private String email;
	private String privilegeLevel;
	
	private String bil_house_num;
	private String bil_street;
	private String bil_subdivision;
	private String bil_city;
	private String bil_postal_code;
	private String bil_country;
	
	private String ship_house_num;
	private String ship_street;
	private String ship_subdivision;
	private String ship_city;
	private String ship_postal_code;
	private String ship_country;
	
	public Account(){};
	
	public Account(int accountID)
	{
		this.accountID = accountID;
	}
	
	public Account(String username, String first_name, String middle_name,
			String last_name, String email, String privilegeLevel,
			String bil_house_num, String bil_street, String bil_subdivision,
			String bil_city, String bil_postal_code, String bil_country,
			String ship_house_num, String ship_street, String ship_subdivision,
			String ship_city, String ship_postal_code, String ship_country) {
		super();
		this.username = username;
		this.first_name = first_name;
		this.middle_name = middle_name;
		this.last_name = last_name;
		this.email = email;
		this.privilegeLevel = privilegeLevel;
		this.bil_house_num = bil_house_num;
		this.bil_street = bil_street;
		this.bil_subdivision = bil_subdivision;
		this.bil_city = bil_city;
		this.bil_postal_code = bil_postal_code;
		this.bil_country = bil_country;
		this.ship_house_num = ship_house_num;
		this.ship_street = ship_street;
		this.ship_subdivision = ship_subdivision;
		this.ship_city = ship_city;
		this.ship_postal_code = ship_postal_code;
		this.ship_country = ship_country;
	}

	public Account(int accountID, String username, String first_name,
			String middle_name, String last_name, String email,
			String privilegeLevel, String bil_house_num, String bil_street,
			String bil_subdivision, String bil_city, String bil_postal_code,
			String bil_country, String ship_house_num, String ship_street,
			String ship_subdivision, String ship_city, String ship_postal_code,
			String ship_country) {

		this.accountID = accountID;
		this.username = username;
		this.first_name = first_name;
		this.middle_name = middle_name;
		this.last_name = last_name;
		this.email = email;
		this.privilegeLevel = privilegeLevel;
		this.bil_house_num = bil_house_num;
		this.bil_street = bil_street;
		this.bil_subdivision = bil_subdivision;
		this.bil_city = bil_city;
		this.bil_postal_code = bil_postal_code;
		this.bil_country = bil_country;
		this.ship_house_num = ship_house_num;
		this.ship_street = ship_street;
		this.ship_subdivision = ship_subdivision;
		this.ship_city = ship_city;
		this.ship_postal_code = ship_postal_code;
		this.ship_country = ship_country;
	}

	public int getAccountID() 
	{
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
	
	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getMiddle_name() {
		return middle_name;
	}

	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getPrivilegeLevel() {
		return privilegeLevel;
	}
	public void setPrivilegeLevel(String privilegeLevel) {
		this.privilegeLevel = privilegeLevel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBil_house_num() {
		return bil_house_num;
	}

	public void setBil_house_num(String bil_house_num) {
		this.bil_house_num = bil_house_num;
	}

	public String getBil_street() {
		return bil_street;
	}

	public void setBil_street(String bil_street) {
		this.bil_street = bil_street;
	}

	public String getBil_subdivision() {
		return bil_subdivision;
	}

	public void setBil_subdivision(String bil_subdivision) {
		this.bil_subdivision = bil_subdivision;
	}

	public String getBil_city() {
		return bil_city;
	}

	public void setBil_city(String bil_city) {
		this.bil_city = bil_city;
	}

	public String getBil_postal_code() {
		return bil_postal_code;
	}

	public void setBil_postal_code(String bil_postal_code) {
		this.bil_postal_code = bil_postal_code;
	}

	public String getBil_country() {
		return bil_country;
	}

	public void setBil_country(String bil_country) {
		this.bil_country = bil_country;
	}

	public String getShip_house_num() {
		return ship_house_num;
	}

	public void setShip_house_num(String ship_house_num) {
		this.ship_house_num = ship_house_num;
	}

	public String getShip_street() {
		return ship_street;
	}

	public void setShip_street(String ship_street) {
		this.ship_street = ship_street;
	}

	public String getShip_subdivision() {
		return ship_subdivision;
	}

	public void setShip_subdivision(String ship_subdivision) {
		this.ship_subdivision = ship_subdivision;
	}

	public String getShip_city() {
		return ship_city;
	}

	public void setShip_city(String ship_city) {
		this.ship_city = ship_city;
	}

	public String getShip_postal_code() {
		return ship_postal_code;
	}

	public void setShip_postal_code(String ship_postal_code) {
		this.ship_postal_code = ship_postal_code;
	}

	public String getShip_country() {
		return ship_country;
	}

	public void setShip_country(String ship_country) {
		this.ship_country = ship_country;
	}
	
	
	
}
