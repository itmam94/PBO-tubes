package tubesPBO;

public class Main {

	public static void main(String[] args) {
		Account acc = new Account();
		
		acc.setName("Itmam");
		acc.setEmail("itmam@mail.com");
		acc.setPassword("123");
		acc.setPhoneNumber("+627383");
		acc.setUserID("10001");
		acc.addAddress("Rumah", "Jl gatau no 2", "Jakarta", "DKI Jakarta", "Zimbabwe", 1234);
		acc.addAddress("Kantor", "Jl kantor no 2", "Depok", "Jawa Barat", "Zimbabwe", 1234);
		
		acc.printAddress();
		
		acc.removeAddress("rumah");
		acc.removeAddress("ruko");
		acc.printAddress();
		
		Buyer buyer = new Buyer();
		
		buyer.setName("Juned");
		
		System.out.println(buyer.getName());
	}

}
