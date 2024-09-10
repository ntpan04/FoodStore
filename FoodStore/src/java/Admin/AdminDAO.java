/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;

import Database.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Kim Cuong
 */
public class AdminDAO {
     public AdminDTO authenticate(String adminID,String Password)
        throws SQLException,ClassNotFoundException{
        AdminDTO admin = null;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try{
            con = DBUtil.getConnection();
            if(con!=null){
                String query = "SELECT * FROM Admin WHERE adminID = ? AND Password = ?";
                stm = con.prepareStatement(query);
                stm.setString(1,adminID);
                stm.setString(2,Password);
                rs = stm.executeQuery();
                if(rs.next()){
                    String adminId = rs.getString("adminID");
                    String password = rs.getString("Password");
                    admin = new AdminDTO(adminId, password);
                }
                return admin;
            }
        }finally{
            if(rs!=null) rs.close(); if(stm!=null)stm.close();
            if(con!=null) con.close();
        }
        return null;
    }
}