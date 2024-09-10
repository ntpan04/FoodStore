/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Order;

import Database.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class OrderDAO {
    
    public List<IncludeDTO> getIncludeList(int orderId) throws SQLException, ClassNotFoundException {
        List<IncludeDTO> includeList = new ArrayList<>();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = DBUtil.getConnection(); // Replace with your connection method
            if (con != null) {
                String query = "SELECT quantity, orderID, productID FROM Include WHERE orderID = ?";
                stm = con.prepareStatement(query);
                stm.setInt(1, orderId);
                rs = stm.executeQuery();

                while (rs.next()) {
                    int quantity = rs.getInt("quantity");
                    int orderID = rs.getInt("orderID");
                    String productID = rs.getString("productID");
                    String productName = getProNameById(productID);

                    // Create IncludeDTO object and add to list
                    IncludeDTO includeDTO = new IncludeDTO(quantity, orderID, productID, productName);
                    includeList.add(includeDTO);
                }
            }
        } finally {
            // Close resources in reverse order of creation
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }

        return includeList;
    }
    
    private String getProNameById(String id)throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtil.getConnection(); // Assuming DBUtil handles connection
            if (con != null) {
                String query = "SELECT productName FROM Product WHERE productID = ?";
                stm = con.prepareStatement(query);
                stm.setString(1, id);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String proName = rs.getString("productName");
                    return proName;
                }
            }
    }finally {
            // Close resources in reverse order of creation
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return null;
    }

    public List<OrderDTO> getAdminOrderList() throws SQLException, ClassNotFoundException {
        List<OrderDTO> orderList = new ArrayList<>();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = DBUtil.getConnection(); // Assuming DBUtil handles connection
            if (con != null) {
                String query = "SELECT * FROM Orders";
                stm = con.prepareStatement(query);
                rs = stm.executeQuery();

                while (rs.next()) {
                    int orderID = rs.getInt("orderID");
                    String payMethod = rs.getString("PayMethod");
                    String dateTime = rs.getString("Date_Time");
                    String status = rs.getString("Status");
                    int totalPrice = rs.getInt("Total_Price");
                    int customerID = rs.getInt("customerID");
                    String address = rs.getString("address");
                    String phoneOrder = rs.getString("phoneOrder");
                    String fullNameOrder = rs.getString("fullNameOrder");

                    // Create OrderDTO object and add to list
                    OrderDTO order = new OrderDTO(orderID, payMethod, dateTime, status, totalPrice,
                            customerID, address, phoneOrder, fullNameOrder);
                    orderList.add(order);
                }
            }
        } finally {
            // Close resources in reverse order of creation
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }

        return orderList;
    }

    public String getCusId(String userName) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtil.getConnection();
            if (con != null) {
                String query = "SELECT customerID FROM Customer WHERE UserName = ?";
                stm = con.prepareStatement(query);
                stm.setString(1, userName);
                rs = stm.executeQuery();
                if (rs.next()) {
                    String cusId = rs.getString("customerID");
                    return cusId;
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return null;
    }

    public String getOrderId(String cusId) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtil.getConnection();
            if (con != null) {
                String query = "SELECT MAX(orderID) AS MaxOrderID FROM Orders WHERE customerID = ?";
                stm = con.prepareStatement(query);
                stm.setString(1, cusId);
                rs = stm.executeQuery();
                if (rs.next()) {
                    String ordId = rs.getString("MaxOrderID");
                    return ordId;
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return null;
    }

    public boolean addOrderTable(String customerID, int total, String address, String phone, String fullName) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtil.getConnection();
            if (con != null) {
                String query = "INSERT INTO Orders(PayMethod, Date_Time, Status, Total_Price, customerID, address, phoneOrder, fullNameOrder) "
                        + "VALUES ('Cash',GETDATE() ,'Pending', ?, ?, ?, ?, ?)";
                stm = con.prepareStatement(query);
                stm.setInt(1, total);
                stm.setString(2, customerID);
                stm.setString(3, address);
                stm.setString(4, phone);
                stm.setString(5, fullName);
                int affectedRows = stm.executeUpdate();
                return affectedRows != 0;
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    public boolean addIncludeTable(int quantity, String orderID, String productID) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtil.getConnection();
            if (con != null) {
                String query = "INSERT INTO Include(quantity, orderID, productID) VALUES (?, ?, ?)";
                stm = con.prepareStatement(query);
                stm.setInt(1, quantity);
                stm.setString(2, orderID);
                stm.setString(3, productID);
                int affectedRows = stm.executeUpdate();
                return affectedRows != 0;
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }
    
    public List<OrderDTO> getCustomerOrderList(String CustomerId) throws SQLException, ClassNotFoundException {
        List<OrderDTO> orderList = new ArrayList<>();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = DBUtil.getConnection(); // Assuming DBUtil handles connection
            if (con != null) {
                String query = "SELECT * FROM Orders where customerID= ? ";
                stm = con.prepareStatement(query);
                stm.setString(1, CustomerId);
                rs = stm.executeQuery();

                while (rs.next()) {
                    int orderID = rs.getInt("orderID");
                    String payMethod = rs.getString("PayMethod");
                    String dateTime = rs.getString("Date_Time");
                    String status = rs.getString("Status");
                    int totalPrice = rs.getInt("Total_Price");
                    int customerID = rs.getInt("customerID");
                    String address = rs.getString("address");
                    String phoneOrder = rs.getString("phoneOrder");
                    String fullNameOrder = rs.getString("fullNameOrder");

                    // Create OrderDTO object and add to list
                    OrderDTO order = new OrderDTO(orderID, payMethod, dateTime, status, totalPrice,
                            customerID, address, phoneOrder, fullNameOrder);
                    orderList.add(order);
                }
            }
        } finally {
            // Close resources in reverse order of creation
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }

        return orderList;
    }
    public boolean Update(String Status, String OrderID)
            throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtil.getConnection();
            if (con != null) {
                String query = "UPDATE Orders SET Status = ? WHERE OrderId = ?";
                stm = con.prepareStatement(query);
                stm.setString(1, Status);
                stm.setString(2, OrderID);
                int affectedRows = stm.executeUpdate();
                return affectedRows > 0;
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }
}
