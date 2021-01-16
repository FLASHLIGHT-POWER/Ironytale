package com.ansdoship.UI.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class FontActor extends Actor {

    public static BitmapFont bitmapFont = new BitmapFont(Gdx.files.internal("fonts/unifont.fnt"));
    private String text;
    private float x,y;

    public FontActor(String str,float x,float y,float scale) {
        super();
        this.text = str;
        this.x = x;
        this.y = y;
        bitmapFont.getData().setScale(scale);
    }

    @Override
    public void draw(Batch batch,float parentAlpha){
        SpriteBatch spriteBatch = new SpriteBatch();
        spriteBatch.begin();
        bitmapFont.draw(spriteBatch,text,x,y);
        spriteBatch.end();
    }

    public void setColor(float f1,float f2,float f3,float f4){
        bitmapFont.setColor(f1, f2, f3, f4);
    }

    public void setText(String str){
        text = str;
    }
}
