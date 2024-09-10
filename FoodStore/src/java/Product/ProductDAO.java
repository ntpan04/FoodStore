/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Product;

import Database.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kim Cuong
 */
public class ProductDAO {
    
    public List<ProductDTO> getProList() throws SQLException, ClassNotFoundException {
        List<ProductDTO> ProList = new ArrayList();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtil.getConnection();
            if (con != null) {
                String query = "Select * from product";
                stm = con.prepareStatement(query);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String ID = rs.getString("productID");
                    String name = rs.getString("productName");
                    boolean Status = rs.getBoolean("Status");
                    int Price = rs.getInt("Price");
                    int Amount = rs.getInt("Amount");
                    String image = rs.getString("Image");
                    ProList.add(new ProductDTO(ID, name, Status, Price, Amount,image));
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
            return ProList;
        }
    }

    public ProductDTO getProById(String id) throws SQLException, ClassNotFoundException {
        List<ProductDTO> ProList = getProList();
        for (ProductDTO productDTO : ProList) {
            if (productDTO.getProductID().equals(id)) {
                return productDTO;
            }
        }
        return null;
    }
    
    public List<ProductDTO> getFoodList() throws SQLException, ClassNotFoundException {
        List<ProductDTO> foodList = new ArrayList();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtil.getConnection();
            if (con != null) {
                String query = "Select * from product WHERE productID like 'F%'";
                stm = con.prepareStatement(query);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String ID = rs.getString("productID");
                    String name = rs.getString("productName");
                    boolean Status = rs.getBoolean("Status");
                    int Price = rs.getInt("Price");
                    int Amount = rs.getInt("Amount");
                    String image = rs.getString("Image");
                    foodList.add(new ProductDTO(ID, name, Status, Price, Amount,image));
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
            return foodList;
        }
    }

    public ProductDTO getFoodById(String id) throws SQLException, ClassNotFoundException {
        List<ProductDTO> foodList = getFoodList();
        for (ProductDTO productDTO : foodList) {
            if (productDTO.getProductID().equals(id)) {
                return productDTO;
            }
        }
        return null;
    }
    
    public List<ProductDTO> getDrinkList() throws SQLException, ClassNotFoundException {
        List<ProductDTO> drinkList = new ArrayList();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtil.getConnection();
            if (con != null) {
                String query = "Select * from product WHERE productID like 'D%'";
                stm = con.prepareStatement(query);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String ID = rs.getString("productID");
                    String name = rs.getString("productName");
                    boolean Status = rs.getBoolean("Status");
                    int Price = rs.getInt("Price");
                    int Amount = rs.getInt("Amount");
                    String image = rs.getString("Image");
                    drinkList.add(new ProductDTO(ID, name, Status, Price, Amount,image));
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
            return drinkList;
        }
    }

    public ProductDTO getDrinkById(String id) throws SQLException, ClassNotFoundException {
        List<ProductDTO> drinkList = getFoodList();
        for (ProductDTO productDTO : drinkList) {
            if (productDTO.getProductID().equals(id)) {
                return productDTO;
            }
        }
        return null;
    }
    
    public List<ProductDTO> search(String searchValue)
            throws SQLException, ClassNotFoundException {
        List<ProductDTO> ProList = new ArrayList();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtil.getConnection();
            if (con != null) {
                String query = "Select * from product WHERE productName like ?";
                stm = con.prepareStatement(query);
                stm.setString(1,"%"+ searchValue + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    String ID = rs.getString("productID");
                    String name = rs.getString("productName");
                    boolean Status = rs.getBoolean("Status");
                    int Price = rs.getInt("Price");
                    int Amount = rs.getInt("Amount");
                    String image = rs.getString("Image");
                    ProList.add(new ProductDTO(ID, name, Status, Price, Amount,image));
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
            return ProList;
        }
    }

     public boolean createNewProduct(String ID, String Name, boolean Status, int Price, int Amount, String img)
            throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtil.getConnection();
            if (con != null) {
                String query = "INSERT INTO Product(productID, productName, Status, Price, Amount, Image) VALUES(?,?,?,?,?,?)";
                stm = con.prepareStatement(query);
                stm.setString(1, ID);
                stm.setString(2, Name);
                stm.setBoolean(3, Status);
                stm.setInt(4, Price);
                stm.setInt(5, Amount);
                stm.setString(6, img);
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

    public boolean removeProduct(String productID) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtil.getConnection();
            if (con != null) {
                String query = "UPDATE Product SET Amount = 0 WHERE productID = ?";
                stm = con.prepareStatement(query);
                stm.setString(1, productID);
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

    public boolean updateProduct(String productID, String newName, boolean newStatus, int newPrice, int newAmount)
            throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtil.getConnection();
            if (con != null) {
                String query = "UPDATE Product SET productName = ?, Status = ?, Price = ?, Amount = ? WHERE productID = ?";
                stm = con.prepareStatement(query);
                stm.setString(1, newName);
                stm.setBoolean(2, newStatus);
                stm.setInt(3, newPrice);
                stm.setInt(4, newAmount);
                stm.setString(5, productID);
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
    
    public boolean reduceProduct(int amount,String proId)
        throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtil.getConnection();
            if (con != null) {
                String query = "UPDATE Product SET Amount = ? WHERE productID = ?";
                stm = con.prepareStatement(query);
                stm.setInt(1, amount);
                stm.setString(2, proId);
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
