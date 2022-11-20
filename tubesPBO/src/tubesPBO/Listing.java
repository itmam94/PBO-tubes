package tubesPBO;

public class Listing {
    private final Product produk;
    private int quantity, category;

    public Listing(){

    }

    public void setProduk(Product produk) {
        this.produk = produk;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduk() {
        return produk;
    }

    public int getCategory() {
        return category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void addQuantity(int add) {
        this.quantity += add;
    }

    public void removeQuantity(int remove) {
        this.quantity -= remove;
    }
}


