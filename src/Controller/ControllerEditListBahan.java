/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.Database;
import Model.*;
import View.ViewEditListBahan;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public final class ControllerEditListBahan implements ActionListener{
    ViewEditListBahan EB  = new ViewEditListBahan();
    Aplikasi app;
    
    public ControllerEditListBahan(Aplikasi app){
        this.app = app;
        EB.setVisible(true);
        EB.addActionListener((ActionListener) this);
        showBahan();
    }

    public void showBahan(){
        Database db = new Database();
        ArrayList<Bahan> ListBahan = db.getListBahan();
        DefaultTableModel model = (DefaultTableModel)EB.getTableEditBahan().getModel();
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
                //refresh table
                DefaultTableModel model = (DefaultTableModel)EB.getTableEditBahan().getModel();
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
        //Bahan bhn = new Bahan(EB.getEditIdBahan().getText(),EB.getEditNamaBahan().getText(),Integer.parseInt(EB.getEditHarga().getText()));
            if (source == EB.getButtonUpdate()){
                Bahan bhn = new Bahan(EB.getEditIdBahan().getText(),EB.getEditNamaBahan().getText(),Integer.parseInt(EB.getEditHarga().getText()));
                app.getDb().updateBahan(bhn);
//                try {
//                    String query = "UPDATE daftarBahan SET idBahan='"+EB.getEditIdBahan().getText()+"',namaBahan='"+EB.getEditNamaBahan().getText()+"',harga='"+EB.getEditHarga().getText()+"' WHERE idBahan= '"+EB.getEditIdBahan().getText()+"'";
//                    executeSQLQuery(query,"Bahan berhasil diupdate");
//                } catch (Exception ae){
//                    JOptionPane.showMessageDialog(null, "Maaf, bahan yang ada ingin update gagal ");
//                }
            } else if (source == EB.getButtonRemove()){
                Bahan bhn = new Bahan(EB.getEditIdBahan().getText(),EB.getEditNamaBahan().getText(),Integer.parseInt(EB.getEditHarga().getText()));
                app.getDb().hapusBahan(bhn);
//                try{
//                    String query = "DELETE FROM daftarBahan WHERE idBahan='"+EB.getEditIdBahan().getText()+"'";
//                    executeSQLQuery(query,"Bahan berhasil dihapus");
//                } catch (Exception ae){
//                    JOptionPane.showMessageDialog(null, "Maaf, bahan yang ada ingin hapus gagal ");
//                }
            
            } else if (source == EB.getButtonClean()){
                EB.getEditIdBahan().setText("");
                EB.getEditNamaBahan().setText("");
                EB.getEditHarga().setText("");
            } else if (source == EB.getButtonBack()){
                new ControllerMenuAdmin(app);
                this.EB.setVisible(false);
            }    
    }
}    

