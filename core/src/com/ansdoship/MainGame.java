package com.ansdoship;

import com.ansdoship.UI.screen.GameScreen;
import com.ansdoship.UI.screen.StartScreen;

import com.ansdoship.UI.screen.ThankingScreen;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

public class MainGame extends Game {

    public static final float WORLD_WIDTH = 720;
    public static final float WORLD_HEIGHT = 480;

    private StartScreen startScreen;
    private GameScreen gameScreen;
    private ThankingScreen thankingScreen;
    public MainGame() {
    }

    @Override
    public void create() {

        Gdx.app.setLogLevel(Application.LOG_DEBUG);

        startScreen = new StartScreen(this);
        gameScreen = new GameScreen(this);
        thankingScreen = new ThankingScreen(this);
        setScreen(startScreen);
    }

    public void showStartScreen() {
        // 设置当前场景为主游戏场景
        setScreen(startScreen);
        if(thankingScreen!=null){
            thankingScreen.dispose();
            thankingScreen=null;
        }
        startScreen.setStartStage(true);
    }

    public void showThankingScreen() {
        setScreen(thankingScreen);
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
        if(thankingScreen!=null){
            thankingScreen.dispose();
            thankingScreen =null;
        }
    }
}
