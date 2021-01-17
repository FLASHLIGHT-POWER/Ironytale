package com.ansdoship.UI.group;

import com.ansdoship.MainGame;
import com.ansdoship.UI.actor.FontActor;
import com.ansdoship.UI.actor.Switch;
import com.ansdoship.UI.stage.SettingStage;
import com.ansdoship.core.cache.MenuCache;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class SettingButtonGroup extends BaseGroup{

    public static Preferences setting;

    public SettingButtonGroup(MainGame mainGame){
        super(mainGame);
        init();
    }
    public void init(){
        Texture sure = new Texture(Gdx.files.internal("button/sure.png"));
        Texture sure2 = new Texture(Gdx.files.internal("button/sure2.png"));
        Texture not = new Texture(Gdx.files.internal("button/not.png"));
        Texture not2 = new Texture(Gdx.files.internal("button/not2.png"));
        Texture check = new Texture(Gdx.files.internal("button/autoSave_check.png"));
        Texture notCheck = new Texture(Gdx.files.internal("button/autoSave_notCheck.png"));

        Button.ButtonStyle sureStyle =  new Button.ButtonStyle();
        sureStyle.up = new TextureRegionDrawable(new TextureRegion(sure));
        sureStyle.down = new TextureRegionDrawable(new TextureRegion(sure2));

        Button.ButtonStyle notStyle = new Button.ButtonStyle();
        notStyle.up = new TextureRegionDrawable(new TextureRegion(not));
        notStyle.down = new TextureRegionDrawable(new TextureRegion(not2));

        Button.ButtonStyle switchStyle = new Button.ButtonStyle();
        switchStyle.up =new TextureRegionDrawable(new TextureRegion(check));
        switchStyle.down = new TextureRegionDrawable(new TextureRegion(notCheck));

        Button sureButton = new Button(sureStyle);
        sureButton.setX(sureButton.getWidth());
        sureButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                getMainGame().getStartScreen().setSettingStage(false);
                setting = Gdx.app.getPreferences("setting");
                setting.putFloat("soundValue",MenuCache.soundValue);
                setting.putFloat("musicValue",MenuCache.musicValue);
                setting.putBoolean("autoSave",MenuCache.autoSaving);
                setting.putBoolean("playerTeacher",MenuCache.playerTeach);
                setting.flush();
                MenuCache.isModed = true;
            }
        });

        Button notButton = new Button(notStyle);
        notButton.setX(notButton.getWidth()*3);
        notButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                getMainGame().getStartScreen().setSettingStage(false);
            }
        });

        Switch autoSave = new Switch(switchStyle);
        autoSave.setX(sureButton.getX()*2-autoSave.getWidth()/2);
        autoSave.setY(SettingStage.background.getHeight()/4f+sureButton.getHeight());
        autoSave.addListener(new ClickListener(){
           @Override
           public void clicked(InputEvent event,float x,float y){
               MenuCache.autoSaving = !MenuCache.autoSaving;
           }
        });
        if(MenuCache.isModed) autoSave.setStatus(MenuCache.autoSaving);

        Switch playerTeacher = new Switch(switchStyle);
        playerTeacher.setX(autoSave.getX());
        playerTeacher.setY(autoSave.getY()-autoSave.getHeight());
        playerTeacher.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event,float x,float y){
                MenuCache.playerTeach = !MenuCache.playerTeach;
            }
        });
        if(MenuCache.isModed) playerTeacher.setStatus(MenuCache.playerTeach);

        addActor(sureButton);
        addActor(notButton);
        addActor(autoSave);
        addActor(playerTeacher);
    }
}
