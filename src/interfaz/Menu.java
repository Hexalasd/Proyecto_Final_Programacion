package interfaz;

import interfaz.clasesAuxiliares.AnimatorSwing;
import interfaz.clasesAuxiliares.FadeOverlay;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;


public class Menu extends javax.swing.JFrame {

private Font pixeloidFont;
private JLabel blackScreen;

private void cargarFuentePixel() {
    try {
        InputStream is = getClass().getResourceAsStream("/PixeloidSans.ttf");
        pixeloidFont = Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(24f);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(pixeloidFont);
    } catch (Exception e) {
        e.printStackTrace();
        pixeloidFont = new Font("SansSerif", Font.PLAIN, 24);
    }
}
    public Menu() {
        initComponents();
        cargarFuentePixel();   
        botonRank.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botonJugar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botonSalir.setCursor(new Cursor(Cursor.HAND_CURSOR));
        AnimatorSwing.floatAnimation(PlaceHolderMenu, 5, 0.03);
        AnimatorSwing.floatAnimation(menuText, 5, 0.03);
        AnimatorSwing.floatAnimation(menuTextBase, 5, 0.03);
        AnimatorSwing.floatAnimation(menuTextShadow, 5, 0.03);
        AnimatorSwing.floatAnimation(jugarBo, 3, 0.04);
        AnimatorSwing.floatAnimation(rankBo, 3, 0.04);
        AnimatorSwing.floatAnimation(exitBo, 3, 0.04);
        AnimatorSwing.floatAnimation(fondo, 6, 0.01);
         botonRank.addMouseListener(new java.awt.event.MouseAdapter() {
         @Override
         public void mouseEntered(java.awt.event.MouseEvent evt) {
         AnimatorSwing.floatAnimation(rank, 3, 0.10); 
    }
        @Override
        public void mouseExited(java.awt.event.MouseEvent evt) {
        AnimatorSwing.stopAnimation(); // detener animación
    }});
          botonSalir.addMouseListener(new java.awt.event.MouseAdapter() {
         @Override
         public void mouseEntered(java.awt.event.MouseEvent evt) {
         AnimatorSwing.floatAnimation(exit, 3, 0.10); 
    }
        @Override
        public void mouseExited(java.awt.event.MouseEvent evt) {
        AnimatorSwing.stopAnimation(); // detener animación
    }});
        botonJugar.addMouseListener(new java.awt.event.MouseAdapter() {
         @Override
         public void mouseEntered(java.awt.event.MouseEvent evt) {
         AnimatorSwing.floatAnimation(jugar, 3, 0.10); 
    }
        @Override
        public void mouseExited(java.awt.event.MouseEvent evt) {
        AnimatorSwing.stopAnimation(); // detener animación
    }});
        // Fade de entrada al abrir la aplicación
         FadeOverlay overlay = new FadeOverlay(30, 2000, Color.WHITE, () -> {
             // Esto se ejecuta cuando termina el fade
             System.out.println("Fade completado!");
         });
         getLayeredPane().add(overlay, JLayeredPane.MODAL_LAYER);
         overlay.setBounds(0, 0, getWidth(), getHeight());
         overlay.start();

         
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        botonJugar = new javax.swing.JButton();
        botonRank = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();
        menuText = new javax.swing.JLabel();
        menuTextBase = new javax.swing.JLabel();
        menuTextShadow = new javax.swing.JLabel();
        PlaceHolderMenu = new javax.swing.JLabel();
        jugarText = new javax.swing.JLabel();
        jugarbase = new javax.swing.JLabel();
        jugarsombra = new javax.swing.JLabel();
        jugarBo = new javax.swing.JLabel();
        jugar = new javax.swing.JLabel();
        jugarlbl1 = new javax.swing.JLabel();
        jugarbase1 = new javax.swing.JLabel();
        jugarsombra1 = new javax.swing.JLabel();
        rankBo = new javax.swing.JLabel();
        rank = new javax.swing.JLabel();
        jugarlbl2 = new javax.swing.JLabel();
        jugarbase2 = new javax.swing.JLabel();
        jugarsombra2 = new javax.swing.JLabel();
        exitBo = new javax.swing.JLabel();
        exit = new javax.swing.JLabel();
        companyText = new javax.swing.JLabel();
        companyText2 = new javax.swing.JLabel();
        version = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(97, 17, 178));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botonJugar.setBorderPainted(false);
        botonJugar.setContentAreaFilled(false);
        botonJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonJugarActionPerformed(evt);
            }
        });
        jPanel1.add(botonJugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 490, 450, 130));

        botonRank.setBorderPainted(false);
        botonRank.setContentAreaFilled(false);
        botonRank.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRankActionPerformed(evt);
            }
        });
        jPanel1.add(botonRank, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 640, 430, 130));

        botonSalir.setBorderPainted(false);
        botonSalir.setContentAreaFilled(false);
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });
        jPanel1.add(botonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 800, 430, 130));

        menuText.setFont(new java.awt.Font("Pixeloid Sans", 0, 100)); // NOI18N
        menuText.setForeground(new java.awt.Color(255, 255, 255));
        menuText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menuText.setText("TRIVIA GALAXY");
        jPanel1.add(menuText, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 160, 800, 190));

        menuTextBase.setFont(new java.awt.Font("Pixeloid Sans", 0, 100)); // NOI18N
        menuTextBase.setForeground(new java.awt.Color(0, 204, 204));
        menuTextBase.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menuTextBase.setText("TRIVIA GALAXY");
        jPanel1.add(menuTextBase, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 130, 800, 260));

        menuTextShadow.setFont(new java.awt.Font("Pixeloid Sans", 0, 102)); // NOI18N
        menuTextShadow.setForeground(new java.awt.Color(62, 94, 128));
        menuTextShadow.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menuTextShadow.setText("TRIVIA GALAXY");
        jPanel1.add(menuTextShadow, new org.netbeans.lib.awtextra.AbsoluteConstraints(535, 130, 930, 270));

        PlaceHolderMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/recursos/TEAL.png"))); // NOI18N
        jPanel1.add(PlaceHolderMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 70, 930, 410));

        jugarText.setFont(new java.awt.Font("Pixeloid Sans", 0, 48)); // NOI18N
        jugarText.setForeground(new java.awt.Color(255, 255, 255));
        jugarText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jugarText.setText("JUGAR");
        jPanel1.add(jugarText, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 520, 200, 70));

        jugarbase.setFont(new java.awt.Font("Pixeloid Sans", 0, 48)); // NOI18N
        jugarbase.setForeground(new java.awt.Color(0, 204, 204));
        jugarbase.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jugarbase.setText("JUGAR");
        jPanel1.add(jugarbase, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 513, 200, 90));

        jugarsombra.setFont(new java.awt.Font("Pixeloid Sans", 0, 50)); // NOI18N
        jugarsombra.setForeground(new java.awt.Color(30, 126, 126));
        jugarsombra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jugarsombra.setText("JUGAR");
        jPanel1.add(jugarsombra, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 520, 250, 80));

        jugarBo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/recursos/jugarBtn.png"))); // NOI18N
        jPanel1.add(jugarBo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 495, 130, 110));

        jugar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/recursos/Jugaf2.png"))); // NOI18N
        jPanel1.add(jugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 450, 730, 170));

        jugarlbl1.setFont(new java.awt.Font("Pixeloid Sans", 0, 48)); // NOI18N
        jugarlbl1.setForeground(new java.awt.Color(255, 255, 255));
        jugarlbl1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jugarlbl1.setText("RANK");
        jPanel1.add(jugarlbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 670, 200, 70));

        jugarbase1.setFont(new java.awt.Font("Pixeloid Sans", 0, 48)); // NOI18N
        jugarbase1.setForeground(new java.awt.Color(0, 204, 204));
        jugarbase1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jugarbase1.setText("RANK");
        jPanel1.add(jugarbase1, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 663, 200, 90));

        jugarsombra1.setFont(new java.awt.Font("Pixeloid Sans", 0, 50)); // NOI18N
        jugarsombra1.setForeground(new java.awt.Color(30, 126, 126));
        jugarsombra1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jugarsombra1.setText("RANK");
        jPanel1.add(jugarsombra1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 670, 250, 80));

        rankBo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/recursos/rankBtn.png"))); // NOI18N
        jPanel1.add(rankBo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 645, 130, 110));

        rank.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/recursos/Jugaf2.png"))); // NOI18N
        jPanel1.add(rank, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 600, 730, 170));

        jugarlbl2.setFont(new java.awt.Font("Pixeloid Sans", 0, 48)); // NOI18N
        jugarlbl2.setForeground(new java.awt.Color(255, 255, 255));
        jugarlbl2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jugarlbl2.setText("SALIR");
        jPanel1.add(jugarlbl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 820, 200, 70));

        jugarbase2.setFont(new java.awt.Font("Pixeloid Sans", 0, 48)); // NOI18N
        jugarbase2.setForeground(new java.awt.Color(153, 0, 153));
        jugarbase2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jugarbase2.setText("SALIR");
        jPanel1.add(jugarbase2, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 813, 200, 90));

        jugarsombra2.setFont(new java.awt.Font("Pixeloid Sans", 0, 50)); // NOI18N
        jugarsombra2.setForeground(new java.awt.Color(92, 71, 125));
        jugarsombra2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jugarsombra2.setText("SALIR");
        jPanel1.add(jugarsombra2, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 820, 250, 80));

        exitBo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/recursos/exitBtnBigger.png"))); // NOI18N
        jPanel1.add(exitBo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 795, 130, 110));

        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/recursos/EXIT.png"))); // NOI18N
        jPanel1.add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 750, 730, 170));

        companyText.setFont(new java.awt.Font("Pixeloid Sans", 0, 14)); // NOI18N
        companyText.setForeground(new java.awt.Color(115, 84, 149));
        companyText.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        companyText.setText("2025 HexSonic@gmail.com all rights reserved ");
        jPanel1.add(companyText, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 1040, 380, 40));

        companyText2.setFont(new java.awt.Font("Pixeloid Sans", 1, 18)); // NOI18N
        companyText2.setForeground(new java.awt.Color(255, 255, 255));
        companyText2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        companyText2.setText("V1.0.0");
        jPanel1.add(companyText2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1830, 10, 80, 40));

        version.setFont(new java.awt.Font("Pixeloid Sans", 0, 14)); // NOI18N
        version.setForeground(new java.awt.Color(115, 84, 149));
        version.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        version.setText("Made and distributed by: HexSonic.inc ");
        jPanel1.add(version, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 1020, 310, 40));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/recursos/kn3ai07br4d11.png"))); // NOI18N
        jPanel1.add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 1080));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1080, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonJugarActionPerformed
        PrePartida entrada = new PrePartida();
        entrada.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botonJugarActionPerformed

    private void botonRankActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRankActionPerformed
        Ranking entrada = new Ranking();
        entrada.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botonRankActionPerformed

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
       this.dispose();
    }//GEN-LAST:event_botonSalirActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel PlaceHolderMenu;
    private javax.swing.JButton botonJugar;
    private javax.swing.JButton botonRank;
    private javax.swing.JButton botonSalir;
    private javax.swing.JLabel companyText;
    private javax.swing.JLabel companyText2;
    private javax.swing.JLabel exit;
    private javax.swing.JLabel exitBo;
    private javax.swing.JLabel fondo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jugar;
    private javax.swing.JLabel jugarBo;
    private javax.swing.JLabel jugarText;
    private javax.swing.JLabel jugarbase;
    private javax.swing.JLabel jugarbase1;
    private javax.swing.JLabel jugarbase2;
    private javax.swing.JLabel jugarlbl1;
    private javax.swing.JLabel jugarlbl2;
    private javax.swing.JLabel jugarsombra;
    private javax.swing.JLabel jugarsombra1;
    private javax.swing.JLabel jugarsombra2;
    private javax.swing.JLabel menuText;
    private javax.swing.JLabel menuTextBase;
    private javax.swing.JLabel menuTextShadow;
    private javax.swing.JLabel rank;
    private javax.swing.JLabel rankBo;
    private javax.swing.JLabel version;
    // End of variables declaration//GEN-END:variables
}
