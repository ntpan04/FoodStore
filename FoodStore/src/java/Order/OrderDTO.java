/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Order;

import java.util.List;

/**
 *
 * @author Admin
 */
public class OrderDTO {
    private int orderID;
    private String payMethod;
    private String date_time;
    private String status;
    private int totalPrice;
    private int customerID;
    private String address;
    private String phone;
    private String fullName;
    private List<IncludeDTO> includeList;

    public OrderDTO() {
    }

    public OrderDTO(int orderID, String payMethod, String date_time, String status, int totalPrice, int customerID, String address, String phone, String fullName) {
        this.orderID = orderID;
        this.payMethod = payMethod;
        this.date_time = date_time;
        this.status = status;
        this.totalPrice = totalPrice;
        this.customerID = customerID;
        this.address = address;
        this.phone = phone;
        this.fullName = fullName;
    }
    
    

    public OrderDTO(int orderID, String payMethod, String date_time, String status, int totalPrice, int customerID, String address, String phone, String fullName, List<IncludeDTO> includeList) {
        this.orderID = orderID;
        this.payMethod = payMethod;
        this.date_time = date_time;
        this.status = status;
        this.totalPrice = totalPrice;
        this.customerID = customerID;
        this.address = address;
        this.phone = phone;
        this.fullName = fullName;
        this.includeList = includeList;
    }
    

    public List<IncludeDTO> getIncludeList() {
        return includeList;
    }

    public void setIncludeList(List<IncludeDTO> includeList) {
        this.includeList = includeList;
    }

    

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    
}
