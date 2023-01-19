package tubesPBO;

public class Product {
    private String productName, description;
    private double weight;
    private String username;  // points to a seller
    private double[] dimension = new double[3]; // {L , W, H}


    public Product(){

    }

    public Product(String productName, String description, double weight, double[] dimension) {
		super();
		this.productName = productName;
		this.description = description;
		this.weight = weight;
		this.dimension = dimension;
	}

	public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setDimension(double[] dimension) {
        this.dimension = dimension;
    }

    public String getProductName() {
        return productName;
    }

    public String getDescription() {
        return description;
    }

    public double getWeight() {
        return weight;
    }

    public double[] getDimension() {
        return dimension;
    }

    // public void addQuantity(int add) {
    //     this.quantity += add;
    // }

    // public void removeQuantity(int remove) {
    //     this.quantity -= remove;
    // }

    public void addProduct(String productName, String description, double weight, double[] dimension) {
        setProductName(productName);
        setDescription(description);
        setWeight(weight);
        setDimension(dimension);
    }
}
