package com.ansdoship.UI.stage;

import com.ansdoship.MainGame;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;

public abstract class BaseStage extends Stage {

    private MainGame mainGame;

    /** 舞台是否可见（是否更新和绘制） */
    private boolean visible = true;

    public BaseStage(MainGame mainGame, Viewport viewport) {
        super(viewport);
        this.mainGame = mainGame;
    }

    public MainGame getMainGame(){
        return mainGame;
    }

    public void setMainGame(MainGame mainGame){
        this.mainGame = mainGame;
    }

    public boolean isVisible(){
        return visible;
    }

    public void setVisible(boolean visible){
        this.visible = visible;
    }

}
