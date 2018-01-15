/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import baseclasses.Ball;
import baseclasses.BallImagePair;
import baseclasses.Paddle;
import baseclasses.PaddleImagePair;
import baseclasses.Player;
import frames.GameFrame;
import frames.InfoFrame;
import global.Global;
import java.awt.Graphics;
import java.awt.Image;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import panels.ConsolePanel;
import panels.GameOverPanel;
import panels.GamePanel;
import panels.InfoPanel;
import panels.MenuPanel;
import panels.ResultPanel;

/**
 *
 * @author Marci
 */
public class Controller implements Runnable {

    private final MenuPanel menuPanel;
    private GameFrame gameFrame;
    private ConsolePanel consolePanel;
    private GamePanel gamePanel;
    private GameOverPanel gameOverPanel;
    private ResultPanel resultPanel;
    private InfoFrame infoFrame;
    private InfoPanel infoPanel;

    private final List<Ball> ballList = new CopyOnWriteArrayList<>();

    private Player player;
    private Paddle paddle;

    private final long sec = Global.SEC;
    private final long speedingInterval = Global.SPEEDING_INTERVALL;
    private final int firstWave = Global.FIRST_WAVE;
    private final int secondWave = Global.SECOND_WAVE;
    private final int maxPlayerMixtaxes = Global.MAX_PLAYER_MISTAKES;
    private int playerMistakes = 0;
    private long actTime = 0;

    public Controller(MenuPanel menuPanel, ResultPanel resultPanel) {
        this.menuPanel = menuPanel;
        this.resultPanel = resultPanel;
    }

    public void start() {
        staticSetting();
    }

    private void staticSetting() {
        Ball.setWidth(Global.BALL_WIDTH);
        Ball.setHeight(Global.BALL_HEIGHT);
        Ball.setSpeedLimit(Global.BALL_SPEED_LIMIT);

        Paddle.setWidth(Global.PADDLE_WIDHT);
        Paddle.setHeight(Global.PADDLE_HEIGHT);
        Paddle.setY(Global.PADDLE_Y);
    }

    public void gameStart(String name) {
        gameFrame = new GameFrame(this);
        gamePanel.setController(this);
        consolePanel.setController(this);
        gameOverPanel.setController(this);
        Ball.setPanelWidth(gamePanel.getWidth());
        Ball.setPanelHeight(gamePanel.getHeight());
        player = new Player(name);
        SwingUtilities.getWindowAncestor(menuPanel).setVisible(false);

        threadStart();
    }

    public void threadStart() {
        Thread thread = new Thread(this);
        thread.start();
        createObjects();
        update();
    }

    private void createObjects() {
        Image paddleImageBlue = new ImageIcon(this.getClass().getResource(Global.PADDLE_IMAGE_BLUE)).getImage();
        Image paddleImageRed = new ImageIcon(this.getClass().getResource(Global.PADDLE_IMAGE_RED)).getImage();
        PaddleImagePair paddleImagePair = new PaddleImagePair(paddleImageBlue, paddleImageRed);
        int paddleX = gamePanel.getWidth() / 2;
        paddle = new Paddle(paddleImagePair, paddleX, this);

        Image ballImageBlue = new ImageIcon(this.getClass().getResource(Global.BALL_IMAGE_BLUE)).getImage();
        Image ballImageRed = new ImageIcon(this.getClass().getResource(Global.BALL_IMAGE_RED)).getImage();
        BallImagePair ballImagePair = new BallImagePair(ballImageBlue, ballImageRed);
        int x = (int) (Math.random() * gamePanel.getWidth());
        int y = Global.BALL_HEIGHT;
        int dx = Global.BALL_DX;
        int dy = Global.BALL_DY;
        long time = Global.BALL_TIME;
        Ball firstBall = new Ball(ballImagePair, x, y, dx, dy, time, this);
        ballList.add(firstBall);
        firstBall.start();
    }

    @Override
    public void run() {
        while (playerMistakes < maxPlayerMixtaxes) {
            try {
                consolePanel.timeWrite(actTime / 1000);
                Thread.sleep(sec);
                actTime += sec;

                if ((actTime / 1000) % speedingInterval == 0) {
                    gameSpeeding();
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        gameOver();
    }

    public void draw(Graphics g) {
        if (paddle != null) {
            paddle.draw(g);
        }
        for (Ball ball : ballList) {
            ball.draw(g);
        }
    }

    public void update() {
        gamePanel.repaint();
    }

    public void movePaddle(int x) {
        if (Paddle.getWidth() / 2 <= x && x <= gamePanel.getWidth() - Paddle.getWidth() / 2) {
            paddle.setX(x);
        }
    }

    public boolean collisionCheck(int x, int y) {
        int beginX = paddle.getX() - Global.PADDLE_WIDHT / 2;
        int endX = paddle.getX() + Global.PADDLE_WIDHT / 2;
        int paddleY = paddle.getY() - Global.PADDLE_HEIGHT / 2;
        if (beginX <= x && x <= endX && paddleY <= y + Global.BALL_HEIGHT / 2) {
            if (playerMistakes < maxPlayerMixtaxes) {
                player.earnPoint();
                consolePanel.pointWrite(player.getPoints());
            }
            return true;
        } else {
            return false;
        }
    }

    private void gameSpeeding() {
        for (Ball ball : ballList) {
            ball.speeding();
        }
        if (ballList.get(0).getTime() == firstWave) {
            ballList.get(0).imageChange();
            createBlackBall();
        }
        if (ballList.get(0).getTime() == secondWave) {
            createBlackBall();
        }
    }

    private void createBlackBall() {
        Image image = new ImageIcon(this.getClass().getResource(Global.BALL_IMAGE_BLACK)).getImage();
        int x = (int) (Math.random() * gamePanel.getWidth());
        int y = Global.BALL_HEIGHT;
        int dx = Global.BALL_DX;
        int dy = Global.BALL_DY;
        long time = Global.BALL_TIME;
        Ball blackBall = new Ball(image, x, y, dx, dy, time, this);
        ballList.add(blackBall);
        blackBall.start();
    }

    public boolean ballFell(int y) {
        if (paddle.getY() - Global.PADDLE_HEIGHT / 4 <= y + Global.BALL_HEIGHT / 2) {
            return true;
        } else {
            return false;
        }
    }

    public void mistakeOccurred() {
        playerMistakes++;
    }

    private void gameOver() {
        for (Ball ball : ballList) {
            ball.setAktiv(false);
        }
        ballList.clear();
        playerMistakes = 0;
        consolePanel.pointWrite(0);
        gameOverPanel.pointWrite(player.getPoints());
        gameOverPanel.timeWrite(actTime / 1000);
        actTime = 0;
        consolePanel.timeWrite(actTime);
        
        gamePanel.setVisible(false);
        gameOverPanel.setVisible(true);
        update();
    }

    public void exitGame() {
        int selectedOption = JOptionPane.showConfirmDialog(null, "Biztos ki akarsz lépni?", "Válassz", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (selectedOption == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    public void iconify() {
        ((JFrame) SwingUtilities.getWindowAncestor(menuPanel)).setState(JFrame.ICONIFIED);
    }

    public void resultShow() {
        menuPanel.setVisible(false);
        resultPanel.setVisible(true);
    }

    public void mainMenuShow() {
        resultPanel.setVisible(false);
        menuPanel.setVisible(true);

    }

    public void exitInfoFrame() {
        infoFrame.dispose();
    }

    public void exitGameFrame() {
        gameFrame.dispose();
        ((JFrame) SwingUtilities.getWindowAncestor(menuPanel)).setVisible(true);
    }

    public void restart() {
        gameOverPanel.setVisible(false);
        gamePanel.setVisible(true);

        threadStart();
    }

    public void infoStart() {
        infoFrame = new InfoFrame(this);
        infoPanel.setController(this);
    }

    public void setConsolePanel(ConsolePanel consolePanel) {
        this.consolePanel = consolePanel;
    }

    public void setGamePanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void setGameOverPanel(GameOverPanel gameOverPanel) {
        this.gameOverPanel = gameOverPanel;
    }

    public void setResultPanel(ResultPanel resultPanel) {
        this.resultPanel = resultPanel;
    }

    public void setInfoPanel(InfoPanel infoPanel) {
        this.infoPanel = infoPanel;
    }

}
