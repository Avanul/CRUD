/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiku;
/**
 *
 * @author windows
 */

// import bumbu-bumbu yang diperlukan
/*import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
*/

// bisa juga diimpor sekaligus seperti ini:
 import java.sql.*;
import javax.swing.JOptionPane;
public class AplikasiKU {
    // Menyiapkan paramter JDBC untuk koneksi ke datbase
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/fakultas";
    static final String USER = "root";
    static final String PASS = "root";

    // Menyiapkan objek yang diperlukan untuk mengelola database
    static Connection conn;
    static Statement stmt;
    static ResultSet rs;

    public static void main(String[] args) {
        
        // Melakukan koneksi ke database
        // harus dibungkus dalam blok try/catch
        try {
            // register driver yang akan dipakai
            Class.forName(JDBC_DRIVER);
            
            // buat koneksi ke database
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            // buat objek statement
            stmt = conn.createStatement();
            
            // buat query ke database
            String sql = "SELECT * FROM mahasiswa";
            
            // eksekusi query dan simpan hasilnya di obj ResultSet
            rs = stmt.executeQuery(sql);
            
            // tampilkan hasil query
            //contoh
         /*   while(rs.next()){
                System.out.println("ID Buku: " + rs.getInt("id_buku"));
                System.out.println("Judul: " + rs.getString("judul"));
                System.out.println("Pengarang: " + rs.getString("pengarang"));
            }*/
            
            //modif
              while(rs.next()){
               System.out.println("NIM: " + rs.getLong("nim"));
                System.out.println("NAMA MAHASISWA: " + rs.getString("nama_m"));
                System.out.println("NAMA ORANG TUA: " + rs.getString("nama_orangtua"));
                System.out.println("");
            }
            stmt.close();
            conn.close();
            
        } catch (Exception e) {
          //  e.printStackTrace();
        JOptionPane.showMessageDialog(null,"database masalah");
            System.out.println("");
        }

    }
    
}
