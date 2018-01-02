/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.Database;
import Model.AdminPreOrder;
import Model.Aplikasi;
import Model.PreOrder;
import View.ViewEditListPreOrder;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MBP
 */
public class ControllerEditListPreOrder implements ActionListener {
    ViewEditListPreOrder vep = new ViewEditListPreOrder();
    Aplikasi app;
    Database db = new Database();
    Connection Con;

    public ControllerEditListPreOrder(Aplikasi app) {
        this.app = app;
        vep.setVisible(true);
        vep.setActionListener(this);
        showAdminPreOrder();
    }

    public void showAdminPreOrder(){    
    ArrayList<AdminPreOrder> list = db.getAdminPreOrder();
        DefaultTableModel model = (DefaultTableModel)vep.getTablePreOrder1().getModel();
        Object[] row = new Object[7];
        for (int i = 0; i < list.size(); i++){
            row[0] = list.get(i).getId_preorder();
            row[1] = list.get(i).getEmail();
            row[2] = list.get(i).getNama();
            row[3] = list.get(i).getNamaBahan();
            row[4] = list.get(i).getNamaJasa();
            row[5] = list.get(i).getJumlahBaju();
            row[6] = list.get(i).getTotalHarga();
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
                DefaultTableModel model = (DefaultTableModel)vep.getTablePreOrder1().getModel();
                model.setRowCount(0);
                showAdminPreOrder();
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
        AdminPreOrder adm = new AdminPreOrder(vep.getTID().getText(), vep.getTEmail().getText(), vep.getNama().getText(), vep.getTNamaBahan().getText(), vep.getTNamaJasa().getText(), vep.getTJmlBaju().getText(), vep.getTTotalHarga().getText());
        if (source.equals(vep.getBDelete())){
//            try{
//            String query = "DELETE FROM preorder WHERE id_preorder = '"+vep.getTID().getText()+"'";
//            executeSQLQuery(query,"Data berhasil dihapus");
//            } catch (Exception ae){
//                JOptionPane.showMessageDialog(null, "Maaf, data yang ada ingin hapus gagal ");
//            }
            app.getDb().deletePreOrder(adm);
            vep.reset();
        } else if (source.equals(vep.getBBack())){
            new ControllerMenuAdmin(app);
            this.vep.setVisible(false);
        }
 }
    
    
}
