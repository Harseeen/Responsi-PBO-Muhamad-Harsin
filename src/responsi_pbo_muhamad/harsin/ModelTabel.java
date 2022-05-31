/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsi_pbo_muhamad.harsin;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class ModelTabel {
    String DBurl = "jdbc:mysql://localhost/testing";
    String DBUsername = "root";
    String DBPassword = "";
    Connection koneksi;
    Statement statement;
    

    public ModelTabel() {
    try{
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = (Connection) DriverManager.getConnection(DBurl, DBUsername, DBPassword);
            System.out.println("Koneksi Berhasil");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
        }
    }

    public String[][] TabelList(){
    
    try{
            int jmlData = 0;
            
            String data[][] = new String[getBanyakData()][5]; //baris, kolom nya ada 4
            
            String query = "Select * from aslab"; 
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[jmlData][0] = resultSet.getString("Nama"); //harus sesuai nama kolom di mysql
                data[jmlData][1] = resultSet.getString("Portofolio");                
                data[jmlData][2] = resultSet.getString("microteaching");
                data[jmlData][3] = resultSet.getString("wawancara");
                data[jmlData][4] = resultSet.getString("nilai");
                jmlData++;
            }
            return data;
               
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }

    public void inserttabel(String Nama, String portofolio, String microteaching, String wawancara){
     int jmlData=0;
     double fportofolio=Float.parseFloat(portofolio);
     double fmicroteaching=Float.parseFloat(microteaching);
     double fwawancara=Float.parseFloat(wawancara);
     double nilai = (fportofolio + fmicroteaching +fwawancara)/3;
        try {
           String query = "Select * from aslab WHERE Nama = '" + Nama + "' "; 
           System.out.println(Nama + " " + fportofolio + " " + fmicroteaching + " " + fwawancara + " " + nilai);
           ResultSet resultSet = statement.executeQuery(query);
           
           while (resultSet.next()){ 
                jmlData++;
            }
            
            if (jmlData==0) {
                query = "INSERT INTO aslab VALUES('"+Nama+"','"+fportofolio+"','"+fmicroteaching+"','"+fwawancara+"','"+nilai+"')";
           
                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(query); //execute querynya
                System.out.println("Berhasil ditambahkan");
                JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");
            }
            else {
                JOptionPane.showMessageDialog(null, "Data sudah ada");
            }
        } catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    
    
    }
    
    public void updateTabel(String Nama, String portofolio, String microteaching, String wawancara){
        int jmlData=0;
        double fportofolio=Float.parseFloat(portofolio);
     double fmicroteaching=Float.parseFloat(microteaching);
     double fwawancara=Float.parseFloat(wawancara);
        double nilai = (fportofolio + fmicroteaching +fwawancara)/3; 
        try {
           String query = "Select * from aslab WHERE Nama= '" + Nama + "' "; 
           ResultSet resultSet = statement.executeQuery(query);
           
           while (resultSet.next()){ 
                jmlData++;
            }
           
             if (jmlData==1) {
                query = "UPDATE aslab SET portofolio='" + fportofolio + "', microteaching='" + fmicroteaching + "', nilai='" + nilai + "', wawancara = '" + wawancara +"' WHERE Nama='" + Nama +"'";
                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(query); //execute querynya
                System.out.println("Berhasil diupdate");
                JOptionPane.showMessageDialog(null, "Data Berhasil diupdate");
             }
             else {
                 JOptionPane.showMessageDialog(null, "Data Tidak Ada");
             }
           
        } catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }

public int getBanyakData(){
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "Select * from aslab";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){ 
                jmlData++;
            }
            return jmlData;
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }

 public void deleteTabel (String Nama) {
        try{
            String query = "DELETE FROM aslab WHERE Nama = '"+Nama+"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
            
        }catch(SQLException sql) {
            System.out.println(sql.getMessage());
        }
    }



}

