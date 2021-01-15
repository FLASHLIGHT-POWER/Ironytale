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

    private static final String TAG = MainGame.class.getSimpleName();
    private Slider musicSlider,soundSlider;
    private FontActor musicFont,soundFont;

    public SettingStage(MainGame mainGame, Viewport viewport){
        super(mainGame, viewport);
        init();
    }

    public void init(){
        Texture background = new Texture(Gdx.files.internal("sprites/background.png"));
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
                Gdx.app.log(TAG,"slider改变");
            }
        });
        soundSlider.setValue(100f);

        musicSlider = new Slider(0f,100f,1,false,musicSliderStyle);
        musicSlider.setPosition(260,300);
        musicSlider.addListener(new ChangeListener() {

            @Override
            public void changed(ChangeEvent event, Actor actor) {
                MenuCache.soundValue = musicSlider.getValue();
                Gdx.app.log(TAG,"slider改变");
            }
        });
        musicSlider.setValue(100f);

        musicFont = new FontActor("音乐音量:"+musicSlider.getValue(),260,360,0.7f);
        soundFont = new FontActor("音效音量:"+soundSlider.getValue(),260,420,0.7f);

        addActor(soundSlider);
        addActor(musicSlider);
        addActor(musicFont);
        addActor(soundFont);
    }

    @Override
    public void act(){
        super.act();
        musicFont.setText("音乐音量:"+musicSlider.getValue());
        soundFont.setText("音效音量:"+soundSlider.getValue());
    }
}