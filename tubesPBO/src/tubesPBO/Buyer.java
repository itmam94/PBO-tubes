package tubesPBO;

public class Buyer {
    private String paymentMethod;
    private int creditCard;
    
    public void setPaymentMethod (String paymentMethod){
        this.paymentMethod = paymentMethod;
    }
    
    public String getPaymentMethod (){
        return this.paymentMethod;
    }
    
    public void setCreditCard (int creditCard){
        this.creditCard = creditCard;
    }
    
    public int getCreditCard (){
        return this.creditCard;
    }
}
