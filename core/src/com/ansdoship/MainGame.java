package com.ansdoship;

import com.ansdoship.UI.screen.GameScreen;
import com.ansdoship.UI.screen.StartScreen;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class MainGame extends Game {

    public static final float WORLD_WIDTH = 720;
    public static final float WORLD_HEIGHT = 480;

    private StartScreen startScreen;
    private GameScreen gameScreen;
    public MainGame() {
    }

    @Override
    public void create() {

        Gdx.app.setLogLevel(Application.LOG_DEBUG);

        startScreen = new StartScreen(this);
        gameScreen = new GameScreen(this);
        setScreen(startScreen);
    }

    public void showGameScreen() {
        // 设置当前场景为主游戏场景
        setScreen(gameScreen);
        if(startScreen!=null){
            startScreen.dispose();
            startScreen=null;
        }
    }

    public StartScreen getStartScreen(){
        return startScreen;
    }

    @Override
    public void dispose() {
        super.dispose();

        if (startScreen != null) {
            startScreen.dispose();
            startScreen = null;
        }
        if (gameScreen != null) {
            gameScreen.dispose();
            gameScreen = null;
        }
    }
}
