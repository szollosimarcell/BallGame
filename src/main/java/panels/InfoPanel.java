/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panels;

import control.Controller;
import global.Global;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Marci
 */
public class InfoPanel extends javax.swing.JPanel {

    private BufferedImage wallpaperImg;
    private Controller controller;

    ImageIcon menuButtonImage = new ImageIcon(this.getClass().getResource("/kepek/menu_button.png"));
    ImageIcon menuButtonLightImage = new ImageIcon(this.getClass().getResource("/kepek/menu_button_light.png"));
    ImageIcon menuButtonDarkImage = new ImageIcon(this.getClass().getResource("/kepek/menu_button_dark.png"));

    /**
     * Creates new form InfoPanel
     */
    public InfoPanel() {
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

        btnOk = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setForeground(new java.awt.Color(204, 204, 204));

        btnOk.setFont(new java.awt.Font("Eras Medium ITC", 1, 18)); // NOI18N
        btnOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kepek/menu_button.png"))); // NOI18N
        btnOk.setText("Rendben");
        btnOk.setBorderPainted(false);
        btnOk.setContentAreaFilled(false);
        btnOk.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnOkMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnOkMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnOkMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnOkMouseReleased(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Eras Medium ITC", 0, 18)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(204, 204, 204));
        jTextArea1.setRows(5);
        jTextArea1.setText("A játék célja, hogy minél tovább bírd, és minél\ntöbb pontot szerezz. A feladat, hogy visszaüsd\n a labdát. Minden labdaütésért egy pont jár.\nHa háromszor leesik, a játéknak vége.");
        jTextArea1.setBorder(null);
        jTextArea1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTextArea1.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        jTextArea1.setEnabled(false);
        jTextArea1.setOpaque(false);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kepek/ball_blue.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Eras Medium ITC", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("A labda, amit vissza kell ütni.");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kepek/blue_paddle_image.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Eras Medium ITC", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("A tálca, amivel ütsz.");

        jLabel5.setFont(new java.awt.Font("Eras Medium ITC", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("Jó szórakozást!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                        .addGap(10, 10, 10))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnOkMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOkMouseEntered
        btnOk.setIcon(menuButtonLightImage);
    }//GEN-LAST:event_btnOkMouseEntered

    private void btnOkMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOkMouseExited
        btnOk.setIcon(menuButtonImage);
    }//GEN-LAST:event_btnOkMouseExited

    private void btnOkMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOkMousePressed
        btnOk.setIcon(menuButtonDarkImage);
    }//GEN-LAST:event_btnOkMousePressed

    private void btnOkMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOkMouseReleased
        btnOk.setIcon(menuButtonImage);
        controller.exitInfoFrame();
    }//GEN-LAST:event_btnOkMouseReleased

    private void setting() {
        try {
            wallpaperImg = ImageIO.read(this.getClass().getResourceAsStream(Global.INFO_PANEL_IMAGE));
        } catch (IOException ex) {
            Logger.getLogger(MenuPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

        jScrollPane1.setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);
        jScrollPane1.setBorder(null);
        jScrollPane1.setViewportBorder(null);

        jTextArea1.setBorder(null);
        jTextArea1.setBackground(new Color(0, 0, 0, 0));

        Toolkit toolKit = Toolkit.getDefaultToolkit();
        Image cursorImage = new ImageIcon(this.getClass().getResource("/kepek/cursor_image_blue.png")).getImage();
        Point pont = new Point(0, 0);
        Cursor cursor = toolKit.createCustomCursor(cursorImage, pont, "Cursor");

        this.setCursor(cursor);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
