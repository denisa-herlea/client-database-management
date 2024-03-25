package models;



public class Client {
    private int idc;
    private String nume, adresa;

    public Client(int idc, String nume, String adresa) {
        this.idc = idc;
        this.nume = nume;
        this.adresa = adresa;
    }

    public Client(){
        this.idc=0;
        this.nume="";
        this.adresa="";
    }

    public int getIdc() {
        return idc;
    }

    public void setIdc(int idc) {
        this.idc = idc;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }
}
