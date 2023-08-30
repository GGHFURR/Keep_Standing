/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/*
 * Saya Muhammad Fadlan Ghafur (2106923) mengerjakan Tugas Masa Depan
 * dalam mata kuliah Desain dan Pemrograman Berorientasi Objek untuk
 * keberkahanNya maka saya tidak melakukan kecurangan seperti 
 * yang telah dispesifikasikan. Aamiin.
 */

/*
 * Class : Player Handler
 * Deskripsi : kelas ini merupakan kelas untuk mengatur player untuk di tampilkan kedalam game
 */
package viewmodel;

/**
 *
 * @author fadhl
 */

import java.awt.Graphics;
import java.util.ArrayList;
import model.Obstacle;
import model.Player;

public class PlayerHandler  { 
    private Player player; //deklarasi variabel player
    private ArrayList<Obstacle> obstacles; //deklarasi variabel list obstacle

    public PlayerHandler(Player player, ArrayList<Obstacle> obstacles) {    //lkontrukstor
        this.player = player;
        this.obstacles = obstacles;
    }

    public void update() {  //apabila class game meminta untuk update player baik itu posisi
        player.update(obstacles);
    }

    public void render(Graphics g) { //render player ke game
        player.render(g);
    }
}
