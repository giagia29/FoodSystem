package models;

public class Food {
    int resourceID;
    String fname;
    String fprice;

    public Food(int resourceID, String fname, String fprice) {
        this.resourceID = resourceID;
        this.fname = fname;
        this.fprice = fprice;
    }

    public int getResourceID() {
        return resourceID;
    }

    public void setResourceID(int resourceID) {
        this.resourceID = resourceID;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getFprice() {
        return fprice;
    }

    public void setFprice(String fprice) {
        this.fprice = fprice;
    }

}
