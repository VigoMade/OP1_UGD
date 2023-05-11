/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
    Kelas    : PBO A
 * Anggota :
 * 1. Vigo Made Prastyo      (210711303)
 * 2. Gede Koosei Wibawa   (210711308
 */
public class Pustaka {
    private String id_pustaka;
    private String judul;
    private String jenis;
    private String tahunTerbit;
    private String penerbit;
    private int edisi;
    private int volume;

    public Pustaka(String id_pustaka, String judul,String jenis, String tahunTerbit, String penerbit, int edisi, int volume) {
        this.id_pustaka = id_pustaka;
        this.judul = judul;
        this.jenis = jenis;
        this.tahunTerbit = tahunTerbit;
        this.penerbit = penerbit;
        this.edisi = edisi;
        this.volume = volume;
    }

    public String getJenis() {
        return jenis;
    }

    public String getId_pustaka() {
        return id_pustaka;
    }

    public String getJudul() {
        return judul;
    }

    public String getTahunTerbit() {
        return tahunTerbit;
    }

    public String getPenerbit() {
        return penerbit;
    }

    public int getEdisi() {
        return edisi;
    }

    public int getVolume() {
        return volume;
    }

    public void setId_pustaka(String id_pustaka) {
        this.id_pustaka = id_pustaka;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setTahunTerbit(String tahunTerbit) {
        this.tahunTerbit = tahunTerbit;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }

    public void setEdisi(int edisi) {
        this.edisi = edisi;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }
    
    public String showData(){
        return
                "\n" +
                "ID : " + this.id_pustaka + 
                "\nJudul : " + this.judul + 
                "\nTahun : " + this.tahunTerbit + 
                "\nPenerbit : " + this.penerbit;  
    }
           
}
