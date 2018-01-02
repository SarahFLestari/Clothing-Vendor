/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

public class Bahan {
        private String idBahan;
    private String namaBahan;
    private int harga;

    public Bahan(String idBahan, String namaBahan, int harga) {
        this.idBahan = idBahan;
        this.namaBahan = namaBahan;
        this.harga = harga;
    }

    public String getIdBahan() {
        return idBahan;
    }

    public void setIdBahan(String idBahan) {
        this.idBahan = idBahan;
    }

    public String getNamaBahan() {
        return namaBahan;
    }

    public void setNamaBahan(String namaBahan) {
        this.namaBahan = namaBahan;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    @Override
    public String toString() {
        return    "ID Bahan\t : " + getIdBahan() + '\n'
                + "Nama Bahan\t : " + getNamaBahan() + '\n'
                + "Harga\t : " + getHarga() + '\n';
    }
}
