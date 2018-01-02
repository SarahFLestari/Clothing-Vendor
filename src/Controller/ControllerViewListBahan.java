/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.Database;
import Model.*;
import View.ViewListBahan;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public final class ControllerViewListBahan implements ActionListener{
   ViewListBahan VB  = new ViewListBahan();
   Aplikasi app;
    
    public ControllerViewListBahan(Aplikasi app){
        this.app = app;
        VB.setVisible(true);
        VB.addActionListener(this);
        showBahan();
    }

    public void showBahan(){
        Database db = new Database();
        ArrayList<Bahan> ListBahan = db.getListBahan();
        DefaultTableModel model = (DefaultTableModel)VB.getTableDataBahan().getModel();
        Object[] row = new Object[3];
        for (int i = 0; i < ListBahan.size(); i++){
            row[0] = ListBahan.get(i).getIdBahan();
            row[1] = ListBahan.get(i).getNamaBahan();
            row[2] = ListBahan.get(i).getHarga();
            model.addRow(row);    
        }
    }  
    
    public void executeSQLQuery(String query, String pesan){
        Database db = new Database();
        Connection con = db.getConnection();
        Statement st;
        try{
            st = con.createStatement();
            if (st.executeUpdate(query) == 1){
                DefaultTableModel model = (DefaultTableModel)VB.getTableDataBahan().getModel();
                model.setRowCount(0);
                showBahan();
                JOptionPane.showMessageDialog(null, "Database berhasil diakses dan "+pesan);
            } else {
                JOptionPane.showMessageDialog(null, "Database gagal diakses dan "+pesan);
            }   
        } catch (HeadlessException | SQLException ex){
            JOptionPane.showMessageDialog(null, "Maaf, koneksi database anda gagal dan "+pesan);
        }
    } 

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
            if (source == VB.getButtonBack()){
                ControllerMenuPetugas controllerMenuPetugas = new ControllerMenuPetugas(app);
                this.VB.setVisible(false);
            }   
    }
}
