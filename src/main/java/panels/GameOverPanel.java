/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panels;

import control.Controller;
import global.Global;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.ResourceBundle;
import javax.swing.ImageIcon;

/**
 *
 * @author Marci
 */
public class GameOverPanel extends javax.swing.JPanel {

    Controller controller;
    private final Image wallpaperImg = new ImageIcon(this.getClass().getResource(Global.GAME_OVER_IMAGE)).getImage();
    private final ImageIcon buttonImage = new ImageIcon(this.getClass().getResource("/kepek/game_over_button.png"));
    private final ImageIcon buttonImageLight = new ImageIcon(this.getClass().getResource("/kepek/game_over_light_button.png"));
    private final ImageIcon buttonImageDark = new ImageIcon(this.getClass().getResource("/kepek/game_over_dark_button.png"));

    /**
     * Creates new form GameOverPanel
     */
    public GameOverPanel() {
        initComponents();
        setting();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int pointX = 0, pointY = 0,
                width = this.getWidth(),
                height = this.getHeight();
        g.drawImage(wallpaperImg, pointX, pointY, width, height, null);
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnNewGame = new javax.swing.JButton();
        btnBackToMenu = new javax.swing.JButton();
        btnExitGame = new javax.swing.JButton();
        lblPointString = new javax.swing.JLabel();
        lblPoint = new javax.swing.JLabel();
        lblTimeString = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();

        btnNewGame.setFont(new java.awt.Font("Eras Medium ITC", 1, 18)); // NOI18N
        btnNewGame.setForeground(new java.awt.Color(204, 204, 204));
        btnNewGame.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kepek/game_over_button.png"))); // NOI18N
        btnNewGame.setText("Új játék");
        btnNewGame.setBorderPainted(false);
        btnNewGame.setContentAreaFilled(false);
        btnNewGame.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNewGame.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnNewGameMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNewGameMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnNewGameMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnNewGameMouseReleased(evt);
            }
        });

        btnBackToMenu.setFont(new java.awt.Font("Eras Medium ITC", 1, 18)); // NOI18N
        btnBackToMenu.setForeground(new java.awt.Color(204, 204, 204));
        btnBackToMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kepek/game_over_button.png"))); // NOI18N
        btnBackToMenu.setText("Kilépés a menübe");
        btnBackToMenu.setBorderPainted(false);
        btnBackToMenu.setContentAreaFilled(false);
        btnBackToMenu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBackToMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBackToMenuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBackToMenuMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnBackToMenuMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnBackToMenuMouseReleased(evt);
            }
        });

        btnExitGame.setFont(new java.awt.Font("Eras Medium ITC", 1, 18)); // NOI18N
        btnExitGame.setForeground(new java.awt.Color(204, 204, 204));
        btnExitGame.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kepek/game_over_button.png"))); // NOI18N
        btnExitGame.setText("Kilépés a játékból");
        btnExitGame.setBorderPainted(false);
        btnExitGame.setContentAreaFilled(false);
        btnExitGame.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExitGame.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnExitGameMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnExitGameMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnExitGameMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnExitGameMouseReleased(evt);
            }
        });

        lblPointString.setFont(new java.awt.Font("Microsoft YaHei UI", 2, 36)); // NOI18N
        lblPointString.setForeground(new java.awt.Color(153, 153, 153));
        lblPointString.setText("Pontszám:");

        lblPoint.setFont(new java.awt.Font("Microsoft YaHei UI", 2, 36)); // NOI18N
        lblPoint.setForeground(new java.awt.Color(153, 153, 153));

        lblTimeString.setFont(new java.awt.Font("Microsoft YaHei UI", 2, 36)); // NOI18N
        lblTimeString.setForeground(new java.awt.Color(153, 153, 153));
        lblTimeString.setText("Idő:");

        lblTime.setFont(new java.awt.Font("Microsoft YaHei UI", 2, 36)); // NOI18N
        lblTime.setForeground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(359, 359, 359)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnExitGame, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBackToMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNewGame, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(lblPointString, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblPoint, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                .addComponent(lblTimeString, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTime, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPoint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPointString, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                    .addComponent(lblTimeString, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNewGame, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(btnBackToMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(btnExitGame, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(240, 240, 240))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewGameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNewGameMouseEntered
        btnNewGame.setIcon(buttonImageLight);
        controller.buttonEnteredEffect();
    }//GEN-LAST:event_btnNewGameMouseEntered

    private void btnNewGameMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNewGameMouseExited
        btnNewGame.setIcon(buttonImage);
    }//GEN-LAST:event_btnNewGameMouseExited

    private void btnNewGameMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNewGameMousePressed
        btnNewGame.setIcon(buttonImageDark);
        controller.buttonPressedEffect();
    }//GEN-LAST:event_btnNewGameMousePressed

    private void btnNewGameMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNewGameMouseReleased
        btnNewGame.setIcon(buttonImage);
        controller.restart();
    }//GEN-LAST:event_btnNewGameMouseReleased

    private void btnBackToMenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackToMenuMouseEntered
        btnBackToMenu.setIcon(buttonImageLight);
        controller.buttonEnteredEffect();
    }//GEN-LAST:event_btnBackToMenuMouseEntered

    private void btnBackToMenuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackToMenuMouseExited
        btnBackToMenu.setIcon(buttonImage);
    }//GEN-LAST:event_btnBackToMenuMouseExited

    private void btnBackToMenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackToMenuMousePressed
        btnBackToMenu.setIcon(buttonImageDark);
        controller.buttonPressedEffect();
    }//GEN-LAST:event_btnBackToMenuMousePressed

    private void btnBackToMenuMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackToMenuMouseReleased
        btnBackToMenu.setIcon(buttonImage);
        controller.exitGameFrame();
    }//GEN-LAST:event_btnBackToMenuMouseReleased

    private void btnExitGameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitGameMouseEntered
        btnExitGame.setIcon(buttonImageLight);
        controller.buttonEnteredEffect();
    }//GEN-LAST:event_btnExitGameMouseEntered

    private void btnExitGameMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitGameMouseExited
        btnExitGame.setIcon(buttonImage);
    }//GEN-LAST:event_btnExitGameMouseExited

    private void btnExitGameMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitGameMousePressed
        btnExitGame.setIcon(buttonImageDark);
        controller.buttonPressedEffect();
    }//GEN-LAST:event_btnExitGameMousePressed

    private void btnExitGameMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitGameMouseReleased
        btnExitGame.setIcon(buttonImage);
        controller.exitDialog();
    }//GEN-LAST:event_btnExitGameMouseReleased

    private void setting() {
        this.setVisible(false);

        Toolkit toolKit = Toolkit.getDefaultToolkit();
        Image cursorImage = new ImageIcon(this.getClass().getResource("/kepek/cursor_image_orange.png")).getImage();
        Point pont = new Point(0, 0);
        Cursor cursor = toolKit.createCustomCursor(cursorImage, pont, "Cursor");

        this.setCursor(cursor);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBackToMenu;
    private javax.swing.JButton btnExitGame;
    private javax.swing.JButton btnNewGame;
    private javax.swing.JLabel lblPoint;
    private javax.swing.JLabel lblPointString;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblTimeString;
    // End of variables declaration//GEN-END:variables

    public void pointWrite(int points) {
        lblPoint.setText(points + "");
    }

    public void timeWrite(long actTime) {
        lblTime.setText(actTime + "");
    }

    public void languageSetting(ResourceBundle bundle) {
        lblPointString.setText(bundle.getString("lblPoint.text"));
        lblTimeString.setText(bundle.getString("lblTime.text"));
        btnNewGame.setText(bundle.getString("btnNewGame.text"));
        btnBackToMenu.setText(bundle.getString("btnBackToMenu.text"));
        btnExitGame.setText(bundle.getString("btnExitGame.text"));
    }
}
