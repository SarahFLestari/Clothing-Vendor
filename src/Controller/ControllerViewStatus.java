/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.Database;
import Model.Aplikasi;
import Model.Pemesanan;
import Model.PreOrder;
import View.ViewAdminUpdate;
import View.ViewListPreOrder;
import View.ViewStatus;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MBP
 */
public class ControllerViewStatus implements ActionListener{
    private Aplikasi app;
    private Database db = new Database();
    private ViewStatus vs;
    
      public void showPemesanan(){
        ArrayList<Pemesanan> list = db.getPemesanan();
        DefaultTableModel model = (DefaultTableModel)vs.getTabelPemesanan().getModel();
        Object[] row = new Object[7];
        for (int i = 0; i < list.size(); i++){
            row[0] = list.get(i).getEmail();
            row[1] = list.get(i).getNama();
            row[2] = list.get(i).getNamaBahan();
            row[3] = list.get(i).getNamaJasa();
            row[4] = list.get(i).getJumlahBaju();
            row[5] = list.get(i).getTotalHarga();
            row[6] = list.get(i).getStatus();
            model.addRow(row);    
        }
    }

    public ControllerViewStatus(Aplikasi app) {
        this.app = app;
        vs = new ViewStatus();
        vs.setActionListener(this);
        vs.setVisible(true);
        showPemesanan();
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(vs.getBBack())){
            new ControllerAdminUpdate(app);
            this.vs.setVisible(false);
        }
    }
}
