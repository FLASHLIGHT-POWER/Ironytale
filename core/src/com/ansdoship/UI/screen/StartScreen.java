package com.ansdoship.UI.screen;

import com.ansdoship.MainGame;
import com.ansdoship.UI.stage.SettingStage;
import com.ansdoship.UI.stage.StartStage;
import com.ansdoship.UI.actor.BaseActor;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;

public class StartScreen extends ScreenAdapter {

    // 为了方便与 MainGame 进行交互, 创建 Screen 时将 MainGame 作为参数传进来
    private final MainGame mainGame;

    private final Texture logoTexture;

    private final Stage stage;
    private SettingStage settingStage;
    private final StartStage startStage;
    private float deltaSum;

    public StartScreen(MainGame mainGame) {
        this.mainGame = mainGame;

        logoTexture = new Texture(Gdx.files.internal("libgdx_logo.png"));

        stage = new Stage(new StretchViewport(MainGame.WORLD_WIDTH, MainGame.WORLD_HEIGHT));

        BaseActor logoActor = new BaseActor(new TextureRegion(logoTexture));

        logoActor.setPosition(
                stage.getWidth() / 2 - logoActor.getWidth() / 2,
                stage.getHeight() / 2 - logoActor.getHeight() / 2
        );

        stage.addActor(logoActor);

        settingStage = new SettingStage(mainGame,new ScreenViewport());
        settingStage.setVisible(false);

        startStage = new StartStage(mainGame,new StretchViewport(MainGame.WORLD_WIDTH,MainGame.WORLD_HEIGHT));
        Gdx.input.setInputProcessor(startStage);
    }

    @Override
    public void show(){
        deltaSum = 0;
    }

    @Override
    public void render(float delta) {

        if (deltaSum >= 3f) {
            if (mainGame != null) {
                Gdx.gl.glClearColor(0.75F, 1, 0.98F, 1);
                Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

                startStage.act();
                startStage.draw();

                if(settingStage.isVisible()){
                    settingStage.act();
                    settingStage.draw();
                }
                return;
            }
        }

        deltaSum+=delta;

        Gdx.gl.glClearColor(0.75F, 1, 0.98F, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act();

        stage.draw();
    }

    @Override
    public void dispose() {
            stage.dispose();
            logoTexture.dispose();
    }

    public SettingStage getSettingStage(){
        return settingStage;
    }

    public void setSettingStage(Boolean showSettingStage){
        settingStage.setVisible(showSettingStage);
        if(showSettingStage)
            Gdx.input.setInputProcessor(settingStage);
        else
            Gdx.input.setInputProcessor(startStage);
    }
}