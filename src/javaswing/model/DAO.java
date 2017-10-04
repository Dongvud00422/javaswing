/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaswing.model;

import java.sql.*;

/**
 *
 * @author DongHo
 */
public class DAO {

     public static Connection getConnection() throws SQLException {
	  String connectionString = GlobalConfig.getCONNECTION_URL_PREFIX() + GlobalConfig.getHOST() + GlobalConfig.getDATABASE();
	  return DriverManager.getConnection(connectionString, GlobalConfig.getUSERNAME(), GlobalConfig.getPASSWORD());
     }
}
