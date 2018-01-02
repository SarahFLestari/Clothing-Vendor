/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.Database;
import Model.Aplikasi;
import View.Login;
import View.LoginAdmin;
import View.ViewMenuAdmin;
import View.ViewMenuPetugas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


/**
 *
 * @author giselanggita
 */
public class ControllerLoginAdmin implements ActionListener{
    private LoginAdmin viewlogin;
    private Database db = new Database();
    private Aplikasi app;
    private ViewMenuAdmin ma;
    private Connection conn;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    public ControllerLoginAdmin(Aplikasi app) {
        this.app = app;
        ma = new ViewMenuAdmin();
        viewlogin = new LoginAdmin();
        viewlogin.setActionListener(this);
        viewlogin.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       Object Source = e.getSource();
       
       if (Source == viewlogin.getKlikLogin()){
           conn = db.getConnection();
            String query = "Select * from Admin where username = ? and password = ?";
            try{
                String uname = viewlogin.getUsern().getText();
                String pwd = viewlogin.getPass().getText();
                pst = conn.prepareStatement(query);
                pst.setString(1,viewlogin.getUsern().getText());
                pst.setString(2,viewlogin.getPass().getText());
                rs = pst.executeQuery();
                if(rs.next()){
                    //JOptionPane.showMessageDialog(null,"Berhasil Log in");
                    viewlogin.setVisible(false);
                    new ControllerMenuAdmin(app);   

                } else {
                    JOptionPane.showMessageDialog(null,"Password atau username salah","Access Denied",JOptionPane.ERROR_MESSAGE);
                    viewlogin.setVisible(true);  

                }
            } catch (Exception c) {
                JOptionPane.showMessageDialog(null, c);
            }
           
       } else if (Source == viewlogin.getBack()){
           new ControllerMainMenu(app);
           viewlogin.setVisible(false);
           
       }
    }
    
    
    
}
