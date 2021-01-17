package com.ansdoship.UI.stage;

import com.ansdoship.MainGame;
import com.ansdoship.UI.actor.FontActor;
import com.ansdoship.UI.group.SettingButtonGroup;
import com.ansdoship.UI.actor.BaseActor;
import com.ansdoship.core.cache.MenuCache;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.Viewport;

public class SettingStage extends BaseStage{

    private Slider musicSlider,soundSlider;
    private FontActor musicFont,soundFont, saveFont,playerFont;
    public static Texture background;

    public SettingStage(MainGame mainGame, Viewport viewport){
        super(mainGame, viewport);
        init();
    }

    public void init(){

        background = new Texture(Gdx.files.internal("sprites/background.png"));
        BaseActor back = new BaseActor(new TextureRegion(background));

        back.setPosition(180,120);
        addActor(back);

        SettingButtonGroup button = new SettingButtonGroup(getMainGame());
        button.setPosition(back.getX()+ button.getWidth() / 4,back.getY() + button.getHeight()/4);
        addActor(button);

        Texture sliderBackground = new Texture(Gdx.files.internal("sprites/slider/background.png"));
        Texture sliderKnob = new Texture(Gdx.files.internal("sprites/slider/knob.png"));
        Texture sliderKnob2 = new Texture(Gdx.files.internal("sprites/slider/knob2.png"));

        Slider.SliderStyle musicSliderStyle = new Slider.SliderStyle();
        musicSliderStyle.background = new TextureRegionDrawable(new TextureRegion(sliderBackground));
        musicSliderStyle.knob = new TextureRegionDrawable(new TextureRegion(sliderKnob2));

        Slider.SliderStyle soundSliderStyle = new Slider.SliderStyle();
        soundSliderStyle.background = new TextureRegionDrawable(new TextureRegion(sliderBackground));
        soundSliderStyle.knob = new TextureRegionDrawable(new TextureRegion(sliderKnob));

        soundSlider = new Slider(0f,100f,1,false,soundSliderStyle);
        soundSlider.setPosition(260,360);
        soundSlider.addListener(new ChangeListener() {

            @Override
            public void changed(ChangeEvent event, Actor actor) {
                MenuCache.soundValue = soundSlider.getValue();
            }
        });
        if(MenuCache.isModed) soundSlider.setValue(MenuCache.soundValue);
        else soundSlider.setValue(100f);

        musicSlider = new Slider(0f,100f,1,false,musicSliderStyle);
        musicSlider.setPosition(260,300);
        musicSlider.addListener(new ChangeListener() {

            @Override
            public void changed(ChangeEvent event, Actor actor) {
                MenuCache.musicValue = musicSlider.getValue();
            }
        });
        if(MenuCache.isModed) musicSlider.setValue(MenuCache.musicValue);
        else musicSlider.setValue(100f);

        musicFont = new FontActor("音乐音量:"+musicSlider.getValue(),musicSlider.getX(),musicSlider.getY()+musicSlider.getHeight()*1.5f,0.7f);
        soundFont = new FontActor("音效音量:"+soundSlider.getValue(),soundSlider.getX(),soundSlider.getY()+ soundSlider.getHeight()*1.5f,0.7f);
        saveFont = new FontActor("自动存档:",soundSlider.getX(),musicSlider.getY()-musicSlider.getHeight(),0.7f);
        playerFont = new FontActor("新手教程:",soundSlider.getX(),musicSlider.getY()-musicSlider.getHeight()*2.2f,0.7f);

        addActor(soundSlider);
        addActor(musicSlider);
        addActor(musicFont);
        addActor(soundFont);
        addActor(saveFont);
        addActor(playerFont);
    }

    @Override
    public void act(){
        super.act();
        musicFont.setText("音乐音量:"+musicSlider.getValue());
        soundFont.setText("音效音量:"+soundSlider.getValue());
    }
}