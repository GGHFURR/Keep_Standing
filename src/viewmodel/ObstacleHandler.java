/*
 * Saya Muhammad Fadlan Ghafur (2106923) mengerjakan Tugas Masa Depan
 * dalam mata kuliah Desain dan Pemrograman Berorientasi Objek untuk
 * keberkahanNya maka saya tidak melakukan kecurangan seperti 
 * yang telah dispesifikasikan. Aamiin.
 */

/*
 * Class : Obstacle Handler
 * Deskripsi : kelas ini merupakan kelas untuk mengatur obstacle untuk di tampilkan kedalam game
 */
package viewmodel;

import java.util.Random;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
// mengakses konstanta
import static viewmodel.Constants.gameOption.GAME_HEIGHT;
import static viewmodel.Constants.gameOption.GAME_WIDTH;
// mengakses model
import model.Obstacle;

public class ObstacleHandler {
    private final int MIN_Y = 100; // posisi x minimal
    private final int MIN_X = 0; // posisi x minimal
    private final int MAX_X = GAME_WIDTH - 300;  // posisi x maximal
    private final Random rand = new Random(); // inisialisasi library random
    
    private final int MAX_OBSTACLE = 15; // jumlah maks obstacle dlm 1 frame
    private final int MIN_GAP = 50; // lebar gap minimum antar obstacle
    private int OBS_HEIGHT = 50; // tinggi obstacle
     private int OBS_WIDTH = 50; // lebar obstacle
    private int obstacleNumber = 0; // jumlah obstacle
    private final ArrayList<Obstacle> obstacles = new ArrayList<>(); // list obstacle
    private int score=0; //score yang dihasilkan
    
    
    
    public ObstacleHandler() { //konstruktor kosong untuk meninisialisasi class obstacle handler
       
    }
    public void updateObstacle() {
    // Mengupdate kondisi obstacle
        Iterator<Obstacle> itr = obstacles.iterator(); // Iterator untuk setiap obstacle
        while (itr.hasNext()) {
        // Selama obstacle ada
            Obstacle ob = itr.next();
            if (ob.getY() < 75) {
                // Jika posisi y obstacle melebihi batas y frame
                itr.remove(); // Hilangkan obstacle
                obstacleNumber--; // Decrement jumlah obstacle
            } else {
                // Jika tidak, update posisi obstacle
                ob.update();
            }
        }
    }

    public void renderObstacle(Graphics g) {
        // Merender obstacle
        for (Obstacle ob : obstacles) {
            // Untuk setiap obstacle
            ob.render(g); // Gambar objeknya
        }
    }

    public void addObstacle() {
        // Menambah jumlah obstacle
        if (obstacleNumber < MAX_OBSTACLE) {
            // Jika jumlah obstacle dalam frame masih kurang dari batas maks obstacle
            float x = 0; // Posisi x di paling kiri
            float y = GAME_HEIGHT; // Posisi y sesuai batas bawah
            if (obstacleNumber > 0) {
                // Jika jumlah obstacle lebih dari 1, maka ambil obstacle, simpan data y obstacle
                y = obstacles.get(obstacles.size() - 1).getY() + (MIN_GAP);
            }
            OBS_WIDTH = (rand.nextInt((MAX_X - 50) - MIN_X) + MIN_X);
            score = (int) (Math.random() * 5 + 2) * 5;

            // Buat obstacle baru
            Obstacle obstacle = new Obstacle(x, y, OBS_WIDTH, OBS_HEIGHT, score, false);
            obstacles.add(obstacle); // Tambahkan ke list
            obstacleNumber++; // Increment jumlah obstacle
        }
    }

    public ArrayList<Obstacle> getObstacles() {
        // Mengambil obstacle
        return obstacles;
    }

    
}
