/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simple.inventory;

import invent.form.FormBarang;
import javax.swing.SwingUtilities;
/**
 *
 * @author romyy
 */
public class SimpleInventory {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                FormBarang barang = new FormBarang();
                barang.setVisible(true);
            }
        });
    }
    
}
