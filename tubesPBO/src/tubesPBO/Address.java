package tubesPBO;

public class Address {
	
	private String name, street, city, provice, country;
	private int postalCode;
	
	public Address() {
	}

	public Address(String name, String street, String city, String provice, String country, int postalCode) {
		super();
		this.name = name;
		this.street = street;
		this.city = city;
		this.provice = provice;
		this.country = country;
		this.postalCode = postalCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvice() {
		return provice;
	}

	public void setProvice(String provice) {
		this.provice = provice;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

}
