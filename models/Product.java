package models;



public class Product {
    private int idp;
    private String nume;

    private double price;

    public Product(int idp, String nume, double price) {
        this.idp = idp;
        this.nume = nume;
        this.price = price;
    }
    public Product()
   {
       this.idp=0;
       this.nume="";
       this.price=0;
   }

    public int getIdp() {
        return idp;
    }

    public void setIdp(int id) {
        this.idp = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
