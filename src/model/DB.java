/*
 * Saya Muhammad Fadlan Ghafur (2106923) mengerjakan Tugas Masa Depan
 * dalam mata kuliah Desain dan Pemrograman Berorientasi Objek untuk
 * keberkahanNya maka saya tidak melakukan kecurangan seperti 
 * yang telah dispesifikasikan. Aamiin.
 */

/*
 * Class : DB
 * Deskripsi : Class DB ini yang adalah class yang mengatur hubungan dengan database dimana ini untuk data score dan standing
 */


package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DB {
    // data class
    private String connAddress = "jdbc:mysql://localhost/db_tubes?user=root&password=";
    private Statement stmt = null;
    private Connection conn = null;
    private ResultSet rs = null;
    
    public DB() throws Exception, SQLException {
        //Konstruktor ini mengatur untuk koneksikan dengan database MySql
        try {    
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(connAddress);
            conn.setTransactionIsolation(conn.TRANSACTION_READ_UNCOMMITTED);
            
        } catch (SQLException es) { //menangkap pesan eror
            throw es;
        }
    }
    
    public void createQuery(String Query) throws Exception, SQLException { //mengeksekusi query tanpa mengubah data
        
        try {
            stmt = conn.createStatement();
            // eksekusi query
            rs = stmt.executeQuery(Query);
            if(stmt.execute(Query)) {
                // ambil hasil query
                rs = stmt.getResultSet();
            }
        } catch (SQLException e) {
            // error jika query gagal di eksekusi
            throw e;
        }
    }
    
    public void createUpdate(String Query)throws Exception, SQLException { //mengubah query seperti insert,delete dan update
       
        try {
            stmt = conn.createStatement();
            // eksekusi query
            int res = stmt.executeUpdate(Query);
        } catch (SQLException e) {
            // eksekusi jika query gagal di eksekusi
            throw e;
        }
    }
    
    public ResultSet getResult() throws Exception { //mengambil hasil query
        
        ResultSet Temp = null;
        try {
            return rs;
        } catch (Exception e) {
            return Temp;
        }
    }
    
    public void closeResult() throws Exception, SQLException { //menutup query yang dimasukkan 
        if(rs != null) {
            try {
                rs.close();
            }
            catch(SQLException es){
                rs = null;
                throw es;
            }
        }
        if(stmt != null) {
            try {
                stmt.close();
            } catch (SQLException es) {
                stmt = null;
                throw es;
            }
        }
    }
    
    public void closeConnection() throws Exception, SQLException { //menutup koneksi mysql dan database
        
        if(conn != null) {
            try {
                conn.close();
            }
            catch(SQLException es){
                conn = null;
            }
        }
    }
}
