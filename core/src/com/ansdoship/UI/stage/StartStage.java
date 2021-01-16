package com.ansdoship.UI.stage;

import com.ansdoship.MainGame;
import com.ansdoship.UI.group.StartButtonGroup;
import com.ansdoship.UI.actor.BaseActor;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.viewport.Viewport;

public class StartStage extends BaseStage{

    int deltaSum;

    public StartStage(MainGame mainGame, Viewport viewport){
        super(mainGame, viewport);
        init();
    }

    public void init(){
        Texture logoTexture = new Texture(Gdx.files.internal("logo.png"));
        BaseActor logo = new BaseActor(new TextureRegion(logoTexture));
        logo.setPosition(
                getWidth() / 2 - logo.getWidth() / 2,
                getHeight() - logo.getHeight());

        StartButtonGroup startButtonGroup = new StartButtonGroup(getMainGame());
        startButtonGroup.setX(300);
        addActor(logo);
        addActor(startButtonGroup);

        deltaSum = 0;
    }
}
