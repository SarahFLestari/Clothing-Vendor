/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.Database;
import Model.Aplikasi;
import Model.Jasa;
import View.ViewListJasa;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public final class ControllerViewListJasa implements ActionListener{
   ViewListJasa VJ  = new ViewListJasa();
   Aplikasi app;
    
    public ControllerViewListJasa(Aplikasi app){
        this.app = app;
        VJ.setVisible(true);
        VJ.addActionListener(this);
        showJasa();
    }

    public void showJasa(){
        Database db = new Database();
        ArrayList<Jasa> ListJasa = db.getListJasa();
        DefaultTableModel model = (DefaultTableModel)VJ.getTableDataJasa().getModel();
        Object[] row = new Object[3];
        for (int i = 0; i < ListJasa.size(); i++){
            row[0] = ListJasa.get(i).getIdJasa();
            row[1] = ListJasa.get(i).getNamaJasa();
            row[2] = ListJasa.get(i).getTarif();
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
                DefaultTableModel model = (DefaultTableModel)VJ.getTableDataJasa().getModel();
                model.setRowCount(0);
                showJasa();
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
            if (source == VJ.getButtonBack()){
                ControllerMenuPetugas controllerMenuPetugas = new ControllerMenuPetugas(app);
                this.VJ.setVisible(false);
            }
    }
}
