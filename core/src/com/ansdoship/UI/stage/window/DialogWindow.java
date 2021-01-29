package com.ansdoship.UI.stage.window;

import com.ansdoship.MainGame;
import com.ansdoship.UI.actor.BaseActor;
import com.ansdoship.UI.stage.BaseStage;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.Viewport;

public class DialogWindow extends BaseStage{

    private BitmapFont font;
    private static final String TAG = MainGame.class.getSimpleName();
    private int line;

    public DialogWindow(MainGame mainGame, Viewport viewport,String title,String text,int line) {
        super(mainGame, viewport);
        this.line = line;
        init(title,text);

    }

    public void init(String titleText,String text){
        font = new BitmapFont(Gdx.files.internal("fonts/unifont.fnt"));

        Label.LabelStyle style = new Label.LabelStyle();
        style.font = font;
        style.fontColor = new Color(0,0,0,1f);

        Label title = new Label(titleText,style);
        Label content = new Label(text,style);

        BaseActor back = new BaseActor(new TextureRegion(new Texture(Gdx.files.internal("sprites/dialogBack.png"))));
        back.setPosition(MainGame.WORLD_WIDTH/2-back.getWidth()/2,MainGame.WORLD_HEIGHT/2-back.getHeight()/2);

        title.setPosition(back.getX()+20, back.getY() +back.getHeight() - title.getHeight()*1.5f);
        title.setScale(0.3f);

        content.setPosition( title.getX(), title.getY()-line*30);

        Button.ButtonStyle buttonStyle = new Button.ButtonStyle();
        buttonStyle.up = new TextureRegionDrawable(new TextureRegion(new Texture("button/sure.png")));
        buttonStyle.down = new TextureRegionDrawable(new TextureRegion(new Texture("button/sure2.png")));

        Button button = new Button(buttonStyle);
        button.setPosition(back.getX()+back.getWidth()/2, back.getY());
        button.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                getMainGame().getGameScreen().setDialogWindow(false);
                getMainGame().showFightScreen(true);
                Gdx.app.log(TAG,"001");
            }
        });
        addActor(back);
        addActor(title);
        addActor(content);
        addActor(button);
    }
}
