package tubesPBO;

public class Product {
    private String productName, description;
    private float weight;
    private float[] dimension = new float[3]; // {L , W, H}

    public Product(){

    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void setDimension(float[3] dimension) {
        this.dimension = dimension;
    }

    public String getProductName() {
        return productName;
    }

    public String getDescription() {
        return description;
    }

    public float getWeight() {
        return weight;
    }

    public float[] getDimension() {
        return dimension;
    }

    public void addProduct(String productName, String description, float weight, float[3] dimension) {
        setProductName(productName);
        setDescription(description);
        setWeight(weight);
        setDimension(dimension);

    }

    public void editProduct (String productName, String description, float weight, float[3] dimension) {
        setProductName(productName);
        setDescription(description);
        setWeight(weight);
        setDimension(dimension);
    }
}
