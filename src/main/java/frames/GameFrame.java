/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import control.Controller;
import global.Global;
import panels.ConsolePanel;
import panels.GameOverPanel;
import panels.GamePanel;

/**
 *
 * @author Marci
 */
public class GameFrame extends javax.swing.JFrame {

    private final int width = Global.GAME_FRAME_WIDTH;
    private final int height = Global.GAME_FRAME_HEIGHT;
    private final String title = Global.GAME_FRAME_TITLE;
    Controller controller;

    /**
     * Creates new form GameFrame
     *
     * @param controller
     */
    public GameFrame(Controller controller) {
        initComponents();
        setting(controller);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        consolePanel1 = new panels.ConsolePanel();
        gamePanel1 = new panels.GamePanel();
        gameOverPanel1 = new panels.GameOverPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().add(consolePanel1, java.awt.BorderLayout.PAGE_END);

        javax.swing.GroupLayout gamePanel1Layout = new javax.swing.GroupLayout(gamePanel1);
        gamePanel1.setLayout(gamePanel1Layout);
        gamePanel1Layout.setHorizontalGroup(
            gamePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        gamePanel1Layout.setVerticalGroup(
            gamePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 750, Short.MAX_VALUE)
        );

        getContentPane().add(gamePanel1, java.awt.BorderLayout.CENTER);
        getContentPane().add(gameOverPanel1, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private panels.ConsolePanel consolePanel1;
    private panels.GameOverPanel gameOverPanel1;
    private panels.GamePanel gamePanel1;
    // End of variables declaration//GEN-END:variables

    private void setting(Controller controller) {
        this.setSize(width, height);
        this.setTitle(title);
        this.setLocationRelativeTo(this);

        gameOverPanel1.setVisible(false);

        this.setVisible(true);
        this.controller = controller;
        controller.setGamePanel(gamePanel1);
        controller.setConsolePanel(consolePanel1);
        controller.setGameOverPanel(gameOverPanel1);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getTitle() {
        return title;
    }

    public Controller getController() {
        return controller;
    }

    public ConsolePanel getConsolePanel1() {
        return consolePanel1;
    }

    public GameOverPanel getGameOverPanel1() {
        return gameOverPanel1;
    }

    public GamePanel getGamePanel1() {
        return gamePanel1;
    }
}
