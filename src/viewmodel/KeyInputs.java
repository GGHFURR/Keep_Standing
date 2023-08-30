/*
 * Saya Muhammad Fadlan Ghafur (2106923) mengerjakan Tugas Masa Depan
 * dalam mata kuliah Desain dan Pemrograman Berorientasi Objek untuk
 * keberkahanNya maka saya tidak melakukan kecurangan seperti 
 * yang telah dispesifikasikan. Aamiin.
 */

/*
 * Class : keyInputs
 * Deskripsi : kelas ini merupakan kelas untuk mengatur inputan user terhadap game
 */
package viewmodel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import viewmodel.Game.STATE;

public class KeyInputs implements KeyListener{
    // mewarisi interface KeyListener agar bisa menerima input keyboard
    
    // properti game
    private final Game game;

    public KeyInputs(Game game) {
        // konstruktor
        this.game = game; // set game
    }
    
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            // daftar key untuk bergerak 4 arah
            case KeyEvent.VK_UP -> game.getPlayer().setUp(true); // atas
            case KeyEvent.VK_LEFT -> game.getPlayer().setLeft(true); // kiri
            case KeyEvent.VK_DOWN -> game.getPlayer().setDown(true); //bawah
            case KeyEvent.VK_RIGHT -> game.getPlayer().setRight(true); // kanan
        }
        
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_SPACE) {
            // key untuk menghentikan game
            game.gameState = STATE.GameOver; // ubah state menjadi game over
            // System.out.println("stop");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP -> game.getPlayer().setUp(false);
            case KeyEvent.VK_LEFT -> game.getPlayer().setLeft(false);
            case KeyEvent.VK_DOWN -> game.getPlayer().setDown(false);
            case KeyEvent.VK_RIGHT -> game.getPlayer().setRight(false);
        }
    }
    
}
