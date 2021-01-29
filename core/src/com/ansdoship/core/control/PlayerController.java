package com.ansdoship.core.control;

import com.ansdoship.core.world.model.friend.Player;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

public class PlayerController implements InputProcessor {

    private final Player player;

    public PlayerController(Player player){
        super();
        this.player = player;
    }

    @Override
    public boolean keyDown(int i) {
        switch(i){
            case Input.Keys.E :
                player.front = true;
                return true;
            case Input.Keys.D :
                player.back = true;
                return true;
            case Input.Keys.S :
                player.left = true;
                return true;
            case Input.Keys.F :
                player.right = true;
                return true;
            case Input.Keys.N :
                player.up = true;
                return true;
            case Input.Keys.M :
                player.down = true;
                return true;
            case Input.Keys.A:
                player.shoot = true;
        }
        return false;
    }

    @Override
    public boolean keyUp(int i) {
        switch(i){
            case Input.Keys.E :
                player.front = false;
                return true;
            case Input.Keys.D :
                player.back = false;
                return true;
            case Input.Keys.S :
                player.left = false;
                return true;
            case Input.Keys.F :
                player.right = false;
                return true;
            case Input.Keys.N :
                player.up = false;
                return true;
            case Input.Keys.M :
                player.down = false;
                return true;
            case Input.Keys.A:
                player.shoot = false;
                return true;
        }
        return false;
    }

    @Override
    public boolean keyTyped(char c) {
        return false;
    }

    @Override
    public boolean touchDown(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchUp(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchDragged(int i, int i1, int i2) {
        return false;
    }

    @Override
    public boolean mouseMoved(int i, int i1) {
        return false;
    }

    @Override
    public boolean scrolled(int i) {
        return false;
    }
}
