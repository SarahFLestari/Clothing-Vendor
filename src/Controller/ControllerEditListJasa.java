/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.Database;
import Model.*;
import View.ViewEditListJasa;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public final class ControllerEditListJasa implements ActionListener{
    ViewEditListJasa EJ  = new ViewEditListJasa();
    Aplikasi app;
    
    public ControllerEditListJasa(Aplikasi app){
        this.app = app;
        EJ.setVisible(true);
        EJ.addActionListener((ActionListener) this);
        showJasa();
    }

    public void showJasa(){
        Database db = new Database();
        ArrayList<Jasa> ListJasa = db.getListJasa();
        DefaultTableModel model = (DefaultTableModel)EJ.getTableEditJasa().getModel();
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
                //refresh table
                DefaultTableModel model = (DefaultTableModel)EJ.getTableEditJasa().getModel();
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
            
            if (source == EJ.getButtonUpdate()){
                Jasa js = new Jasa(EJ.getInputIdJasa().getText(),EJ.getInputNamaJasa().getText(),Integer.parseInt(EJ.getInputTarif().getText()));
                  app.getDb().updateJasa(js);
//                try {
//                    String query = "UPDATE daftarJasa SET idJasa='"+js.getIdJasa()+"',namaJasa='"+js.getNamaJasa()+"',tarif='"+js.getTarif()+"' WHERE idJasa= '"+js.getIdJasa()+"'";
//                    executeSQLQuery(query,"Jasa berhasil diupdate");
//                } catch (Exception ae){
//                    JOptionPane.showMessageDialog(null, "Maaf, jasa yang ada ingin update gagal ");
//                }
            } else if (source == EJ.getButtonRemove()){
                Jasa js = new Jasa(EJ.getInputIdJasa().getText(),EJ.getInputNamaJasa().getText(),Integer.parseInt(EJ.getInputTarif().getText()));
                   app.getDb().hapusJasa(js);
//                try{
//                String query = "DELETE FROM daftarJasa WHERE idJasa='"+js.getIdJasa()+"'";
//                executeSQLQuery(query,"Jasa berhasil dihapus");
//                } catch (Exception ae){
//                    JOptionPane.showMessageDialog(null, "Maaf, jasa yang ada ingin hapus gagal ");
//                }
            
            } else if (source == EJ.getButtonClean()){
                EJ.getInputIdJasa().setText("");
                EJ.getInputNamaJasa().setText("");
                EJ.getInputTarif().setText("");
            } else if (source == EJ.getButtonBack()){
                new ControllerMenuAdmin(app);
                this.EJ.setVisible(false);
            }    
    }
}

