package tubesPBO;

public class Seller extends Account {
    private String namaToko;
    private Listing[] produkListing;

    public Seller(){

    }
    
    public void setNamaToko (String namaToko){
        this.namaToko = namaToko;
    }
    
    public String getNamaToko(){
        return namaToko;   
    }
    
    public void setProdukListing (Listing[] produkListing){
        this.produkListing = produkListing;
    }
    
    public Listing[] getProdukListing(){
        return produkListing;
    }
    
    public void addProduct(){
        int len = this.produkListing.length;
        int i = 0;
        
        while (i < len && produkListing[i] == null){
            i += 1;
        } 
    }
    
    public void removeProduct(){
        int len = this.produkListing.length;
        int i = 0;
        
        while (i < len && produkListing[i] != null){
            i -= 1;
        } 
    }
}
