package tubesPBO;
import java.util.ArrayList;
import java.util.List;

public class Seller extends Account {
    private String namaToko;
    private List<Listing> produkListing = new ArrayList<Listing>();

    public Seller(){
    }
    
    public void setNamaToko (String namaToko){
        this.namaToko = namaToko;
    }
    
    public String getNamaToko(){
        return namaToko;   
    }
    
    public void addListing(Product product, int quantity, int price, String productName, String category){
    	Listing listing = new Listing(product, quantity, price, productName, category);
        produkListing.add(listing);
    }
    
    public Listing findListing(String productName) {
    	for(Listing product : produkListing) {
    		if(product.getProductName().equalsIgnoreCase(productName)) {
    			return product;
    		}
    	}
    	return null;
    }
    
    public void removeListing(String productName){
    	Listing product = findListing(productName);
    	if(product != null) {
    		produkListing.remove(product);
    	} else {
    		System.out.println("This product doesn't exist");
    	}        
    }
}
