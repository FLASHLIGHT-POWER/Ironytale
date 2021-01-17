package com.ansdoship.UI.screen;

import com.ansdoship.MainGame;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;

public class GameScreen implements Screen {

    private PerspectiveCamera perspectiveCamera;

    private Model model;
    private ModelInstance instance;
    private final MainGame mainGame;

    public GameScreen(MainGame mainGame) {
        this.mainGame = mainGame;
        init();
    }

    @Override
    public void show() {

    }

    public void init(){
        perspectiveCamera = new PerspectiveCamera();
        perspectiveCamera.position.set(10f,10f,10f);
        perspectiveCamera.lookAt(0,0,0);
        perspectiveCamera.far = 300f;
        perspectiveCamera.near = 0.1f;
        perspectiveCamera.update();

        ModelBuilder builder = new ModelBuilder();
        model = builder.createBox(5f,5f,5f, new Material(ColorAttribute.createDiffuse(Color.CYAN)),
                 VertexAttributes.Usage.Position|VertexAttributes.Usage.Normal);
        instance = new ModelInstance(model);
    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        model.dispose();
    }

}