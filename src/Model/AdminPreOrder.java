/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author MBP
 */
public class AdminPreOrder {
    private String email;
    private String nama;
    private String namaBahan;
    private String namaJasa;
    private String jumlahBaju;
    private String totalHarga;
    private String id_preorder;

    public AdminPreOrder(String id_preorder, String email,String nama, String namaBahan, String namaJasa, String jumlahBaju, String totalHarga) {
        this.email = email;
        this.nama = nama;
        this.namaBahan = namaBahan;
        this.namaJasa = namaJasa;
        this.jumlahBaju = jumlahBaju;
        this.totalHarga = totalHarga;
        this.id_preorder = id_preorder;
    }

    public String getEmail() {
        return email;
    }

    public String getId_preorder() {
        return id_preorder;
    }

    public void setId_preorder(String id_preorder) {
        this.id_preorder = id_preorder;
    }

    public String getNama() {
        return nama;
    }

    public String getNamaBahan() {
        return namaBahan;
    }

    public String getNamaJasa() {
        return namaJasa;
    }

    public String getJumlahBaju() {
        return jumlahBaju;
    }

    public String getTotalHarga() {
        return totalHarga;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNamaBahan(String namaBahan) {
        this.namaBahan = namaBahan;
    }

    public void setNamaJasa(String namaJasa) {
        this.namaJasa = namaJasa;
    }

    public void setJumlahBaju(String jumlahBaju) {
        this.jumlahBaju = jumlahBaju;
    }

    public void setTotalHarga(String totalHarga) {
        this.totalHarga = totalHarga;
    }
    
}
