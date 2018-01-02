/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Database.Database;
import Model.*;
import View.ViewAdminUpdate;
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
/**
 *
 * @author MBP
 */
public class ControllerAdminUpdate implements ActionListener {
    private Aplikasi app;
    private Database db = new Database();
    private ViewAdminUpdate vau;
    
    public void showPreOrder(){
        ArrayList<PreOrder> list = db.getPreOrderList();
        DefaultTableModel model = (DefaultTableModel)vau.getTablePreOrder1().getModel();
        Object[] row = new Object[6];
        for (int i = 0; i < list.size(); i++){
            row[0] = list.get(i).getEmail();
            row[1] = list.get(i).getNama();
            row[2] = list.get(i).getNamaBahan();
            row[3] = list.get(i).getNamaJasa();
            row[4] = list.get(i).getJumlahBaju();
            row[5] = list.get(i).getTotalHarga();
            model.addRow(row);    
        }
    }


    public ControllerAdminUpdate(Aplikasi app) {
        this.app = app;
        vau = new ViewAdminUpdate();
        vau.setActionListener(this);
        vau.setVisible(true);
        showPreOrder();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(vau.getBUpdate())){
            String nama = vau.getTNama().getText();
            String email = vau.getTEmail().getText();
            String namaBahan = vau.getTNamaBahan().getText();
            String namaJasa = vau.getTNamaJasa().getText();
            String jmlBaju = vau.getTJmlBaju().getText();
            String totalHarga = vau.getTTotalHarga().getText();
            String Status = vau.getTStatus().getText();
            app.addPemesanan(email, nama, namaBahan, namaJasa, jmlBaju, totalHarga, Status);
            vau.reset(); 
        } else if (source.equals(vau.getViewUpdate())){
            new ControllerViewStatus(app);
            vau.setVisible(false);
        } else if (source.equals(vau.getBBack())){
            new ControllerMenuAdmin(app);
            vau.setVisible(false);
        }
    }
    
}
