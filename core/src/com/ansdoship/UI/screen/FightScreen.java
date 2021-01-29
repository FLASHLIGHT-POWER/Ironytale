package com.ansdoship.UI.screen;

import com.ansdoship.MainGame;
import com.ansdoship.UI.stage.FightStage;
import com.ansdoship.core.control.PlayerController;
import com.ansdoship.core.world.model.friend.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
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
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;

import java.util.ArrayList;

public class FightScreen extends ScreenAdapter {
    private final MainGame mainGame;
    private FightStage fightStage;
    private PerspectiveCamera perspectiveCamera;
    private boolean startRend = false;
    private Player player;
    private ModelInstance spaceInstance;
    private ModelBatch modelBatch;
    private Environment environmentTest;
    private PlayerController playerController;

    private AssetManager assets;
    private final ArrayList<ModelInstance> instances =  new ArrayList<>();


    public FightScreen(MainGame mainGame) {
        this.mainGame = mainGame;
        init();
    }

    public void init(){
        modelBatch = new ModelBatch();

        assets = new AssetManager();

        assets.load("model/ship.obj", Model.class);
        assets.load("model/spacesphere.obj",Model.class);
        assets.load("model/weapon.obj",Model.class);

        //本来想用assets的
        ModelLoader loader = new ObjLoader();
        player = new Player(loader.loadModel(Gdx.files.internal("model/ship.obj")),
                loader.loadModel(Gdx.files.internal("model/weapon.obj")));

        perspectiveCamera = new PerspectiveCamera(  67,(int)MainGame.WORLD_WIDTH, (int)MainGame.WORLD_HEIGHT);

        float[] position = player.getPosition();

        perspectiveCamera.position.set(position[0],position[1]+3,position[2]-3);
        perspectiveCamera.lookAt(position[0],position[1],position[2]);
        perspectiveCamera.near = 1f;
        perspectiveCamera.far = 300f;
        perspectiveCamera.update();

        environmentTest = new Environment();
        environmentTest.set(new ColorAttribute(ColorAttribute.AmbientLight,0.4f,0.4f,0.4f,0.1f));
        environmentTest.add(new DirectionalLight().set(0.8f,0.8f,0.8f,-1f,-0.8f,-0.2f));

        playerController = new PlayerController(player);

        startRend = true;

        fightStage = new FightStage(player,new ScreenViewport());
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        if (startRend && assets.update()) loadModel();

        Gdx.input.setInputProcessor(playerController);
        if(assets.update()) update(delta);

        modelBatch.begin(perspectiveCamera);

        perspectiveCamera.update();
        modelBatch.render(instances, environmentTest);

        if (spaceInstance != null) {
            modelBatch.render(spaceInstance);
        }
        modelBatch.end();

        fightStage.act();
        fightStage.draw();
    }

    private void loadModel(){
        Model model = player.getModel();
        ModelInstance shipInstance = new ModelInstance(model);
        Model spaceModel = assets.get("model/spacesphere.obj",Model.class);
        spaceInstance = new ModelInstance(spaceModel);
        instances.add(shipInstance);
        instances.set(0,shipInstance);

        model = player.getWeaponModel();
        shipInstance = new ModelInstance(model);
        instances.add(shipInstance);
        instances.set(1,shipInstance);

        startRend = false;
    }

    public void update(float delta){

        player.update(delta);
        float[] position = player.getPosition();

        ModelInstance instance1 = instances.get(0);
        instance1.transform.setToTranslation(position[0],position[1],position[2]);
        instances.set(0,instance1);

        instance1 = instances.get(1);
        instance1.transform.setToTranslation(position[0]-2,position[1]-2,position[2]);
        instances.set(1,instance1);

        perspectiveCamera.position.set(position[0],position[1]+3,position[2]-3);
        perspectiveCamera.lookAt(position[0],position[1],position[2]);

        for(ModelInstance instance : instances){

        }
    }
}
