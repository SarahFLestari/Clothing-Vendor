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
import Model.*;
import View.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerMainMenu implements ActionListener{
    private final Aplikasi app;   
    private final MainMenu mm;
    
    public ControllerMainMenu(Aplikasi app) {
        this.app = app;
        mm = new MainMenu();
        mm.setActionListener(this);
        mm.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(mm.getBLogin())){
            new ControllerLoginPetugas(app);
            this.mm.setVisible(false);
        } else if (source.equals(mm.getBLoginAdmin())){
            new ControllerLoginAdmin(app);
            this.mm.setVisible(false);
        } else if (source.equals(mm.getBpreOrder())){
            new ControllerPreOrder(app);
            this.mm.setVisible(false);      
        }
    }        
}
