package tubesPBO;

public class Listing {
    private Product product = new Product();
    private int quantity, price;
    private String productName, category;

    public Listing(){
    }

    public Listing(Product product, int quantity, int price, String productName, String category) {
		super();
		this.product = product;
		this.quantity = quantity;
		this.price = price;
		this.productName = productName;
		this.category = category;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setProduk(Product produk) {
        this.product = produk;
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
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }

    public void addProduct(String productName, String description, float weight, float[] dimension){
        product.setProductName(productName);
        product.setDescription(description);
        product.setWeight(weight);
        product.setDimension(dimension);
        setProduk(product);
    }

    public void removeProduct(){
        this.product = null;
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


