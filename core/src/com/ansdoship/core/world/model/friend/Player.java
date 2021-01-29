package com.ansdoship.core.world.model.friend;

import com.badlogic.gdx.graphics.g3d.Model;

public class Player extends BaseModel {

    public boolean front,back,left,right,up,down,shoot;
    private float accelerationFront,accelerationLeft,accelerationUp;

    public Player(Model model,Model weaponModel) {
        super(model,weaponModel);
        health = 50;
        team =0;
        accelerationFront = 0;
        accelerationLeft = 0;
        accelerationUp = 0;
    }

    public void update(float delta){
        super.update();

        float[] position = this.getPosition();

        float[] f = setPos(left,accelerationLeft,position[0],delta);
        position[0] = f[1];
        accelerationLeft = f[0];

        float[] fBack = setPosBack(right,accelerationLeft,position[0],delta);
        position[0] = fBack[1];
        accelerationLeft = fBack[0];

        fBack = setPosBack(down,accelerationUp,position[1],delta);
        position[1] = fBack[1];
        accelerationUp = fBack[0];

        f = setPos(up,accelerationUp,position[1],delta);
        accelerationUp = f[0];
        position[1] = f[1];

        f = setPos(front,accelerationFront,position[2],delta);
        accelerationFront = f[0];
        position[2] = f[1];

        fBack = setPosBack(back,accelerationFront,position[2],delta);
        accelerationFront = fBack[0];
        position[2] = fBack[1];

        //if(shoot) shoot();

        setPosition(position);
    }

    public float[] getPosition(){
        return position;
    }

    public void setPosition(float[] pos){
        position = pos;
    }

    public Model getModel(){
        return model;
    }

    public float[] setPos(boolean bool,float acceleration,float posi,float delta){
        if(bool){
            if(acceleration >0) {
                posi += 0.1f * acceleration;
            }
            if(acceleration < 2) acceleration += 0.1f*delta;
        }else{
            if(acceleration > 0){
                posi += 0.1f* acceleration;
                acceleration -= 0.1f*delta;
            }
        }
        float[] f = new float[2];
        f[0] = acceleration;
        f[1] = posi;
        return f;
    }

    public float[] setPosBack(boolean bool,float acceleration,float posi,float delta){
        if(bool){
            if(acceleration >-1) {
                acceleration -= 0.2f*delta;
            }

            if(acceleration <0)
                posi -= 0.1f*-acceleration;

        }else{
            if(acceleration <0) {
                posi -= 0.1f * -acceleration;
                acceleration += 0.1f*delta;
            }
        }
        float[] f = new float[2];
        f[0] = acceleration;
        f[1] = posi;
        return f;
    }

    public void shoot(){

    }

    public float getHealth(){
        return health;
    }

    public Model getWeaponModel(){
        return weaponModel;
    }
}
