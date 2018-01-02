/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import View.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerMenuPetugas implements ActionListener{
    private final Aplikasi app;   
    private final ViewMenuPetugas mp;
    
    public ControllerMenuPetugas(Aplikasi app) {
        this.app = app;
        mp = new ViewMenuPetugas();
        mp.setActionListener(this);
        mp.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(mp.getBInputBahan())){
            ControllerInputBahan cInputBahan = new ControllerInputBahan(app);
            this.mp.setVisible(false);
        } else if (source.equals(mp.getBViewBahan())){
            ControllerViewListBahan cViewBahan = new ControllerViewListBahan(app);
            this.mp.setVisible(false);
        } else if (source.equals(mp.getBInputJasa())){
            ControllerInputJasa cInputJasa = new ControllerInputJasa(app);
            this.mp.setVisible(false);      
        } else if (source.equals(mp.getBViewJasa())){
            ControllerViewListJasa cViewJasa = new ControllerViewListJasa(app);
            this.mp.setVisible(false);
        } else if (source.equals(mp.getLogout())){
            new ControllerMainMenu(app);
            mp.setVisible(false);
        }
    }        
}
