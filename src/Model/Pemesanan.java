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
public class Pemesanan {
    private String email;
    private String nama;
    private String namaBahan;
    private String namaJasa;
    private String jumlahBaju;
    private String totalHarga;
    private String Status;

    public Pemesanan(String email,String nama, String namaBahan, String namaJasa, String jumlahBaju, String totalHarga, String Status) {
        this.email = email;
        this.nama = nama;
        this.namaBahan = namaBahan;
        this.namaJasa = namaJasa;
        this.jumlahBaju = jumlahBaju;
        this.totalHarga = totalHarga;
        this.Status = Status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNamaBahan() {
        return namaBahan;
    }

    public void setNamaBahan(String namaBahan) {
        this.namaBahan = namaBahan;
    }

    public String getNamaJasa() {
        return namaJasa;
    }

    public void setNamaJasa(String namaJasa) {
        this.namaJasa = namaJasa;
    }

    public String getJumlahBaju() {
        return jumlahBaju;
    }

    public void setJumlahBaju(String jumlahBaju) {
        this.jumlahBaju = jumlahBaju;
    }

    public String getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(String totalHarga) {
        this.totalHarga = totalHarga;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
}
