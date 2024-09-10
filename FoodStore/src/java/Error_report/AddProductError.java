/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Error_report;

/**
 *
 * @author DELL
 */
public class AddProductError {

    private String productIdNotMatch = "";
    private String productNameLenError = "";
    private String priceRangeError = "";
    private String amountRangeError = "";
    private String productExist = "";

    private boolean checkLen(String data, int min, int max) {
        return (data.trim().length() >= min) && (data.trim().length() <= max);
    }
    
    private boolean checkSize(int data, int min, int max){
        return (data >= min) && (data <= max);
    }

    public boolean checkProductId(String productId) {
        if (!productId.matches("^[FDC]\\d{2}$")) {
            productIdNotMatch = "ProductID must have format F (food) / D (drink) / C (combo) + 2 digits";
            return false;
        } else {
            productIdNotMatch = "";
            return true;
        }
    }

    public boolean checkProductName(String productName, int min, int max) {
        if (!checkLen(productName, min, max)) {
            productNameLenError = "ProductName must have length between " + min + " - " + max;
            return false;
        } else {
            productNameLenError = "";
            return true;
        }
    }

    public boolean checkPrice(int price, int min, int max) {
        if (!checkSize(price, min, max)) {
            priceRangeError = "Price must be greater than 0";
            return false;
        } else {
            priceRangeError = "";
            return true;
        }
    }

    public boolean checkAmount(int amount, int min, int max) {
        if (!checkSize(amount, min, max)) {
            amountRangeError = "Amount must be greater than 0";
            return false;
        } else {
            amountRangeError = "";
            return true;
        }
    }

    public String getProductIdNotMatch() {
        return productIdNotMatch;
    }

    public void setProductIdNotMatch(String productIdNotMatch) {
        this.productIdNotMatch = productIdNotMatch;
    }

    public String getProductNameLenError() {
        return productNameLenError;
    }

    public void setProductNameLenError(String productNameLenError) {
        this.productNameLenError = productNameLenError;
    }

    public String getPriceRangeError() {
        return priceRangeError;
    }

    public void setPriceRangeError(String priceRangeError) {
        this.priceRangeError = priceRangeError;
    }

    public String getAmountRangeError() {
        return amountRangeError;
    }

    public void setAmountRangeError(String amountRangeError) {
        this.amountRangeError = amountRangeError;
    }

    public String getProductExist() {
        return productExist;
    }

    public void setProductExist(String productExist) {
        this.productExist = productExist;
    }

}
