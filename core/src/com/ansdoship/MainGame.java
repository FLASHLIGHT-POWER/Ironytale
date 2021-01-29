package com.ansdoship;

import com.ansdoship.UI.screen.FightScreen;
import com.ansdoship.UI.screen.GameScreen;
import com.ansdoship.UI.screen.StartScreen;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
public class MainGame extends Game {

    public static final float WORLD_WIDTH = 720;
    public static final float WORLD_HEIGHT = 480;

    private StartScreen startScreen;
    private GameScreen gameScreen;
    private FightScreen fightScreen;

    private static final String TAG = MainGame.class.getSimpleName();
    public MainGame() {
    }

    @Override
    public void create() {

        Gdx.app.setLogLevel(Application.LOG_DEBUG);

        startScreen = new StartScreen(this);
        gameScreen = new GameScreen(this);
        fightScreen = new FightScreen(this);
        setScreen(startScreen);

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

    public void showGameScreen() {
        setScreen(gameScreen);
    }

    public void showFightScreen(boolean bool) {
        if(bool)setScreen(fightScreen);
        else setScreen(gameScreen);
    }

    public GameScreen getGameScreen() {
        return gameScreen;
    }

    public StartScreen getStartScreen(){
        return startScreen;
    }

}
