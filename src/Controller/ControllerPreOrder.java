/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author MBP
 */
import Database.Database;
import Model.Aplikasi;
import Model.PreOrder;
import View.ViewListPreOrder;
import View.ViewPreOrder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ControllerPreOrder implements ActionListener{
    
    private ViewPreOrder v;
    private ViewListPreOrder vp;
    private Database db = new Database();
    private Aplikasi app;
    private Connection Con;
    
    public ControllerPreOrder(Aplikasi app) {
        this.app = app;
        this.v = new ViewPreOrder();
        //this.vp = new ViewListPreOrder();
        v.setActionListener(this);
        v.setVisible(true);
        //showPreOrder();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int hargabahan = 0;
        int tarif = 0;
        Object source = e.getSource();
        Con = db.getConnection();
        try{
            if (source == v.getCekharga() ){      
                String namaBahan = v.getNamaBahan();
//                String query = "Select harga from daftarBahan where namaBahan = '"+v.getNamaBahan()+"'";
//                PreparedStatement ps = Con.prepareStatement(query);
                ResultSet rs = app.getDb().getHargaBahan(namaBahan);
                
                while(rs.next()){
                    hargabahan = rs.getInt("harga");   
                }
                String namaJasa = v.getNamaJasa();
//                String query2 = "Select tarif from daftarJasa where namaJasa = '"+v.getNamaJasa()+"'";
//                PreparedStatement ps2 = Con.prepareStatement(query2);
                ResultSet rs2 = app.getDb().getTarifJasa(namaJasa);
                while(rs2.next()){
                    tarif = rs2.getInt("tarif");   
                }
                int jmlbaju = Integer.valueOf(v.getJumlahBaju().getText());
                int total = (hargabahan + tarif);
                int totalharga = total * jmlbaju;
                String strtotalharga = String.valueOf(totalharga);
                v.setTotalHarga(strtotalharga);
                
                
            } else if (source == v.getProses() ){
                String nama = v.getNama().getText();
                String email = v.getEmail().getText();
                String namaBahan = v.getNamaBahan();
                String namaJasa = v.getNamaJasa();
                String jmlBaju = v.getJumlahBaju().getText();
                String totalHarga = v.getTotalHarga().getText();
                app.addPreOrder(email, nama, namaBahan, namaJasa, jmlBaju, totalHarga);
                v.reset();
            } else if (source == v.getView()){
                new ControllerViewListPO(app);
                v.setVisible(false);
            } else if (source == v.getBack()){
                new ControllerMainMenu(app);
                v.setVisible(false);
            }   
        } catch (Exception ae) {
            JOptionPane.showMessageDialog(v, ae.getMessage());
            ae.printStackTrace();
            v.reset();
        }
    }
    
   
    
    
}
