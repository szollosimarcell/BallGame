/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import baseclasses.Ball;
import baseclasses.BallImagePair;
import baseclasses.Music;
import baseclasses.Paddle;
import baseclasses.PaddleImagePair;
import baseclasses.Player;
import frames.GameFrame;
import frames.InfoFrame;
import global.Global;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
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

    private final List<Ball> ballList = new CopyOnWriteArrayList<>();

    private final MainFrame mainFrame;
    private final MenuPanel menuPanel;
    private final ResultPanel resultPanel;

    private GameFrame gameFrame;
    private GamePanel gamePanel;
    private ConsolePanel consolePanel;
    private GameOverPanel gameOverPanel;

    private InfoFrame infoFrame;
    private InfoPanel infoPanel;

    private Player player;
    private Paddle paddle;
    private Music mainMusic;
    private Music guiEffect;
    private ResourceBundle bundle;

    private long sec;
    private long speedingInterval;
    private int firstWave;
    private int secondWave;
    private int maxPlayerMixtaxes;
    private String musicPath;
    private String bundleEleresHU;
    private String bundleEleresEN;
    private int playerMistakes = 0;
    private long actTime = 0;

    public Controller(MenuPanel menuPanel, ResultPanel resultPanel, MainFrame mainFrame) {
        this.menuPanel = menuPanel;
        this.resultPanel = resultPanel;
        this.mainFrame = mainFrame;
    }

    public void start() {
        staticSetting();
        mainMusicStart();
    }

    /**
     * This method inicializes the staring variables and the static variables
     * with the static variables given in the Global package and sets the
     * bundle.
     */
    public void staticSetting() {
        Ball.setWidth(Global.BALL_WIDTH);
        Ball.setHeight(Global.BALL_HEIGHT);
        Ball.setFieldSideX(Global.FIELD_SIDE_STRIPE_X);
        Ball.setFieldUpperY(Global.FIELD_UPPER_STRIPE_Y);
        Ball.setSpeedLimit(Global.BALL_SPEED_LIMIT);

        Paddle.setWidth(Global.PADDLE_WIDHT);
        Paddle.setHeight(Global.PADDLE_HEIGHT);
        Paddle.setY(Global.PADDLE_Y);

        sec = Global.SEC;
        speedingInterval = Global.SPEEDING_INTERVALL;
        firstWave = Global.FIRST_WAVE;
        secondWave = Global.SECOND_WAVE;
        maxPlayerMixtaxes = Global.MAX_PLAYER_MISTAKES;
        musicPath = Global.MAIN_MUSIC_PATH;
        bundleEleresHU = Global.BUNDLE_PATH_HU;
        bundleEleresEN = Global.BUNDLE_PATH_EN;

        bundleSetting("hu");
    }

    /**
     * This method starts the main music of the game.
     */
    public void mainMusicStart() {
        mainMusic = new Music();
        mainMusic.setPath(musicPath);
        mainMusic.start();
    }

    /**
     * This method is the starting point of the game. It creates the game frame
     * and its panels, sets static variables of the Ball class, creates a new
     * player, hides the main frame and start the Thread created from the
     * controller, which implemented the Runnable interface.
     *
     * @param name the name of the player
     */
    public void gameStart(String name) {
        gameFrame = new GameFrame(this);
        gamePanel.setController(this);
        consolePanel.setController(this);
        gameOverPanel.setController(this);
        consolePanel.languageSetting(bundle);
        gameOverPanel.languageSetting(bundle);
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

    /**
     * This method creates the two important objects for starting the program.
     */
    private void createObjects() {
        Image paddleImageBlue = new ImageIcon(this.getClass().getResource(Global.PADDLE_IMAGE_BLUE)).getImage();
        Image paddleImageRed = new ImageIcon(this.getClass().getResource(Global.PADDLE_IMAGE_RED)).getImage();
        PaddleImagePair paddleImagePair = new PaddleImagePair(paddleImageBlue, paddleImageRed);
        int paddleX = gamePanel.getWidth() / 2;
        paddle = new Paddle(paddleImagePair, paddleX, this);

        Image ballImageBlue = new ImageIcon(this.getClass().getResource(Global.BALL_IMAGE_BLUE)).getImage();
        Image ballImageRed = new ImageIcon(this.getClass().getResource(Global.BALL_IMAGE_RED)).getImage();
        BallImagePair ballImagePair = new BallImagePair(ballImageBlue, ballImageRed);
        int maxX = Global.GAME_FRAME_WIDTH - Global.FIELD_SIDE_STRIPE_X;
        int minX = Global.FIELD_SIDE_STRIPE_X;
        int x = (int) (Math.random() * (maxX - minX) + minX);
        int y = Global.BALL_HEIGHT / 2 + Global.FIELD_UPPER_STRIPE_Y;
        int dx = Global.BALL_DX;
        int dy = Global.BALL_DY;
        long time = Global.BALL_TIME;
        Ball firstBall = new Ball(ballImagePair, x, y, dx, dy, time, this);
        ballList.add(firstBall);
        firstBall.start();
    }

    /**
     * This method is the run method of the thread. It is running until the
     * player's mistakes are less then the maximum mistakes allowed.
     */
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

    /**
     * Ask the objects to draw themselfs.
     *
     * @param g
     */
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

    /**
     * This method moves the paddle with the x coordinate of the mouse.
     *
     * @param x the x coordinate of the mouse
     */
    public void movePaddleMouse(int x) {
        if (Paddle.getWidth() / 2 <= x && x <= gamePanel.getWidth() - Paddle.getWidth() / 2) {
            paddle.setX(x);
        }
    }

    /**
     * This method tells the ball whether it collided with the paddle or not.
     *
     * @param x the x coordinate of the ball.
     * @param y the y coordinate of the ball.
     * @return true - collided / false - not collided
     */
    public boolean collisionCheck(int x, int y) {
        int beginX = paddle.getX() - Global.PADDLE_WIDHT / 2;
        int endX = paddle.getX() + Global.PADDLE_WIDHT / 2;
        int paddleUpperY = paddle.getY() - Global.PADDLE_HEIGHT / 2;
        int ballLowerY = y + Global.BALL_HEIGHT / 2;
        if (beginX <= x && x <= endX && paddleUpperY <= ballLowerY && ballLowerY <= paddleUpperY + Global.BALL_SPEED_LIMIT) {
            if (playerMistakes < maxPlayerMixtaxes) {
                ballCollisionEffect();
                player.earnPoint();
                consolePanel.pointWrite(player.getPoints());
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method speeds the game.
     */
    private void gameSpeeding() {
        for (Ball ball : ballList) {
            ball.speeding();
        }
        if (ballList.get(0).getTime() == firstWave) {
            ballList.get(0).imageChange();
            createBlackBall();
            paddle.imageChange();
        }
        if (ballList.get(0).getTime() == secondWave) {
            createBlackBall();
            gamePanel.imageChange();
        }
    }

    /**
     * This method created the further balls. These balls are black.
     */
    private void createBlackBall() {
        Image image = new ImageIcon(this.getClass().getResource(Global.BALL_IMAGE_BLACK)).getImage();
        int maxX = Global.GAME_FRAME_WIDTH - Global.FIELD_SIDE_STRIPE_X;
        int minX = Global.FIELD_SIDE_STRIPE_X;
        int x = (int) (Math.random() * (maxX - minX) + minX);
        int y = Global.BALL_HEIGHT / 2 + Global.FIELD_UPPER_STRIPE_Y;
        int dx = Global.BALL_DX;
        int dy = Global.BALL_DY;
        long time = Global.BALL_TIME;
        Ball blackBall = new Ball(image, x, y, dx, dy, time, this);
        ballList.add(blackBall);
        blackBall.start();
    }

    /**
     * This method tells the ball wether it is falling or not
     *
     * @param y the y coordinate of the ball.
     * @return true - falling / false - not falling
     */
    public boolean ballFell(int y) {
        int paddleUpperY = paddle.getY() - Global.PADDLE_HEIGHT / 2;
        int ballLowerY = y + Global.BALL_HEIGHT / 2;
        if (paddleUpperY + Global.BALL_DY < ballLowerY) {
            return true;
        } else {
            return false;
        }
    }

    public void mistakeOccurred() {
        playerMistakes++;
    }

    /**
     * This method is the last poin of the game. It happens when the player
     * loses. It playes the game over sound effect, deletes the objects, sets
     * the important variables to default and changes the panel to the game over
     * panel.
     */
    private void gameOver() {
        gameOverEffect();
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

    /**
     * Iconify the main frame.
     */
    public void iconify() {
        mainFrame.setState(Frame.ICONIFIED);
    }

    /**
     * Changes to the result panel.
     */
    public void showResult() {
        menuPanel.setVisible(false);
        resultPanel.setVisible(true);
    }

    /**
     * Goes back to the main panel from the result panel.
     */
    public void showMainMenu() {
        resultPanel.setVisible(false);
        menuPanel.setVisible(true);
    }

    /**
     * Closes the info frame.
     */
    public void exitInfoFrame() {
        infoFrame.dispose();
        menuPanel.infoButtonEnable();
    }

    /**
     * Closes the game frame and goes back to the main frame.
     */
    public void exitGameFrame() {
        gameFrame.dispose();
        ((JFrame) SwingUtilities.getWindowAncestor(menuPanel)).setVisible(true);
    }

    /**
     * This method restarts the game without going back to the main frame and
     * creating a new game frame.
     */
    public void restart() {
        gameOverPanel.setVisible(false);
        gamePanel.setVisible(true);
        player.cleanPoint();

        threadStart();
    }

    /**
     * Creates the info frame.
     */
    public void infoStart() {
        infoFrame = new InfoFrame(this);
        infoPanel.setController(this);
        infoPanel.languageSetting(bundle);
        menuPanel.infoButtonDisable();
    }

    /**
     * This method is called when a button is pressed to play its sound effect.
     */
    public void buttonPressedEffect() {
        playGuiEffect(Global.BUTTON_PRESSED_EFFECT);
    }

    /**
     * This method is called when a button is entered to play its sound effect.
     */
    public void buttonEnteredEffect() {
        playGuiEffect(Global.BUTTON_ENTERED_EFFECT);
    }

    /**
     * This method is called when the game is over to play its sound effect.
     */
    public void gameOverEffect() {
        playGuiEffect(Global.GAME_OVER_EFFECT);
    }

    /**
     * This method is called when a ball has collided with the paddle to play
     * its sound effect.
     */
    public void ballCollisionEffect() {
        playGuiEffect(Global.BALL_COLLISION_EFFECT);
    }

    /**
     * This method is called by all of the gui effect methods. This playes the
     * sound effect demending on the path given as a parameter from the gui
     * effect methods.
     *
     * @param path
     */
    public void playGuiEffect(String path) {
        if (guiEffect != null) {
            guiEffect = null;
        }
        guiEffect = new Music();
        guiEffect.setPath(path);
        guiEffect.start();
    }

    public void musicOff() {
        mainMusic.leall();
    }

    /**
     * This method inicializes the current language bundle
     *
     * @param language
     */
    public void bundleSetting(String language) {
        if (language == "hu") {
            bundle = ResourceBundle.getBundle(bundleEleresHU);
        }
        if (language == "en") {
            bundle = ResourceBundle.getBundle(bundleEleresEN);
        }
        menuPanel.languageSetting(bundle);
    }

    /**
     * This methot exits the game in the proper bundle.
     */
    public void exitDialog() {
        UIManager.put("OptionPane.yesButtonText", bundle.getString("exitDialogYes"));
        UIManager.put("OptionPane.noButtonText", bundle.getString("exitDialogNo"));
        int valasz = JOptionPane.showConfirmDialog(null, bundle.getString("exitDialogString"), bundle.getString("exitDialogTitle"), 0);
        if (valasz == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    /**
     * This method informs the user in the proper bundle for not giving a name
     * at the starting of the game.
     */
    public void blankNameDialog() {
        JOptionPane.showMessageDialog(null, bundle.getString("blankNameDialogString"), bundle.getString("blankNameDialogTitle"), 0);
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

    public void setInfoPanel(InfoPanel infoPanel) {
        this.infoPanel = infoPanel;
    }
}
