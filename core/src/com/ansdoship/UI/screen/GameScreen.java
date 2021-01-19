package com.ansdoship.UI.screen;

import com.ansdoship.MainGame;
import com.ansdoship.UI.stage.window.DialogWindow;
import com.ansdoship.core.cache.MenuCache;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.ModelLoader;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.loader.ObjLoader;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.util.ArrayList;

public class GameScreen implements Screen {

    private final MainGame mainGame;
    private PerspectiveCamera perspectiveCamera;
    private boolean startRend = false;
    private Model model;
    private ModelInstance shipInstance,spaceInstance;
    private ModelBatch modelBatch;
    private Environment environmentTest;
    private CameraInputController cameraController;
    private AssetManager assets;
    private final ArrayList<ModelInstance> instances =  new   ArrayList<>();
    private DialogWindow dialog;
    public GameScreen(MainGame mainGame) {
        this.mainGame = mainGame;
        init();
    }

    @Override
    public void show() {

    }

    public void init(){
        modelBatch = new ModelBatch();

        perspectiveCamera = new PerspectiveCamera(  67,(int)MainGame.WORLD_WIDTH, (int)MainGame.WORLD_HEIGHT);

        perspectiveCamera.position.set(50f,50f,5f);
        perspectiveCamera.lookAt(0,0,0);
        perspectiveCamera.near = 1f;
        perspectiveCamera.far = 300f;
        perspectiveCamera.update();

        environmentTest = new Environment();
        environmentTest.set(new ColorAttribute(ColorAttribute.AmbientLight,0.4f,0.4f,0.4f,0.1f));
        environmentTest.add(new DirectionalLight().set(0.8f,0.8f,0.8f,-1f,-0.8f,-0.2f));

        cameraController = new CameraInputController(perspectiveCamera);

        assets = new AssetManager();
        assets.load("model/ship.obj", Model.class);
        assets.load("model/spacesphere.obj",Model.class);

        ModelLoader loader = new ObjLoader();
        model = loader.loadModel(Gdx.files.internal("model/ship.obj"));
        startRend = true;
        if (MenuCache.playerTeach) startTeaching();

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        if (startRend && assets.update()) loadModel();

        Gdx.input.setInputProcessor(cameraController);
        cameraController.update();

        modelBatch.begin(perspectiveCamera);
        modelBatch.render(instances, environmentTest);

        if (spaceInstance != null) {
            modelBatch.render(spaceInstance);
        }
        modelBatch.end();

        if(dialog.isVisible()) {
            dialog.act();
            dialog.draw();
        }
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

    private void startTeaching(){
        dialog = new DialogWindow(mainGame,new ScreenViewport(),
                "???","Welcome to the game.");
        dialog.setVisible(true);
        Gdx.input.setInputProcessor(dialog);
    }

    public void setDialogWindow(boolean bool){
        dialog.setVisible(bool);
        if(bool){Gdx.input.setInputProcessor(dialog);}else{Gdx.input.setInputProcessor(null);}
    }

    private void loadModel(){
        model = assets.get("model/ship.obj",Model.class);
        shipInstance = new ModelInstance(model);
        model = assets.get("model/spacesphere.obj",Model.class);
        spaceInstance = new ModelInstance(model);
        instances.add(shipInstance);
        startRend = false;
    }
}