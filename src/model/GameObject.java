/*
 * Saya Muhammad Fadlan Ghafur (2106923) mengerjakan Tugas Masa Depan
 * dalam mata kuliah Desain dan Pemrograman Berorientasi Objek untuk
 * keberkahanNya maka saya tidak melakukan kecurangan seperti 
 * yang telah dispesifikasikan. Aamiin.
 */

/*
 * Class : Game Object
 * Deskripsi : dalam class ini mengatur semua hal yang berbasis objek di dalam game seperti player dan obstacle
 */
package model;

//import library
import java.awt.Graphics;
import java.awt.Rectangle;


public abstract class GameObject {

    //deklarasi variabel class
    
    protected float x;
    protected float y;
    protected int width;
    protected int height;
    protected Rectangle collisionBox;
    
    public GameObject(float x, float y, int width, int height) { //konstruktor
        
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.collisionBox = new Rectangle((int)x, (int)y, width, height); //membuat area rectangle dari parameter konstruktor
    }
    
    protected void updateCollisionBox(){ //mengapdet posisi collision box pada game
        
        this.collisionBox.x = (int) x;
        this.collisionBox.y = (int) y;
    }

    public Rectangle getCollisionBox() { //mengembalikan area objek 
        
        return this.collisionBox;
    }
    
    public abstract void render(Graphics g); //abstract kelass render untuk menampilkan objek kedalam game
    
}
