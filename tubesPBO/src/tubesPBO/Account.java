package tubesPBO;

import java.util.ArrayList;
import java.util.List;

public class Account {
	
	private String email, password, name, phoneNumber;
	private List<Address> addressList = new ArrayList<Address>(); 
	
	//Tambahin parameter constructor
	public Account(String email, String password, String name, String phoneNumber) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
	}
	
	/* 
	public void register(String email, String password, String name, String phoneNumber) {
		setEmail(email);
		setPassword(password);
		setName(name);
		setPhoneNumber(phoneNumber);
	}
	*/

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public boolean login(String email, String password) {
		if (email.equalsIgnoreCase(this.email) && (password.equals(this.password))) {
			return true;
		}
		
		return false;
	}
	
	//typo
	public void addAddress(String street, String city, String province, String country, int postalCode) {
		Address address = new Address(street, city, province, country, postalCode);
		addressList.add(address);
	}
}
