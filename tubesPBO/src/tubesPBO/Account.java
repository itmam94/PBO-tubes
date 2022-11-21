package tubesPBO;

import java.util.ArrayList;
import java.util.List;

public class Account {
	
	private String userID, email, password, name, phoneNumber;
	private List<Address> addressList =new ArrayList<Address>(); 
	
	public Account() {
	}
	
	public void register(String email, String password, String name, String phoneNumber) {
		setEmail(email);
		setPassword(password);
		setName(name);
		setPhoneNumber(phoneNumber);
	}
	
	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

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
	
	public void addAddress(String name, String street, String city, String provice, String country, int postalCode) {
		Address address = new Address(name,street, city, provice, country, postalCode);
		addressList.add(address);
	}
	
	public Address findAddress(String name) {
		for(Address address : addressList) {
			if(address.getName().equalsIgnoreCase(name)) {
				return address;
			}
		}
		
		return null;
	}
	
	public void removeAddress(String name) {
		Address address = findAddress(name);
		if(address != null) {
			addressList.remove(address);
		} else {
			System.out.println("Address not found");
		}
	}
	
	public void printAddress() {
		for (Address address : addressList) {
			System.out.println(address.getName() + ": " + address.getStreet() + " " +
		address.getCity() + " " + address.getProvice() + " " + address.getPostalCode() +
		" " + address.getCountry());
		}
	}

}
