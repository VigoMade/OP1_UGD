/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import connection.DbConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Pustaka;

/**
    Kelas    : PBO A
 * Anggota :
 * 1. Vigo Made Prastyo      (210711303)
 * 2. Gede Koosei Wibawa   (210711308
 */
public class PustakaDAO {
    private DbConnection dbCon = new DbConnection();
    private Connection con;
    
    public void insertDataPustaka(Pustaka p){
        con = dbCon.makeConnection();
        String sql = "INSERT INTO Pustaka(id_pustaka,judul,jenis,tahunTerbit,penerbit,edisi,volume)"
            +"Values ('"+p.getId_pustaka()+"', '"+p.getJudul()+"', '"+p.getJenis()+"', '"+p.getTahunTerbit()+"', '"+
                p.getPenerbit()+"', '"+p.getEdisi()+"', '"+p.getVolume() +"')";
        
        System.out.println("Adding data Pustaka...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added "+result+" data Pustaka");
            statement.close();
        }catch(Exception e){
            System.out.println("Error Adding data Pustaka");
            System.out.println(e);
        }
        dbCon.closeConnection();;
    }
    
    public List<Pustaka> showDataPustaka(){
        con=dbCon.makeConnection();
        
        String sql = "select * from Pustaka";
        System.out.println("Mengambil data Pustaka...");
        
        List<Pustaka> list = new ArrayList<>();
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs!=null){
                while(rs.next()){
                    Pustaka p = new  Pustaka(
                            rs.getString("id_pustaka"),
                            rs.getString("judul"),
                            rs.getString("jenis"), 
                            rs.getString("tahunTerbit"),
                            rs.getString("penerbit"), 
                            rs.getInt("edisi"),
                            rs.getInt("volume")
                    );
                    
                    list.add(p);
                }
            }
            rs.close();
            statement.close();
        }catch(Exception e){
            System.out.println("Error reading database...");
            System.out.println(e);
        }
        return list;
    }
    
     public Pustaka searchDataPustaka(String id_pustaka) {
        con = dbCon.makeConnection();
        
        String sql = "SELECT *FROM Pustaka where id_pustaka = '" +id_pustaka+"'";
         System.out.println("Searching data Pustaka...");
         Pustaka p = null;
         
         try{
             Statement statement = con.createStatement();
             ResultSet rs = statement.executeQuery(sql);
             
             if(rs != null){
                 while(rs.next()){
                     p = new Pustaka(
                     rs.getString("id_pustaka"),
                     rs.getString("judul"),
                     rs.getString("jenis"),
                     rs.getString("tahunTerbit"),
                     rs.getString("penerbit"),
                     Integer.parseInt(rs.getString("edisi")),
                     Integer.parseInt(rs.getString("volume"))
                     );
                 }
             }
             rs.close();
             statement.close();
         }catch(Exception e){
             System.out.println("Error Reading database...");
             System.out.println(e);
         }
         dbCon.closeConnection();
         
         return p;
    }
     
      public void updateDataPustaka(Pustaka p, String id_pustaka){
        con = dbCon.makeConnection();
        String sql = "UPDATE Pustaka SET judul = '"+p.getJudul()+"',"
                +"jenis = '"+p.getJenis()+"',"
                +"tahunTerbit = '"+p.getTahunTerbit()+"',"
                +"penerbit = '"+p.getPenerbit()+"',"
                +"edisi= '"+p.getEdisi()+"',"
                +"volume = '" +p.getVolume()+ "' "
                +"WHERE id_pustaka= '"+ id_pustaka +"'";
          System.out.println("Editing...");
          
          try{
              Statement statement = con.createStatement();
              int result = statement.executeUpdate(sql);
              System.out.println("Edited "+ result + " Pustaka "+id_pustaka );
              statement.close();
          }catch(Exception e){
              System.out.println("Error reading database...");
              System.out.println(e);
          }
          dbCon.closeConnection();
    }
      
      public void deleteDataKendaraan(String id_pustaka){
      con = dbCon.makeConnection();
      
      String sql = "DELETE FROM Pustaka WHERE id_pustaka = '" 
              +id_pustaka+"'";
          System.out.println("Deleting kendaraan...");
          
          try{
              Statement statement = con.createStatement();
              int result = statement.executeUpdate(sql);
              System.out.println("Delete "+result+ "Pustaka "+id_pustaka);
              statement.close();
              
          }catch(Exception e){
              System.out.println("Error reading database...");
              System.out.println(e);
          }
          dbCon.closeConnection();
      }
}
