/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.Database;
import Model.Aplikasi;
import Model.PreOrder;
import View.ViewListPreOrder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MBP
 */
public class ControllerViewListPO implements ActionListener{
    private Aplikasi app;
    private Database db = new Database();
    private ViewListPreOrder vop;
    
    public void showPreOrder(){
        ArrayList<PreOrder> list = db.getPreOrderList();
        DefaultTableModel model = (DefaultTableModel)vop.getTablePreOrder().getModel();
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

    public ControllerViewListPO(Aplikasi app) {
        this.app = app;
        vop = new ViewListPreOrder();
        vop.setActionListener(this);
        vop.setVisible(true);
        showPreOrder();
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(vop.getBack())){
            new ControllerPreOrder(app);
            this.vop.setVisible(false);
        }
    }

    
}
