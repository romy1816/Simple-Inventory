/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invent.dao;
import invent.entity.Barang;
import java.util.List;
/**
 *
 * @author romyy
 */
public interface MasterBarang {
    public void save(Barang barang);
    public void update(Barang barang);
    public void delete(Barang barang);
    public List<Barang> getAll();
}
