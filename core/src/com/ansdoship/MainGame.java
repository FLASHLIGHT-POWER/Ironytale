package com.ansdoship;

import com.ansdoship.UI.screen.GameScreen;
import com.ansdoship.UI.screen.StartScreen;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;

public class MainGame extends Game {

    public static final float WORLD_WIDTH = 720;
    public static final float WORLD_HEIGHT = 480;

    private StartScreen startScreen;
    private GameScreen gameScreen;

    private PerspectiveCamera perspectiveCamera;
    private boolean startGame = false;
    private Model model;
    private ModelInstance instance;
    private ModelBatch modelBatch;
    private static final String TAG = MainGame.class.getSimpleName();
    public MainGame() {
    }

    @Override
    public void create() {

        Gdx.app.setLogLevel(Application.LOG_DEBUG);

        startScreen = new StartScreen(this);
        gameScreen = new GameScreen(this);
        setScreen(startScreen);

        modelBatch = new ModelBatch();

        perspectiveCamera = new PerspectiveCamera(  67,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        perspectiveCamera.position.set(10f,10f,10f);
        perspectiveCamera.lookAt(0,0,0);
        perspectiveCamera.near = 1f;
        perspectiveCamera.far = 300f;
        perspectiveCamera.update();

        ModelBuilder builder = new ModelBuilder();
        model = builder.createBox(5f,5f,5f, new Material(ColorAttribute.createDiffuse(Color.GREEN)),
                VertexAttributes.Usage.Position|VertexAttributes.Usage.Normal);
        instance = new ModelInstance(model);
    }

    @Override
    public void render(){

        if(!startGame) {
            super.render();
        }
        if(startGame) {
            Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

            modelBatch.begin(perspectiveCamera);
            modelBatch.render(instance);
            modelBatch.end();
            setScreen(null);
        }
    }

    @Override
    public void dispose() {
        super.dispose();

        if (startScreen != null) {
            startScreen.dispose();
            startScreen = null;
        }
        if (gameScreen != null) {
            gameScreen.dispose();
            gameScreen = null;
        }
    }

    public void showGameScreen() {
        startGame =true;
    }

    public StartScreen getStartScreen(){
        return startScreen;
    }
}
