/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invent.dao.impl;

import invent.dao.MasterBarang;
import invent.entity.Barang;
import invent.form.FormBarang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author romyy
 */
public class MasterBarangImpl implements MasterBarang{
    private Connection connection;
    public MasterBarangImpl(Connection connection){
        this.connection = connection;
    }
    public void save(Barang barang) {
        String SQL = "INSERT INTO barang(NAMA,SKU,STOK,GAMBAR) VALUES(?,?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(SQL);
            statement.setString(1, barang.getNama());
            statement.setString(2, barang.getSku());
            statement.setString(3, String.valueOf(barang.getStok()));
            statement.setBytes(4, barang.getGambar());
            statement.executeUpdate();
        } catch(SQLException ex) {
            Logger.getLogger(MasterBarangImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Barang barang) {
        String SQL = "UPDATE barang set NAMA=?, STOK=?,GAMBAR=? WHERE SKU=?";
        try {
            PreparedStatement statement = connection.prepareStatement(SQL);
            statement.setString(1, barang.getNama());
            statement.setString(2, String.valueOf(barang.getStok()));
            statement.setBytes(3, barang.getGambar());
            statement.setString(4, barang.getSku());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MasterBarangImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void delete(Barang barang) {
       String SQL="DELETE FROM barang WHERE SKU=?";
        try {
            PreparedStatement statement = connection.prepareStatement(SQL);
            statement.setString(1, barang.getSku());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MasterBarangImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Barang> getAll() {
        String SQL = "SELECT NAMA,SKU,STOK,GAMBAR FROM barang";
        List<Barang> list = new ArrayList<Barang>();
        Barang barang = null;
        try {
            PreparedStatement statement = connection.prepareStatement(SQL);
            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                barang = new Barang();
                barang.setNama(rs.getString(1));
                barang.setSku(rs.getString(2));
                barang.setStok(Integer.parseInt(rs.getString(3)));
                barang.setGambar(rs.getBytes(4));
                list.add(barang);
                barang=null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MasterBarangImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
