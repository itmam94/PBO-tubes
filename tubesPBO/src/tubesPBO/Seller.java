package tubesPBO;
import java.util.ArrayList;

public class Seller extends Account {
    private String namaToko;
    private ArrayList<Product> produkListing =new ArrayList<Product>();

    public Seller(){

    }
    
    public void setNamaToko (String namaToko){
        this.namaToko = namaToko;
    }
    
    public String getNamaToko(){
        return namaToko;   
    }
    
    public void addProduct(Product produk){
        produkListing.add(produk);
    }
    
    public void removeProduct(Product produk){
        produkListing.remove(produk);
    }
}
