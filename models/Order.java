package models;


public class Order {
    private int ido, idc, idp,quantity;
    private double price;

    public Order(int id, int idClient, int idProduct, int quantity, double price) {
        this.ido = id;
        this.idc = idClient;
        this.idp = idProduct;
        this.quantity = quantity;
        this.price = price;
    }
    public Order(){
        this.ido =0;
        this.idc =0;
        this.idp=0;
        this.quantity=0;
        this.price=0;
    }

    public int getIdo() {
        return ido;
    }

    public void setIdo(int ido) {
        this.ido = ido;
    }

    public int getIdc() {
        return idc;
    }

    public void setIdc(int idc) {
        this.idc = idc;
    }

    public int getIdp() {
        return idp;
    }

    public void setIdp(int idProduct) {
        this.idp = idProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
