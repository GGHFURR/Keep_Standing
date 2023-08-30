/*
 * Saya Muhammad Fadlan Ghafur (2106923) mengerjakan Tugas Masa Depan
 * dalam mata kuliah Desain dan Pemrograman Berorientasi Objek untuk
 * keberkahanNya maka saya tidak melakukan kecurangan seperti 
 * yang telah dispesifikasikan. Aamiin.
 */

/*
 * Class : Player
 * Deskripsi : kelas ini merupakan inheritance game object dimana class ini mengatur tentang model player
 */
package model;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.ArrayList;
import viewmodel.Constants;

public class Player extends GameObject{
    
    //deklarasi variabel
    private boolean left;
    private boolean up;
    private boolean right;
    private boolean down;
    private boolean inAir = true;
    
    private float playerSpeed = 1f;
    private float jumpStrength = 10.0f;
    private float airSpeed = 0;
    private float gravity = 0.3f;
    private float xSpeed = 0;
    
    
    private int score = 0;
    private int standing = 0;
    Image monyet = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/asset/monyet.png"));
    
    public Player(int x, int y) {
        // konstruktor, set properti parent
        super(x, y, 50, 50);
    }
    
    public void update(ArrayList<Obstacle> ob){
        // mengupdate posisi obstable
        updatePos(ob);
        updateCollisionBox();
    }
    
    @Override
    public void render(Graphics g){
        //merender karakter game
        g.drawImage(monyet, (int)x, (int)y,50, 50, null);

    }
    
    public void updatePos(ArrayList<Obstacle> AOb){

        // mengupdate kondisi player
        if (left) {
            // Jika tombol kiri ditekan
            xSpeed -= playerSpeed;
            setMonyetImage("monyet");
        } else if (right) {
            // Jika tombol kanan ditekan
            xSpeed += playerSpeed + 1;
            setMonyetImage("monyetkanan");
        } else {
            // Jika tidak ada tombol arah yang ditekan
            xSpeed = 0;
        }

        if (xSpeed > 4) {
            // Batasi kecepatan maksimum menjadi 4
            xSpeed = 4;
        } else if (xSpeed < -4) {
            // Batasi kecepatan minimum menjadi -4
            xSpeed = -4;
        }

        if (up && !inAir) {
            // Jika tombol atas ditekan dan tidak sedang dalam udara
            inAir = true;
            airSpeed -= jumpStrength;
            setMonyetImage("monyetloncat");
        }

        if (!inAir && !isOnObstacle(AOb)) {
            // Jika berada di lantai (tidak dalam udara) dan tidak ada tile di bawahnya
            inAir = true;
            setMonyetImage("monyetkanan");
        }

        if (inAir) {
            // Jika sedang dalam udara
            airSpeed += gravity;
            setMonyetImage("monyetloncat");
        }

        if (down) {
            // Jika tombol bawah ditekan
            airSpeed += gravity;
        }

        for (Obstacle ob : AOb) {
            // untuk setiap obstacle
            if (hitBottom().intersects(ob.getCollisionBox())) {
                // jika hit bawah player beririsan dengan hit obstacle
                inAir = false; // berarti tidak di udara
                airSpeed = 0; // kecepatan udara 0
                y = ob.getCollisionBox().y - height; // y tempat collision
                
                if (!ob.getstanding()) {
                    // jika belum terdeteksi collision sebelumnya
                    score += ob.getscore();
                    standing++;
                    ob.setstanding(true);
                }

                if (up) {
                    inAir = true;
                    airSpeed -= jumpStrength;
                }
            }

            // ini adalah kondisi dimana player yang berada diatas obstacle menabrak obstacle lain agar tidak nembus obstacle
            if (hitTop().intersects(ob.getCollisionBox())) {
                // jika nabrak atas
                y = ob.getCollisionBox().y + height + 1;
                airSpeed = 0;

            }

            if (hitLeft().intersects(ob.getCollisionBox())) {
                // jika nabrak kiri
                xSpeed = Constants.gameOption.GAME_SPEED;
                x = ob.getCollisionBox().x + ob.getCollisionBox().width + 1;
            }
            
            //ini adalah kondisi agar player tidak keluar kedalam frame
            if (hitLeft().x < 0) {
                // jika nabrak kiri sampai mentok ke frame game
                x = 0;
            }
        }
        x += xSpeed;
        y += airSpeed;
    }
    
    public boolean isOnObstacle(ArrayList<Obstacle> AOb){
        // method mengecek apakah di lantai
        for(Obstacle ob : AOb){
            // jika batas bawah player beririsan dengan collision box
            if(hitBottom().intersects(ob.getCollisionBox())) return true;
            
        }
        return false;
    }
    public void setScore(int score) {
        // set skor 
        this.score = score;
    }
    
    public void setStanding(int standing) {
        // set skor standing
        this.standing = standing;
    }
    
    public int getScore() {
        // mendapatkan skor
        return this.score;
    }
    
    public int getStanding() {
        // mendapatkan skor standing
        return this.standing;
    }
    public void setMonyetImage(String player) {
        //men-set image player untuk setiap kondisi player
        this.monyet = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/asset/"+ player+".png"));
    }
    
    public Rectangle hitBottom(){
        // membuat hit bawah
        return new Rectangle((int) (x + (width / 2) - (width / 4)), (int) (y + (height / 2)), width / 2, height / 2);
    }
    
    public Rectangle hitTop(){
        // membuat hit atas
        return new Rectangle((int) (x + (width / 2) - (width / 4)), (int) (y), width / 2, height / 2);
    }
    
    public Rectangle hitRight(){
        // membuat hit kanan
        return new Rectangle((int) x + width - 5, (int) y + 5, 5, height - 10);
    }
    
    public Rectangle hitLeft(){
        // membuat hit kiri
        return new Rectangle((int) x, (int) y + 5, 5, height - 10);
    }

    public void setLeft(boolean left) {
        // set player ke kiri
        this.left = left;
    }

    public void setUp(boolean up) {
        // set player ke atas
        this.up = up;
    }

    public void setRight(boolean right) {
        // set player ke kanan
        this.right = right;
    }
    
    public void setDown(boolean down) {
        // set player ke bawah
        this.down = down;
    }
    
    

    
}
