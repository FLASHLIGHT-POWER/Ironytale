package com.ansdoship.UI.group;

import com.ansdoship.MainGame;
import com.badlogic.gdx.scenes.scene2d.Group;

public class BaseGroup extends Group{
    private  MainGame mainGame;

    public BaseGroup(MainGame mainGame) {
        this.mainGame = mainGame;
    }
    public void setMainGame(MainGame mainGame){
        this.mainGame = mainGame;
    }

    public MainGame getMainGame(){
        return mainGame;
    }
}