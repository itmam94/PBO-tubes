package tubesPBO;

public class Listing {
    private Product produk;
    private int quantity, price;
    private String category;

    public Listing(){

    }

    public void setProduk(Product produk) {
        this.produk = produk;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Product getProduk() {
        return produk;
    }

    public int getQuantity() {
        return quantity;
    }

    public getPrice() {
        return price
    }

    public void addProduct(String productName, String description, float weight, float[3] dimension){
        product = new Product();
        product.setProductName(productName);
        product.setDescription(description);
        product.setWeight(weight);
        product.setDimension(dimension);
        setProduk(product);
    }

    public void removeProduct(){
        this.produk = null;
    }

    public String getCategory() {
        return category;
    }

    public void addQuantity(int add) {
        this.quantity += add;
    }

    public void removeQuantity(int remove) {
        this.quantity -= remove;
    }

    public void editListing(Product produk, int quantity, int price, String category){
        setProduk(produk);
        setQuantity(quantity);
        setPrice(price);
        setCategory(category);
    }
}


