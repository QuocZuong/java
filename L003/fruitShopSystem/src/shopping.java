
public class shopping {
    private String userOrder;
    private int userQuantity;
    private int priceOfOrder;

    public int getPriceOfOrder() {
        return priceOfOrder;
    }

    public void setPriceOfOrder(int priceOfOrder) {
        this.priceOfOrder = priceOfOrder;
    }

    public shopping() {

    }

    public shopping(String userOrder, int userQuantity, int price) {
        this.userOrder = userOrder;
        this.userQuantity = userQuantity;
        this.priceOfOrder = price;
    }

    public String getUserOrder() {
        return userOrder;
    }

    public void setUserOrder(String userOrder) {
        this.userOrder = userOrder;
    }

    public int getUserQuantity() {
        return userQuantity;
    }

    public void setUserQuantity(int userQuantity) {
        this.userQuantity = userQuantity;
    }
}
