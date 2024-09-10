/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Product;

/**
 *
 * @author LENOVO
 */
public class ProductDTO {
    private String productID;
    private String productName;
    private boolean Status;
    private int Price;
    private int Amount;
    private String image;

    public ProductDTO() {
    }

    public ProductDTO(String productID, String productName, boolean Status, int Price, int Amount, String image) {
        this.productID = productID;
        this.productName = productName;
        this.Status = Status;
        this.Price = Price;
        this.Amount = Amount;
        this.image = image;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public boolean getStatus() {
        return Status;
    }

    public void setStatus(boolean Status) {
        this.Status = Status;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int Amount) {
        this.Amount = Amount;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    
}