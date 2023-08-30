/*
 * Saya Muhammad Fadlan Ghafur (2106923) mengerjakan Tugas Masa Depan
 * dalam mata kuliah Desain dan Pemrograman Berorientasi Objek untuk
 * keberkahanNya maka saya tidak melakukan kecurangan seperti 
 * yang telah dispesifikasikan. Aamiin.
 */

/*
 * Class : GameWindow
 * Deskripsi : kelas ini merupakan kelas untuk mengatur window untuk game
 */
package view;

import java.awt.Canvas;
import javax.swing.JFrame;
import viewmodel.Game;
import viewmodel.KeyInputs;
import static viewmodel.Constants.gameOption.GAME_HEIGHT;
import static viewmodel.Constants.gameOption.GAME_WIDTH;

public class GameWindow extends Canvas {
    // mewarisi kelas Canvas agar bisa digambar dalamnya
    
    // properti JFrame
    JFrame frame;
    
    public GameWindow(Game game){
        // Konstruktor
        String title = "Welcome To The Jungle"; // Menetapkan judul
        frame = new JFrame(title); // Membuat frame
        frame.addKeyListener(new KeyInputs(game)); // Menambahkan key listener
        frame.add(game); // Menambahkan game ke dalam frame
        frame.setSize(GAME_WIDTH, GAME_HEIGHT); // Menetapkan ukuran frame
        frame.setLocationRelativeTo(null); // Menetapkan lokasi frame di tengah
        frame.setResizable(false); // Mencegah resize frame
        frame.setVisible(true); // Menampilkan frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Menetapkan operasi default saat frame ditutup
    }
    
    public void CloseWindow() {
        // menutup window/frame
        frame.setVisible(false); // Membuat frame tidak terlihat
        frame.dispose(); // Membersihkan frame
    }
    
    
}
