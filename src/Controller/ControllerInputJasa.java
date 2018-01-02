/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Aplikasi;
import View.ViewInputJasa;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControllerInputJasa implements ActionListener{
    Aplikasi app;
    ViewInputJasa IJ;

    public ControllerInputJasa(Aplikasi app) {
        this.app = app;
        IJ = new ViewInputJasa();
        IJ.setActionListener(this);
        IJ.setVisible(true);       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
            if (source == IJ.getButtonInput()){
                try {
                    String idJasa = IJ.getIdJasa();
                    String namaJasa = IJ.getNamaJasa();
                    int tarif = Integer.valueOf(IJ.getTarif());
                    app.addJasa(idJasa, namaJasa, tarif);
                } catch (HeadlessException | NumberFormatException ae){
                    JOptionPane.showMessageDialog(null, "Maaf, jasa yang ada ingin update gagal ");
                }
            } else if (source == IJ.getButtonClean()){
                IJ.reset();
            } else if (source == IJ.getButtonBack()){
                ControllerMenuPetugas controllerMenuPetugas = new ControllerMenuPetugas(app);
                this.IJ.setVisible(false);
            }          
    }
}
