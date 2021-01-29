package com.ansdoship.UI.stage;

import com.ansdoship.UI.actor.BaseActor;
import com.ansdoship.UI.actor.FontActor;
import com.ansdoship.core.world.model.friend.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;

public class FightStage extends Stage {

    private BitmapFont bitmapFont;
    private Player player;
    private FontActor health;
    private SpriteBatch batch;

    public FightStage(Player player,Viewport viewport){
        super(viewport);
        this.player = player;
        init();
    }



    public void init(){

        batch = new SpriteBatch();
        bitmapFont = new BitmapFont(Gdx.files.internal("fonts/unifont.fnt"));

        Texture playerTexture = new Texture("sprites/player.png");
        BaseActor playerTex = new BaseActor(new TextureRegion(playerTexture));

        //两个BaseActor中不知道为什么只能渲染前面声明的那个，所以我只能把图片合并了

        playerTex.setPosition(0,getHeight()-playerTex.getHeight());

        health = new FontActor("生命值:"+player.getHealth(),playerTex.getX()+80, playerTex.getHeight(), 0.7f);

        batch.begin();
        batch.draw(playerTexture,10,10);
        batch.end();

        addActor(playerTex);
        addActor(health);
    }

    @Override
    public void act(){
        super.act();
        health.setText("生命值:"+player.getHealth());
    }

}
