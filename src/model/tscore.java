/*
 * Saya Muhammad Fadlan Ghafur (2106923) mengerjakan Tugas Masa Depan
 * dalam mata kuliah Desain dan Pemrograman Berorientasi Objek untuk
 * keberkahanNya maka saya tidak melakukan kecurangan seperti 
 * yang telah dispesifikasikan. Aamiin.
 */

/*
 * Class : Tscore
 * Deskripsi : kelas ini merupakan kelas untuk mengatur table pada menu
 */
package model;

import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;


public class tscore extends DB {
     

    public tscore() throws Exception, SQLException{
        
        super();
        
    }

    public void getTscore(){ // mengeksekusi query untuk mengambil semua data pada tabel
        
        try {
            String query = "SELECT * from tscore" ;
            createQuery(query);
        } catch (Exception e) {
            
            System.out.println(e.toString());
        }
    }

    public void getDataTscore(String username) { // mengeksekusi query untuk mengambil 1 record data berdasarkan username
       
        try {
            String query = "SELECT * from tscore WHERE username='" + username + "'";
            createQuery(query);
        } catch (Exception e) {
            // menampilkan error
            System.err.println(e.toString());
        }
    }

    public void insertData(String username, int score, int standing){  //mengeksekusi query untuk memasukkan data atau update data
        
        boolean update = false;     //set utama untuk tidak update
        try {
            tscore titip = new tscore();
            titip.getDataTscore(username);
            
            if(titip.getResult().next()) { // cek apakah username sudah ada dalam database
                update = true;
            } else {
                update = false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        // apabila tidak ditemukan username yang sama
        if(!update){
            try {
                String query = "INSERT INTO tscore VALUES(null, '" + username + "', " + Integer.toString(score) + ", " + Integer.toString(standing) + ")";
                createUpdate(query);
            } catch (Exception e) {
                // menampilkan error
                System.out.println(e.toString());
            }
        }
        else if(update){
            try {
                String query = "UPDATE tscore SET score=" + score + ", standing=" + standing + " WHERE username='" + username + "'";
                createUpdate(query);
            } catch (Exception e) {
                // menampilkan error
                System.out.println(e.getMessage());
            }
        }
    }
    
    // Membuat datatable
    public DefaultTableModel setTable(){
        
        DefaultTableModel dataTable = null;
        try{
            // membuat header tabel
            Object[] column = {"Username", "Score", "Standing"};
            dataTable = new DefaultTableModel(null, column);
            
            // query data untuk ditampilkan di tabel
            String query = "SELECT * from tscore order by score DESC";
            this.createQuery(query);
            // mengambil data per baris
            while(this.getResult().next()){
                Object[] row = new Object[3];
                // mengambil per kolom
                row[0] = this.getResult().getString(2);
                row[1] = this.getResult().getString(3);
                row[2] = this.getResult().getString(4);
                dataTable.addRow(row);
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        // mengembalikan data yang sudah diambil
        return dataTable;
    }
}
