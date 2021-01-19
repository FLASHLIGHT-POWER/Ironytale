package com.ansdoship;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {

    public static void main(String[] args) {

        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

        float scale = 1.2f;			// 适当改变窗口缩放比以适应自己的电脑屏幕

        config.width = (int) (MainGame.WORLD_WIDTH * scale);         // 窗口宽度
        config.height = (int) (MainGame.WORLD_HEIGHT * scale);        // 窗口高度

        new LwjglApplication(new MainGame(), config);
    }
}