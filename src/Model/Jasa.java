/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

public class Jasa{
    private String idJasa;
    private String namaJasa;
    private int tarif;

    public Jasa(String idJasa, String namaJasa, int tarif) {
        this.idJasa = idJasa;
        this.namaJasa = namaJasa;
        this.tarif = tarif;
    }

    public String getIdJasa() {
        return idJasa;
    }

    public void setIdJasa(String idJasa) {
        this.idJasa = idJasa;
    }

    public String getNamaJasa() {
        return namaJasa;
    }

    public void setNamaJasa(String namaJasa) {
        this.namaJasa = namaJasa;
    }

    public int getTarif() {
        return tarif;
    }

    public void setTarif(int tarif) {
        this.tarif = tarif;
    }
    
    @Override
    public String toString() {
        return    "ID Jasa\t : " + getIdJasa() + '\n'
                + "Nama Jasa\t : " + getNamaJasa() + '\n'
                + "Tarif\t : " + getTarif() + '\n';
    }
}
