/*
 * Saya Muhammad Fadlan Ghafur (2106923) mengerjakan Tugas Masa Depan
 * dalam mata kuliah Desain dan Pemrograman Berorientasi Objek untuk
 * keberkahanNya maka saya tidak melakukan kecurangan seperti 
 * yang telah dispesifikasikan. Aamiin.
 */

/*
 * Class : Menu
 * Deskripsi : kelas ini merupakan kelas untuk mengatur menu pada awal game
 */

package view;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

import viewmodel.Game;
import viewmodel.Sound;
import model.tscore;


public class Menu extends javax.swing.JFrame {
    // properti
     public Game game; // objek game
    private tscore tscore; // data tabel
    public Clip audio; // backsound
    private String username; // username
    
    public Menu() {
        // konstruktor
        initComponents(); // load component
        this.username = ""; // inisialisasi username
        try {
            // membuat tabel baru
            this.tscore = new tscore();
            // diisi dengan data dari database
            Tscore.setModel(tscore.setTable());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        // memutar suara di menu awal
        Sound bgm = new Sound();
        audio = bgm.playSound(this.audio, "menubgm.wav");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        buttoncopyright = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        buttonplay = new javax.swing.JButton();
        lblMenuTitle = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        buttonquit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tscore = new javax.swing.JTable();
        lblNewUsername = new javax.swing.JLabel();
        textfieldusername = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("tubesdpbo");
        setBackground(new java.awt.Color(51, 153, 255));
        setName("Main Menu"); // NOI18N
        setResizable(false);
        setSize(new java.awt.Dimension(800, 600));

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttoncopyright.setBackground(new java.awt.Color(0, 153, 204));
        buttoncopyright.setFont(new java.awt.Font("Bebas Neue", 0, 14)); // NOI18N
        buttoncopyright.setForeground(new java.awt.Color(255, 255, 255));
        buttoncopyright.setText("Copyright");
        buttoncopyright.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttoncopyrightActionPerformed(evt);
            }
        });
        jPanel1.add(buttoncopyright, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, 20));

        jLabel1.setFont(new java.awt.Font("Bebas Neue", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Welcome to the jungle");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 274, -1));

        buttonplay.setBackground(new java.awt.Color(51, 255, 102));
        buttonplay.setFont(new java.awt.Font("Bebas Neue", 0, 14)); // NOI18N
        buttonplay.setForeground(new java.awt.Color(255, 255, 255));
        buttonplay.setText("Play");
        buttonplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonplayActionPerformed(evt);
            }
        });
        jPanel1.add(buttonplay, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 368, 114, 37));

        lblMenuTitle.setFont(new java.awt.Font("Roaring Jungle", 0, 48)); // NOI18N
        lblMenuTitle.setForeground(new java.awt.Color(255, 153, 51));
        lblMenuTitle.setText("Keep Standing");
        lblMenuTitle.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lblMenuTitle.setAlignmentY(0.0F);
        lblMenuTitle.setIconTextGap(0);
        jPanel1.add(lblMenuTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 310, 50));

        jLabel3.setFont(new java.awt.Font("Roaring Jungle", 0, 48)); // NOI18N
        jLabel3.setText("KEEP STANDING");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 300, -1));

        buttonquit.setBackground(new java.awt.Color(255, 102, 102));
        buttonquit.setFont(new java.awt.Font("Bebas Neue", 0, 14)); // NOI18N
        buttonquit.setForeground(new java.awt.Color(255, 255, 255));
        buttonquit.setText("Quit");
        buttonquit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonquitActionPerformed(evt);
            }
        });
        jPanel1.add(buttonquit, new org.netbeans.lib.awtextra.AbsoluteConstraints(438, 368, 114, 37));

        javax.swing.table.JTableHeader tableHeader = Tscore.getTableHeader();
        tableHeader.setBackground(new java.awt.Color(255, 153, 0)); // Ganti warna sesuai yang diinginkan
        tableHeader.setForeground(new java.awt.Color(0, 0, 0)); // Ganti warna teks sesuai yang diinginkan
        Tscore.setBackground(new java.awt.Color(255, 153, 0));
        Tscore.setFont(new java.awt.Font("Bebas Neue", 0, 18)); // NOI18N
        Tscore.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        Tscore.setToolTipText("");
        Tscore.setAlignmentX(1.0F);
        Tscore.setAlignmentY(1.0F);
        Tscore.setMinimumSize(new java.awt.Dimension(80, 80));
        Tscore.setName(""); // NOI18N
        Tscore.setPreferredSize(new java.awt.Dimension(225, 200));
        Tscore.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TscoreMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tscore);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 174, 340, 170));

        lblNewUsername.setFont(new java.awt.Font("Bebas Neue", 0, 18)); // NOI18N
        lblNewUsername.setForeground(new java.awt.Color(204, 153, 0));
        lblNewUsername.setText("Input Username baru atau pilih  tabel");
        jPanel1.add(lblNewUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 240, -1));

        textfieldusername.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textfieldusername.setToolTipText("Username...");
        textfieldusername.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(textfieldusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 345, 32));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/menubg.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 440));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonquitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonquitActionPerformed
        // TODO add your handling code here:
        this.dispose();
        System.exit(0);
    }//GEN-LAST:event_buttonquitActionPerformed

    private void buttonplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonplayActionPerformed
        // TODO add your handling code here:    
        if(this.username.length() == 0 && textfieldusername.getText().length() != 0) {
            // jika nilai username masih kosong
            // dan text field TFUsername ada isinya
            this.username = textfieldusername.getText();
        }
        if(textfieldusername.getText().length() == 0 && this.username.length() == 0) {
            // jika text field kosong
            // dan nilai username masih kosong (tidak klik dari tabel)
            JOptionPane.showMessageDialog(this, "Username tidak boleh kosong!\nPilih user atau masukkan username baru.");
        } else {
            // sound new game
            Sound bgm = new Sound();
            bgm.stopSound(this.audio);
            
            // buat game baru
            game = new Game();
            GameWindow gw = new GameWindow(game); // buat window
            game.setUsername(this.username); // set username
            // cek apakah username sudah ada di database
            tscore titip = null;
            try {
                titip = new tscore();
            } catch (Exception ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
            titip.getDataTscore(this.username);
            int c = 0, tscore = 0, tstanding = 0;
            try {
                while(titip.getResult().next()){
                    // jika username sudah ada di database,
                    // ambil nilai adapt dan fall nya
                    tscore = Integer.parseInt(titip.getResult().getString(3));
                    tstanding = Integer.parseInt(titip.getResult().getString(4));
                    c++;
                }
            } catch (Exception ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
            // set score adapt dan fall di awal game
            if(c == 0){
                // jika user baru, adapt dan fall 0
                game.setScore(0,0);
            } else {
                // jika user lama, adapt dan fall akumulasi
                game.setScore(tscore, tstanding);
            }
            
            // game dimulai
            game.StartGame(gw);
            this.setVisible(false); // menu window dibuat invisible
            this.dispose(); // menu window di clear
        }
    }//GEN-LAST:event_buttonplayActionPerformed

    private void TscoreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TscoreMouseClicked
        // TODO add your handling code here:
        // jika salah satu record dalam tabel di klik
        int row = Tscore.getSelectedRow();
        // set username dengan username pada tabel yg di klik
        this.username = Tscore.getModel().getValueAt(row, 0).toString();
        textfieldusername.setText(this.username);
    }//GEN-LAST:event_TscoreMouseClicked

    private void buttoncopyrightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttoncopyrightActionPerformed
        // TODO add your handling code here:
         copyright CopyRight = new copyright();
    
        // Menampilkan frame copyright
        CopyRight.setVisible(true);
        CopyRight.setLocationRelativeTo(null);
    }//GEN-LAST:event_buttoncopyrightActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Menu().setVisible(true);
        });
    }
    
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tscore;
    private javax.swing.JButton buttoncopyright;
    private javax.swing.JButton buttonplay;
    private javax.swing.JButton buttonquit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMenuTitle;
    private javax.swing.JLabel lblNewUsername;
    private javax.swing.JTextField textfieldusername;
    // End of variables declaration//GEN-END:variables
}
