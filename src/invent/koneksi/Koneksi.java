/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invent.koneksi;

import invent.dao.impl.MasterBarangImpl;
import com.mysql.jdbc.Driver;
import invent.dao.MasterBarang;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author romyy
 */
public class Koneksi {
    private static Connection connection;
    private static MasterBarang masterBarang;
    
    private Koneksi(){
        
    }

    private static Connection getConnection() {
        if (connection==null){
            try {
                DriverManager.registerDriver(new Driver());
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sinju", "root", "");
            } catch (SQLException ex) {
                Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return connection;
    }

    public static MasterBarang getMasterBarang() {
        if (masterBarang==null){
            masterBarang = new MasterBarangImpl(getConnection());
        }
        return masterBarang;
    }
}
