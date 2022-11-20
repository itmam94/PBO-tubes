package tubesPBO;

public class Seller {
    private String namaToko;
    private Listing produkListing;
    
    public void setNamaToko (String namaToko){
        this.namaToko = namaToko;
    }
    
    public String getNamaToko(){
        return this.namaToko;   
    }
    
    public void setProdukListing (Listing produkListing){
        this.produkListing = produkListing;
    }
    
    public Listing getProdukListing(){
        return this.produkListing;
    }
    
    public void addProduct(){
    
    }
    
    public void removeProduct(){
    
    }
}
