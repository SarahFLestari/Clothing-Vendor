/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Aplikasi;
import View.ViewInputBahan;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControllerInputBahan implements ActionListener{
    private Aplikasi app;
    private ViewInputBahan IB;

    public ControllerInputBahan(Aplikasi app) {
        this.app = app;
        this.IB = new ViewInputBahan();
        IB.setActionListener(this);
        IB.setVisible(true);       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
            if (source == IB.getButtonInput()){
                try {
                    String idBahan = IB.getIdBahan();
                    String namaBahan = IB.getNamaBahan();
                    int harga = Integer.valueOf(IB.getHarga());
                    app.addBahan(idBahan, namaBahan, harga);
                } catch (HeadlessException | NumberFormatException ae){
                    JOptionPane.showMessageDialog(null, "Maaf, bahan yang ada ingin update gagal ");
                }
            } else if (source == IB.getButtonClean()){
                IB.reset();
            } else if (source == IB.getButtonBack()){
                ControllerMenuPetugas controllerMenuPetugas = new ControllerMenuPetugas(app);
                this.IB.setVisible(false);
            }  
    }
}
