package com.ansdoship.UI.actor;

import com.ansdoship.MainGame;
import com.ansdoship.core.cache.MenuCache;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class Switch extends Button {

    private static final String TAG = MainGame.class.getSimpleName();
    private ButtonStyle check,notCheck;

    public Switch(ButtonStyle ncheck) {

        super(ncheck);

        check = new ButtonStyle();
        check.up = ncheck.up;
        check.down = ncheck.up;

        notCheck = new ButtonStyle();
        notCheck.up = ncheck.down;
        notCheck.down = ncheck.down;

        this.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                if(getStyle()==check||getStyle()==ncheck){
                    Switch.super.setStyle(notCheck);
                    Gdx.app.log(TAG,"1");
                    MenuCache.autoSaving = false;
                }else{
                    Switch.super.setStyle(check);
                    Gdx.app.log(TAG,"2");
                    MenuCache.autoSaving =true;
                }
            }
        });
    }

    public void setStatus(boolean boo){
        if(boo) this.setStyle(check);
        else this.setStyle(notCheck);
    }
}
