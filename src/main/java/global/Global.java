/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package global;

/**
 *
 * @author Marci
 */
public class Global {

    //MainFrame properties
    public static int MAIN_FRAME_WIDTH = 700;
    public static int MAIN_FRAME_HEIGHT = 500;
    public static String MAIN_FRAME_TITLE = "Main menu";
    public static String MENU_IMAGE = "/kepek/menu_background.png";

    //GameFrame properties
    public static int GAME_FRAME_WIDTH = 1000;
    public static int GAME_FRAME_HEIGHT = 800;
    public static int FIELD_SIDE_STRIPE_X = 5;
    public static int FIELD_UPPER_STRIPE_Y = 20;
    public static String GAME_FRAME_TITLE = "Game";
    public static String GAME_IMAGE_BLUE = "/kepek/game_background_blue.png";
    public static String GAME_IMAGE_RED = "/kepek/game_background_red.png";
    public static String CONSOLE_PANEL_IMAGE = "/kepek/console_panel_image.png";
    public static String GAME_OVER_IMAGE = "/kepek/game_over_image.png";

    //ResultFrame properties
    public static int RESULT_FRAME_WIDTH = 600;
    public static int RESULT_FRAME_HEIGHT = 800;
    public static String RESULT_FRAME_TITLE = "Results";
    public static String RESULT_IMAGE = "/kepek/result_background.jpg";

    //InfoFrame properties
    public static int INFO_FRAME_WIDTH = 400;
    public static int INFO_FRAME_HEIGHT = 300;
    public static String INFO_FRAME_TITLE = "GameInfo";
    public static String INFO_PANEL_IMAGE = "/kepek/info_panel.png";

    //ControlPanel properties
    public static long SEC = 1000;
    public static long SPEEDING_INTERVALL = 5;
    public static int FIRST_WAVE = 7;
    public static int SECOND_WAVE = 5;

    //Ball properties
    public static int BALL_WIDTH = 30;
    public static int BALL_HEIGHT = 30;
    public static int BALL_TIME = 10;
    public static int BALL_DX = 2;
    public static int BALL_DY = 3;
    public static int BALL_SPEED_LIMIT = 5;
    public static int MAX_PLAYER_MISTAKES = 6;
    public static String BALL_IMAGE_BLUE = "/kepek/ball_blue.png";
    public static String BALL_IMAGE_RED = "/kepek/ball_red.png";
    public static String BALL_IMAGE_BLACK = "/kepek/ball_black.png";

    //Paddle properties
    public static int PADDLE_WIDHT = 150;
    public static int PADDLE_HEIGHT = 20;
    public static int PADDLE_Y = 700;
    public static String PADDLE_IMAGE_BLUE = "/kepek/blue_paddle.gif";
    public static String PADDLE_IMAGE_RED = "/kepek/red_paddle.gif";

    //Media properties
    public static String MAIN_MUSIC_PATH = "/music/mainMusic.mp3";
    public static String GAME_OVER_EFFECT = "/music/gameOver.mp3";
    public static String BUTTON_PRESSED_EFFECT = "/music/buttonPressed.mp3";
    public static String BUTTON_ENTERED_EFFECT = "/music/buttonEntered.mp3";
    public static String BALL_COLLISION_EFFECT = "/music/ballCollision.mp3";
    
   //Bundle properties
    public static String BUNDLE_PATH_HU = "locality/Bundle_hu_HU";
    public static String BUNDLE_PATH_EN = "locality/Bundle_en_GB";
}
