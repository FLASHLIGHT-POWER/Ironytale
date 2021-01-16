package com.ansdoship.UI.group;

import com.ansdoship.MainGame;
import com.ansdoship.core.cache.MenuCache;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

    public class StartButtonGroup extends BaseGroup{

    private static final String TAG = MainGame.class.getSimpleName();

    public StartButtonGroup(MainGame mainGame) {
        super(mainGame);
        init();
    }

    public void init(){
        Texture buttonStart = new Texture("button/startButton.png");
        Texture buttonStart2 = new Texture("button/startButton2.png");
        Texture buttonLoad = new Texture("button/loadButton.png");
        Texture buttonLoad2 = new Texture("button/loadButton2.png");
        Texture buttonSetting = new Texture("button/settingButton.png");
        Texture buttonSetting2 = new Texture("button/settingButton2.png");
        Texture buttonThanking = new Texture("button/thankingButton.png");
        Texture buttonThanking2 = new Texture("button/thankingButton2.png");

        Button.ButtonStyle startButtonStyle = new Button.ButtonStyle();
        startButtonStyle.up = new TextureRegionDrawable(new TextureRegion(buttonStart));
        startButtonStyle.down = new TextureRegionDrawable(new TextureRegion(buttonStart2));

        Button.ButtonStyle loadButtonStyle = new Button.ButtonStyle();
        loadButtonStyle.up = new TextureRegionDrawable(new TextureRegion(buttonLoad));
        loadButtonStyle.down = new TextureRegionDrawable(new TextureRegion(buttonLoad2));

        Button.ButtonStyle settingButtonStyle = new Button.ButtonStyle();
        settingButtonStyle.up = new TextureRegionDrawable(new TextureRegion(buttonSetting));
        settingButtonStyle.down = new TextureRegionDrawable(new TextureRegion(buttonSetting2));

        Button.ButtonStyle thankingButtonStyle = new Button.ButtonStyle();
        thankingButtonStyle.up = new TextureRegionDrawable(new TextureRegion(buttonThanking));
        thankingButtonStyle.down = new TextureRegionDrawable(new TextureRegion(buttonThanking2));

        Button startButton = new Button(startButtonStyle);
        startButton.setY(startButton.getHeight()*4);
        startButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {

            }
        });

        Button loadButton = new Button(loadButtonStyle);
        loadButton.setY(loadButton.getHeight()*3);
        loadButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event,float x,float y){

            }
        });

        Button settingButton = new Button(settingButtonStyle);
        settingButton.setY(settingButton.getHeight()*2);
        settingButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event,float x,float y){
                getMainGame().getStartScreen().setSettingStage(true);
                Gdx.app.log(TAG,"切换至settingStage");
            }
        });

        Button thankingButton = new Button(thankingButtonStyle);
        thankingButton.setY(thankingButton.getHeight());
        thankingButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event,float x,float y){

            }
        });

        addActor(startButton);
        addActor(loadButton);
        addActor(settingButton);
        addActor(thankingButton);
    }
}
