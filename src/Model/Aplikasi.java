/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Database.Database;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Aplikasi {
    private Database db;
    private ArrayList<PreOrder> daftarPreOrder;
    private ArrayList<Bahan> daftarBahan;
    private ArrayList<Jasa> daftarJasa;
    private ArrayList<Pemesanan> daftarPemesanan;
    private ArrayList<AdminPreOrder> daftarAdminPreOrder;

    public Aplikasi() {
        db = new Database();
        db.setConnection();
        daftarBahan = db.loadBahan();
        daftarJasa = db.loadJasa();
        daftarPreOrder = db.getPreOrderList();
        daftarPemesanan = db.getPemesanan();
        daftarAdminPreOrder = db.getAdminPreOrder();
    }
    
    public ArrayList<PreOrder> getDaftarPreOrder() {
        daftarPreOrder = db.getPreOrderList();
        return daftarPreOrder;
    }

    public ArrayList<Pemesanan> getDaftarPemesanan() {
        daftarPemesanan = db.getPemesanan();
        return daftarPemesanan;
    }

    public ArrayList<AdminPreOrder> getDaftarAdminPreOrder() {
        daftarAdminPreOrder = db.getAdminPreOrder();
        return daftarAdminPreOrder;
    }

    
    public void addPreOrder(String email,String nama, String namaBahan, String namaJasa, String jumlahBaju, String totalHarga){
        PreOrder p = new PreOrder(email,nama,namaBahan,namaJasa,jumlahBaju,totalHarga);
        daftarPreOrder.add(p);
        db.savePreOrder(p);
    }
    public void addPemesanan(String email,String nama, String namaBahan, String namaJasa, String jumlahBaju, String totalHarga, String Status){
        Pemesanan pm = new Pemesanan(email,nama,namaBahan,namaJasa,jumlahBaju,totalHarga, Status);
        daftarPemesanan.add(pm);
        db.savePemesanan(pm);
    }
    
    public void addBahan(String idBahan, String namaBahan, int harga) {
        if (getBahan(idBahan) != null) {
            JOptionPane.showMessageDialog(null, "Id Bahan telah dipakai");
        }
        Bahan b = new Bahan(idBahan, namaBahan, harga);
        daftarBahan.add(b);
        db.saveBahan(b);
          
    }
    
    public Bahan getBahan(String idBahan) {
        for (Bahan b : daftarBahan) {
            if (b.getIdBahan().equals(idBahan)) {
                return b;
            }
        }
        return null;
    } 
    
    public void addJasa(String idJasa, String namaJasa, int tarif) {
        if (getJasa(idJasa) != null) {
            JOptionPane.showMessageDialog(null, "Id Jasa telah dipakai");
        }
        Jasa j = new Jasa(idJasa, namaJasa, tarif);
        daftarJasa.add(j);
        db.saveJasa(j);
          
    }

    public Jasa getJasa(String idJasa) {
        for (Jasa j : daftarJasa) {
            if (j.getIdJasa().equals(idJasa)) {
                return j;
            }
        }
        return null;
    }

    public Database getDb() {
        return db;
    }
    
}
