/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Customer;

import Database.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class CustomerDAO {

    public CustomerDTO authenticate(String userName,String password)
        throws SQLException,ClassNotFoundException{
        CustomerDTO user = null;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try{
            con = DBUtil.getConnection();
            if(con!=null){
                String query = "SELECT * FROM Customer WHERE UserName = ? AND Password = ?";
                stm = con.prepareStatement(query);
                stm.setString(1,userName);
                stm.setString(2,password);
                rs = stm.executeQuery();
                if(rs.next()){
                    String fullName = rs.getString("FullName");
                    String phone = rs.getString("Phone");
                    user = new CustomerDTO(userName, password, fullName, phone);
                }
                return user;
            }
        }finally{
            if(rs!=null) rs.close(); if(stm!=null)stm.close();
            if(con!=null) con.close();
        }
        return null;
    }
    
    public boolean valid(String userName, String password)
            throws SQLException, ClassNotFoundException {
        Connection con = null;// bien dung ket noi db
        PreparedStatement stm = null;// Bien dung querry bang
        ResultSet rs = null;// luu du lieu tra ve
        try {
            //1. ket noi db
            con = DBUtil.getConnection();
            if (con != null) {
                //2. tao cau lenh kiem tra ( dau ? la placeholder de nap du lieu khi query thong tin
                String query = "SELECT * FROM Customer WHERE UserName = ? AND Password = ?";
                //3. tao cau lenh query
                stm = con.prepareStatement(query);
                //4. nap du lieu vao placeholder 
                stm.setString(1, userName);
                stm.setString(2, password);
                //5. chay cau lenh query
                rs = stm.executeQuery();
                return rs.next();//true neu phan tu tiep theo la du lieu, false nghia la khong tim thay phan tu nao khop
            }
        } finally {// nho dong cac connection theo nguyen tac mo cuoi cung thi dong dau tien
            // rs --> stm --> con
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
        return false;//return false neu bi exception
    }
//    public List<CustomerDTO> search(String searchValue) 
//    throws SQLException,ClassNotFoundException{
//        List<CustomerDTO> accList = new ArrayList();
//        Connection con = null;
//        PreparedStatement stm = null;
//        ResultSet rs = null;
//        try{
//            //1. connect to DB
//            con = DBUtil.getConnection();
//            if(con!=null){
//                //2. viet lenh query
//                String query = "SELECT * FROM registration WHERE lastname LIKE ?";
//                //Like: search gan dung; %?%: Search ky tu o vi tri bat ky
//                //3. lay du lieu nap vao accList
//                stm = con.prepareStatement(query);
//                stm.setString(1,"%"+ searchValue+"%");
//                rs = stm.executeQuery();
//                while(rs.next()){
//                    String userName = rs.getString("username");//"username": ten cot trong db
//                    String password = rs.getString("password");//"password": ten cot trong db
//                    String lastName = rs.getString("lastname");//"lastname": ten cot trong db
//                    boolean isAdmin = rs.getBoolean("isAdmin");//chu y bien kieu gi thi get kieu do
//                    accList.add(new CustomerDTO(userName,password,lastName,isAdmin));
//                }
//                
//            }
//        }finally{
//            if(rs!=null) rs.close();if(stm!=null) stm.close();
//            if(con!=null) con.close();
//            return accList;
//        }
//    }
    
    public boolean delete(String id)
    throws SQLException,ClassNotFoundException{
        Connection con = null;
        PreparedStatement stm = null;
        
        try{
            con = DBUtil.getConnection();
            if(con!=null){
                String query = "DELETE FROM registration WHERE username=?";
                stm = con.prepareStatement(query);
                stm.setString(1, id);
                int affectedRows = stm.executeUpdate();
                return affectedRows>0;
            }
        }finally{
            if(stm!=null) stm.close(); if(con!=null)con.close();
        }
        return false;
    }
    
//    public boolean update(String userName,String password,String lastName,boolean isAdmin) 
//            throws SQLException, ClassNotFoundException{
//        Connection con = null;
//        PreparedStatement stm = null;
//        try{
//            con = DBUtil.getConnection();
//            if(con!=null){
//                String query = "UPDATE registration SET password=?,lastname=?,isAdmin=? WHERE username=?";
//                stm = con.prepareStatement(query);
//                stm.setString(1, password);
//                stm.setString(2, lastName);
//                stm.setBoolean(3, isAdmin);
//                stm.setString(4, userName);
//                int affectedRow = stm.executeUpdate();
//                return affectedRow >0;
//            }
//        }finally{
//            if(stm!=null) stm.close(); if(con!=null) con.close();
//        }
//        return false;
//    }
    public boolean checkAccountExist(String userName)
    throws SQLException,ClassNotFoundException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try{
            con = DBUtil.getConnection();
            if(con!=null){
                String query = "SELECT * FROM Customer WHERE UserName=?";
                stm = con.prepareStatement(query);
                stm.setString(1, userName);
                rs = stm.executeQuery();
                return rs.next();
            }
        }finally{
            if(rs!=null)rs.close();if(stm!=null)stm.close();
            if(con!=null)con.close();
        }
        return false;
    }
  
    public boolean createNewAccount(String userName,String password,String fullName,String phone)
    throws SQLException,ClassNotFoundException{
        Connection con = null;
        PreparedStatement stm = null;
        try{
            con = DBUtil.getConnection();
            if(con!=null){
                String query = "INSERT INTO Customer(UserName,Fullname,Password,Phone) VALUES (?,?,?,?)";
                stm = con.prepareStatement(query);
                stm.setString(1, userName);
                stm.setString(2, fullName);
                stm.setNString(3, password);
                stm.setString(4, phone);
                int affectedRows = stm.executeUpdate();
                return affectedRows != 0;
            }
        }finally{
            if(stm!=null)stm.close();if(con!=null)con.close();
        }
        return false;
    }
    
    public CustomerDTO getUser(String cusName)
            throws SQLException, ClassNotFoundException {
        //Get user by id
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtil.getConnection();
            if (con != null) {
                String query = "SELECT * FROM Customer WHERE UserName=?";
                stm = con.prepareStatement(query);
                stm.setString(1, cusName);
                rs = stm.executeQuery();
                if (rs.next()) {
                    String password = rs.getString("password");
                    String fullName = rs.getString("FullName");
                    String phone = rs.getString("Phone");
                    CustomerDTO cus = new CustomerDTO(cusName, password, fullName, phone);
                    return cus;
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
    
    public boolean updatePass(String userName, String password)
            throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtil.getConnection();
            if (con != null) {
                String query = "UPDATE Customer SET Password=? WHERE UserName=?";
                stm = con.prepareStatement(query);
                stm.setString(1, password);
                stm.setString(2, userName);
                int affectedRow = stm.executeUpdate();
                return affectedRow > 0;
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
    public boolean updateGen(String userName, String fullName, String phone)
            throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtil.getConnection();
            if (con != null) {
                String query = "UPDATE Customer SET FullName=?, Phone=?  WHERE UserName=?";
                stm = con.prepareStatement(query);
                stm.setString(1, fullName);
                stm.setString(2, phone);
                stm.setString(3, userName);
                int affectedRow = stm.executeUpdate();
                return affectedRow > 0;
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
