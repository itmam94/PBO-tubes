package tubesPBO;

public class Buyer extends Account{
    private String paymentMethod;
    private int creditCard;

    public Buyer(){
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
