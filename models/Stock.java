package models;




public class Stock {
    private int id;
    private int idProduct;
    private int quantity;

    public Stock(int id, int idProduct, int quantity) {
        this.id = id;
        this.idProduct = idProduct;
        this.quantity = quantity;
    }
    public Stock(){
        this.id=0;
        this.idProduct=0;
        this.quantity=0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
