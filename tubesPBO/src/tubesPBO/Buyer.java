package tubesPBO;

public class Buyer extends Account{
    private String paymentMethod;
    private int creditCard;

    public Buyer(String name, String email, String password, String street, String city, String provice, String country, String postalCode){
    	super();
    }
    
    public void setPaymentMethod (String paymentMethod){
        this.paymentMethod = paymentMethod;
    }
    
    public String getPaymentMethod (){
        return paymentMethod;
    }
    
    public void setCreditCard (int creditCard){
        this.creditCard = creditCard;
    }
    
    public int getCreditCard (){
        return creditCard;
    }
}
