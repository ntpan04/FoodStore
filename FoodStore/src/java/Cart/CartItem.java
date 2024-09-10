/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cart;

import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public class CartItem {
    private String productId;
    private String productName;
    private int quantity;
    private int unitPrice;
    private String image;

    public CartItem() {
    }
    
    public CartItem(String productId, String productName, int quantity, int unitPrice, String image) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }
    
    
    
    public int getSubTotal(){
        return quantity*unitPrice;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%d,%.2f", productId,productName,quantity,unitPrice);
    }
}