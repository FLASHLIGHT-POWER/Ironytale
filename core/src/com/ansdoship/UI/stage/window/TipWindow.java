package com.ansdoship.UI.stage.window;

import com.ansdoship.MainGame;
import com.ansdoship.UI.stage.BaseStage;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.viewport.Viewport;

public class TipWindow extends BaseStage {

    private String content;
    private int line;
    private BitmapFont font;

    public TipWindow(MainGame mainGame, Viewport viewport,String content,int line) {
        super(mainGame, viewport);
        this.content = content;
        this.line = line;
        init();
    }

    public void init(){
        font = new BitmapFont(Gdx.files.internal("font/unifont.fnt"));;

        Label.LabelStyle style = new Label.LabelStyle();
        style.font = font;
        style.fontColor = new Color(0,0,0,1f);

        Label label = new Label(content,style);
        label.setPosition(0,0);

        addActor(label);
    }
}
