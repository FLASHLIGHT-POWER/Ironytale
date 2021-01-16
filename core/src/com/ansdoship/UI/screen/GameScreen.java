package com.ansdoship.UI.screen;

import com.ansdoship.MainGame;
import com.ansdoship.UI.stage.StartStage;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.utils.viewport.StretchViewport;

public class GameScreen implements Screen {

    private StartStage startStage;
    private final MainGame mainGame;
    public GameScreen(MainGame mainGame) {
        this.mainGame = mainGame;
        init();
    }

    @Override
    public void show() {

    }

    public void init(){

    }

    @Override
    public void render(float delta) {


    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

}