/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;
import java.util.List;
import dao.PustakaDAO;
import model.Pustaka;

/**
    Kelas    : PBO A
 * Anggota :
 * 1. Vigo Made Prastyo      (210711303)
 * 2. Gede Koosei Wibawa   (210711308
 */
public class PustakaControl {
    private PustakaDAO pDao = new PustakaDAO();
    
    public void insertDataPustaka(Pustaka p){
        pDao.insertDataPustaka(p);
    }
    
    public List<Pustaka> showListAllPustaka(){
        List<Pustaka> dataPustaka = pDao.showDataPustaka();
        return dataPustaka;
    }
    
    public String showDataBuku(){
        List<Pustaka> dataPustaka = pDao.showDataPustaka();
        String jenisString = "";
        
        for(int i=0; i<dataPustaka.size();i++){
            if(dataPustaka.get(i).getJenis().equals("Buku")){
              jenisString = jenisString +  dataPustaka.get(i).showData() +  "\nEdisi : " + dataPustaka.get(i).getEdisi()+"\n";
               
            }
        }
        return jenisString;
    }
    
    public String showDataMajalah(){
        List<Pustaka> dataPustaka = pDao.showDataPustaka();
        String jenisString = "";
        
        for(int i=0; i<dataPustaka.size();i++){
            if(dataPustaka.get(i).getJenis().equals("Majalah")){
              jenisString = jenisString +  dataPustaka.get(i).showData() +  "\nVolume : " + dataPustaka.get(i).getVolume()+"\n";
               
            }
        }
        return jenisString;
    }
    
    public void updateDataPustaka(Pustaka p,String id_pustaka){
        pDao.updateDataPustaka(p, id_pustaka);
    }
    
    public void deleteDataKendaraan(String id_pustaka){
        pDao.deleteDataKendaraan(id_pustaka);
    }
    
    public Pustaka searchDataPustaka(String id_pustaka){
        Pustaka p = null;
        p = pDao.searchDataPustaka(id_pustaka);
        return p;
    }
}
