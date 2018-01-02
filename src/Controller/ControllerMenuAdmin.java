/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Aplikasi;
import View.ViewMenuAdmin;
import View.ViewMenuPetugas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author MBP
 */
public class ControllerMenuAdmin implements ActionListener {
    private final Aplikasi app;   
    private final ViewMenuAdmin ma;
    
    public ControllerMenuAdmin(Aplikasi app) {
        this.app = app;
        ma = new ViewMenuAdmin();
        ma.setActionListener(this);
        ma.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(ma.getBEditListBahan())){
            new ControllerEditListBahan(app);
            this.ma.setVisible(false);
        } else if (source.equals(ma.getBEditListJasa())){
            new ControllerEditListJasa(app);
            this.ma.setVisible(false);
        } else if (source.equals(ma.getBUpdate())){
            new ControllerAdminUpdate(app);
            this.ma.setVisible(false);  
        }  else if (source.equals(ma.getBEditListPreOrder())){
            new ControllerEditListPreOrder(app);
            this.ma.setVisible(false);  
        } else if (source.equals(ma.getLogout())){
            new ControllerMainMenu(app);
            this.ma.setVisible(false);
        }
    }
}
