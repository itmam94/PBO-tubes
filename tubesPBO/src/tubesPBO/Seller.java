package tubesPBO;
import java.util.ArrayList;
import java.util.List;

public class Seller extends Account {
    private String namaToko;
    private List<Listing> listingList = new ArrayList<Listing>();

    public Seller(String name, String email, String password, String street, String city, String provice, String country, String postalCode){
    	super();
    }
    
    public void setNamaToko (String namaToko){
        this.namaToko = namaToko;
    }
    
    public String getNamaToko(){
        return namaToko;   
    }
    
    public void addListing(String productName, String description, double weight, double[] dimension, int quantity, 
    		int price, String category){
    	Product product = new Product(productName, description, weight, dimension);
    	Listing listing = new Listing(product, quantity, price, productName, category);
    	listingList.add(listing);
    }
    
    public Listing findListing(String productName) {
    	for(Listing list : listingList) {
    		if(list.getProductName().equalsIgnoreCase(productName)) {
    			return list;
    		}
    	}
    	return null;
    }
    
    public void removeListing(String productName){
    	Listing listing = findListing(productName);
    	if(listing != null) {
    		listingList.remove(listing);
    	} else {
    		System.out.println("This product doesn't exist");
    	}        
    }
    
    public void printListing() {
    	for(Listing list : listingList) {
    		System.out.println(list.getProductName() + ": " + list.getQuantity() + " " + list.getPrice() + " " +
    	list.getCategory());
    	}
    }
}
