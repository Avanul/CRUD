/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiku;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author windows
 */
public class crud_tugas {
    
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
static final String DB_URL = "jdbc:mysql://localhost/fakultas";
static final String USER = "root";
static final String PASS = "";

static Connection conn;
static Statement stmt;
static ResultSet rs;

static InputStreamReader inputStreamReader = new InputStreamReader(System.in);
static BufferedReader input = new BufferedReader(inputStreamReader);
static void showMenu() {
    System.out.println("\n========= MENU UTAMA =========");
    System.out.println("1. Insert Data");
    System.out.println("2. Show Data");
    System.out.println("3. Edit Data");
    System.out.println("4. Delete Data");
    System.out.println("0. Keluar");
    System.out.println("");
    System.out.print("PILIHAN> ");

        
    try {
        int pilihan = Integer.parseInt(input.readLine());

        switch (pilihan) {
            case 0:
                System.exit(0);
                break;
            case 1:
                insert();
                break;
            case 2:
                showData();
                break;
            case 3:
                update();
                break;
            case 4:
                delete();
                break;
            default:
                System.out.println("Pilihan salah!");
        }
    } catch (Exception e) {
       System.out.println("\nPILIH MENU 1 SAMPAI 4");
    }
}
static void showData() {
    String sql = "SELECT * FROM dosen";
    try {
        rs = stmt.executeQuery(sql);
        
        System.out.println("+--------------------------------+");
        System.out.println("|DATA DOSEN DI UNIVERSITAS YUDHARTA|");
        System.out.println("+--------------------------------+");
        while (rs.next()) {
            String iddosen = rs.getString("id_dosen");
            String dosen = rs.getString("nama");
            String alamat = rs.getString("alamat_dosen");
            String hp = rs.getString("no_hp");
            String stat = rs.getString("status");
          
            System.out.println(iddosen+"  |  "+dosen+"    ("+alamat+")    ["+hp+"]      /"+stat+"/");    
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
static void insert() {
    try {
 
        System.out.print("ID DOSEN: ");
        String nim = input.readLine().trim();
        System.out.print("NAMA DOSEN: ");
        String NAMA = input.readLine().trim();
        System.out.print("ALAMAT: ");
        String  AL = input.readLine().trim();
        System.out.print("NO HP: ");
        String HP = input.readLine().trim();
         System.out.print("STATUS DOSEN (AKTIF/TIDAK AKTIF): ");
        String stat = input.readLine().trim();
        // query simpan
        String sql = "INSERT INTO dosen (id_dosen, nama, alamat_dosen, no_hp, status) VALUE('"+nim+"', '"+NAMA+"', '"+AL+"','"+HP+"','"+stat+"')";
      //  sql = String.format(sql, nim, judul, pengarang , HP, stat);
        
 
        stmt.execute(sql);
        
    } catch (Exception e) {
        e.printStackTrace();
    }
}
static void update() {
    try {  
        System.out.print("NIM yang mau diedit: ");
        
        String id = input.readLine().trim();
      System.out.print("NAMA DOSEN: ");
        String NAMA = input.readLine().trim();
        System.out.print("ALAMAT: ");
        String AL = input.readLine().trim();
        System.out.print("NO HP: ");
        String HP = input.readLine().trim();
         System.out.print("STATUS DOSEN (AKTIF/TIDAK AKTIF): ");
        String stat = input.readLine().trim();
      
        // query update
        String sql = "UPDATE dosen SET nama='"+NAMA+"', alamat_dosen='"+AL+"', no_hp='"+HP+"',status='"+stat+"' WHERE id_dosen='"+id+"'";
       // sql = String.format(sql,  judul, pengarang, HP, id);

        // update data 
        stmt.execute(sql);
        
    } catch (Exception e) {
       e.printStackTrace();
        System.out.println("data tidak ditemukan!");
    }
}
static void delete() {
    try {
        
        
        System.out.print("ID dosen yang mau dihapus: ");
       String idDOSEN = input.readLine();
        
        // buat query hapus
        String sql = String.format("DELETE FROM dosen WHERE id_dosen='"+idDOSEN+"'");
        // hapus data
        stmt.execute(sql);
        
        System.out.println("Data telah terhapus...");
    } catch (Exception e) {
        e.printStackTrace();
    }
}

public static void main(String[] args) {
    

    try {
        // register driver
        Class.forName(JDBC_DRIVER);

        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        stmt = conn.createStatement();

        while (!conn.isClosed()) {
            showMenu();
        }

        stmt.close();
        conn.close();

    } catch (Exception e) {
        System.out.println("TIDAK DAPAT MENYAMBUNG KE DATABASE!");
    }

}

}
