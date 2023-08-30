/*
 * Saya Muhammad Fadlan Ghafur (2106923) mengerjakan Tugas Masa Depan
 * dalam mata kuliah Desain dan Pemrograman Berorientasi Objek untuk
 * keberkahanNya maka saya tidak melakukan kecurangan seperti 
 * yang telah dispesifikasikan. Aamiin.
 */

/*
 * Class : Obstacle
 * Deskripsi : kelas ini merupakan inheritance game object dimana class ini mengatur tentang model obstacle
 */

package model;

//import library
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import viewmodel.Constants;


public class Obstacle extends GameObject{
   //deklarasi variabel class
    private Image blockImage; //deklarasi variabel image dari bloc
    private final int score;  //deklarasi variabel score
    private boolean standing;  //deklarasi variabel standing
    
    public Obstacle(float x, float y, int width, int height, int score, boolean standing ) { //konstruktor 
        
        super(x, y, width, height);
        this.score = score;
        this.standing = standing;
        
        try {
            blockImage = ImageIO.read(getClass().getResource("/asset/block.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void update() { // void untuk mengupdate posisi obstacle dan collisionBox
        
        updatePos();
        updateCollisionBox();
    }
    
    @Override
    public void render(Graphics g) { // void untuk merender obstacle
        
        g.drawImage(blockImage, (int) x, (int) y, width, height, null);
    }
    
    private void updatePos(){ // void untuk mengupdate posisi 
        y -= Constants.gameOption.GAME_SPEED;
    }

    public float getX(){ // mengambil nilai x si obstacle
        
        return x;
    }
    public float getY(){  // mengambil nilai x si obstacle
       
        return y;
    }
    public int getscore(){ // mengambil nilai score si obstacle
        
        return score;
    }
    public boolean getstanding(){ // mengambil nilai standing si obstacle apakah sudah di jelajahi
        
        return standing;
    }
    public void setstanding(boolean standing){ // meng-set nilai standing si obstacle apakah sudah di jelajahi
        
        this.standing = standing;
    }
    
}
