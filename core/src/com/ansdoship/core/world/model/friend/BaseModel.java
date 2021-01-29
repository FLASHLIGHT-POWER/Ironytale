package com.ansdoship.core.world.model.friend;

import com.badlogic.gdx.graphics.g3d.Model;

public class BaseModel {

    protected float MaxHealth = 1;
    protected float health;
    protected int team;
    protected Model model,weaponModel;
    protected float[] position;

    public BaseModel(Model model,Model weaponModel){
        this.model = model;
        this.weaponModel = weaponModel;
        health = MaxHealth;
        team = 1;
        position = new float[3];
        position[0] = 0;
        position[1] = 0;
        position[2] = 0;
    }

    public void die(){
        model.dispose();
    }

    public void update(){
        if(health== 0) die();
    }

    public int getTeam(){
        return team;
    }

    public void setTeam(int team){
        this.team = team;
    }

    public void act(){
        if(health<=0) this.die();
    }
}
