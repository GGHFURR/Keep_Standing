/*
 * Saya Muhammad Fadlan Ghafur (2106923) mengerjakan Tugas Masa Depan
 * dalam mata kuliah Desain dan Pemrograman Berorientasi Objek untuk
 * keberkahanNya maka saya tidak melakukan kecurangan seperti 
 * yang telah dispesifikasikan. Aamiin.
 */

/*
 * Class : Game
 * Deskripsi : kelas ini merupakan kelas untuk mengatur game dan build game
 */

package viewmodel;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.util.Random;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
// mengakses model
import model.Player;
import model.tscore;
// mengakses konstanta
import static viewmodel.Constants.gameOption.GAME_WIDTH;
// mengakses view
import view.GameWindow;
import view.Menu;


public class Game extends JPanel implements Runnable {
    // Properti thread
    private Thread gameThread;
    private boolean running = false; // Deteksi game berjalan

    private GameWindow window; // Window game
    private Clip audio; // Backsound

    // Properti objek dalam game
    private final Player player; // Player
    private PlayerHandler ply_handler = null; 
    private final ObstacleHandler obs_handler; // Obstacle
    private String username; // Username
    private int score; // Skor
    private int standing; // standing
    Image backgroundImage = new ImageIcon(getClass().getResource("/asset/background.jpg")).getImage();
    
    public enum STATE{
        Game,
        GameOver
    }
    
    public Game(){
        // konstruktor
        
        // membuat player dgn posisi random
        Random rand = new Random();
        int playerPos = rand.nextInt(1200 - 800) + 800;
        this.player = new Player(GAME_WIDTH - playerPos, 0);
        
        // membuat obstacle dan player handler
        this.obs_handler = new ObstacleHandler();
        this.ply_handler = new PlayerHandler(player,obs_handler.getObstacles());
        // membuat backsound
     
        Sound bgm = new Sound();
        audio = bgm.playSound(this.audio, "gamebgm.wav");
        
        

    }
    
    // mengeset STATE game
    public STATE gameState = STATE.Game;
    
    public synchronized void StartGame(GameWindow gw){
        // memulai menjalankan game
        gameThread = new Thread(this); // buat thread baru
        gameThread.start(); // Menjalankan thread
        this.window = gw; // Membuat window
        running = true; // set running
    }
    
    @Override
    public void paint(Graphics g) {
        // Membuat Component
        super.paint(g); // Memanggil method paint pada superclass
        
        //merender background game
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        //merender skor
        g.setFont(new java.awt.Font("Bebas Neue", 1, 20));
        g.setColor(Color.WHITE);
        g.drawString("Score : " + Integer.toString(this.score), 900, 20);
        g.drawString("Standing : " + Integer.toString(this.standing), 883, 50);
        
        ply_handler.render(g); // Me-render objek player
        obs_handler.renderObstacle(g); // Me-render objek obstacle
    }

    @Override
    public void run() {
        // meng override method run dari parent Runnable
        while(true){
            // selama true (game loop)
            try {
                updateGame(); // update objek game
                repaint(); // membuat ulang Component (update paint())
                Thread.sleep(1000L/60L); // pause thread
                this.score = player.getScore(); // mengambil skor t
                this.standing = player.getStanding(); // mengambil skor standing
                if(this.player.hitTop().y > 600 ) { //apabila player menabrak batas bawah
                    
                    this.gameState = STATE.GameOver;
                } else if(this.player.hitTop().y < 0) //apabila player menabrak batas atas
                {
                    this.gameState = STATE.GameOver;
                }
                if(gameState == STATE.GameOver) {
                    // jika state saat ini GameOver
                    Sound bgm = new Sound(); 
                    bgm.stopSound(this.audio); // stop bgm
                    saveScore(); // simpan skor 
                    close(); // tutup window
                    new Menu().setVisible(true); // menampilkan menu
                    stopGame(); // stop game
                }
            } catch (InterruptedException ex) {
                // log error
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void updateGame(){
        // update objek dalam game
        obs_handler.addObstacle(); // menambah obstacle
        obs_handler.updateObstacle(); // mengupdate kondisi obstacle
        ply_handler.update(); // mengupdate kondisi player
    }
    
    public synchronized void stopGame() {
        // menghentikan game
        try{
            gameThread.join(); // menghentikan thread
            running = false; // set tidak berjalan
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    void close() {
        // menutup window
        window.CloseWindow();
    }

    public Player getPlayer(){
        // mengambil player
        return this.player;
    }
    
    public void setUsername(String username) {
        // mengeset username game
        this.username = username;
    }
    
    public void setScore(int adapt, int fall) {
        // mengeset skor player di awal game
        this.player.setScore(adapt);
        this.player.setStanding(fall);
    }
    
    public void saveScore() {
        // menyimpan skor saat game over
        // mainkan backsound game over
        Sound gobgm = new Sound();
        audio = gobgm.playSound(this.audio, "die.wav");
        
        try {
            // tambah atau update data (skor adapt dan fall)
            tscore tscore = new tscore();
            tscore.insertData(this.username, this.score, this.standing);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        // menampilan panel game over
        String message = "<html><body>" +
        "<b>Username:</b> " + this.username + "<br>" +
        "<b>Score:</b> " + this.score + "<br>" +
        "<b>Standing:</b> " + this.standing +
        "</body></html>";

        JLabel messageLabel = new JLabel(message);
        Font font = new Font("Bebas Neue", Font.PLAIN, 14);
        messageLabel.setFont(font);
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JOptionPane.showMessageDialog(null, messageLabel, "Ingin Bermain Lagi?", JOptionPane.PLAIN_MESSAGE);
        // berhentikan sound saat panel game over hilang
        gobgm.stopSound(this.audio);
    }
    

    
}
