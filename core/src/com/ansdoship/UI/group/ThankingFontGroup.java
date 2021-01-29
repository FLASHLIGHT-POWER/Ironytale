package com.ansdoship.UI.group;

import com.ansdoship.MainGame;
import com.ansdoship.UI.actor.FontActor;

public class ThankingFontGroup extends BaseGroup{

    public ThankingFontGroup(MainGame mainGame) {
        super(mainGame);
        init();
    }

    public void init(){
        FontActor a = new FontActor("美工:蜂王",0,MainGame.WORLD_HEIGHT*1.1f,0.7f);
        FontActor b = new FontActor("程序:手电",120,MainGame.WORLD_HEIGHT*1.1f,0.7f);
        addActor(a);
        addActor(b);
    }
}
