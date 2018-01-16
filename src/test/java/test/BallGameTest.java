/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import baseclasses.Music;
import baseclasses.Player;
import control.Controller;
import control.MainFrame;
import frames.InfoFrame;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import panels.MenuPanel;
import panels.ResultPanel;

/**
 *
 * @author Marci
 */
public class BallGameTest {

    private final String MUSIC_PATH = "/music/mainMusic.mp3";
    private final String PLAYER_NAME = "Marci";

    private Controller controller;
    private MainFrame mainFrame;
    private MenuPanel menuPanel;
    private ResultPanel resultPanel;
    private InfoFrame infoFrame;
    private Music music;
    private Player player;

    public BallGameTest() {
    }

    @Before
    public void setUp() {
        mainFrame = new MainFrame();
        menuPanel = mainFrame.getMenuPanel1();
        resultPanel = mainFrame.getResultPanel1();
        controller = new Controller(menuPanel, resultPanel, mainFrame);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void musicTest() {
        music = new Music();
        music.setPath(MUSIC_PATH);
        assertFalse(music.isAlive());
        music.start();
        assertTrue(music.isAlive());
    }
    
    @Test
    public void infoTest() {
        infoFrame = new InfoFrame(controller);
        controller.setInfoPanel(infoFrame.getInfoPanel1());
        assertTrue(infoFrame.isVisible());
    }
    
    @Test
    public void panelChangeTest() {
        controller.showResult();
        assertFalse(menuPanel.isVisible());
        assertTrue(resultPanel.isVisible());
        controller.showMainMenu();
        assertFalse(resultPanel.isVisible());
        assertTrue(menuPanel.isVisible());
    }
    
    @Test
    public void playerTest() {
        player = new Player(PLAYER_NAME);
        assertTrue(player != null);
        player.earnPoint();
        assertTrue(player.getPoints() == 1);
        player.cleanPoint();
        assertTrue(player.getPoints() == 0);
    }
}
