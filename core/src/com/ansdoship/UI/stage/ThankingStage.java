package com.ansdoship.UI.stage;

import com.ansdoship.MainGame;
import com.ansdoship.UI.actor.BaseActor;
import com.ansdoship.UI.group.ThankingFontGroup;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.viewport.Viewport;

public class ThankingStage extends BaseStage{

    private float deltaSum;

    public ThankingStage(MainGame mainGame, Viewport viewport) {
        super(mainGame, viewport);
        init();
        deltaSum = 0;
    }

    public void init(){

        BaseActor back = new BaseActor(new TextureRegion(new Texture("sprites/backgroundBlack.png")));

        ThankingFontGroup thankingFontGroup = new ThankingFontGroup(getMainGame());
        addActor(back);
        addActor(thankingFontGroup);
    }

    @Override
    public void draw(){
        super.draw();
        deltaSum+=1f;
    }

    @Override
    public void act(){
        super.act();
        if(deltaSum>=600){
            deltaSum=0;
            getMainGame().getStartScreen().setThankingStage(false);
        }
    }
}
