package com.gdx.turnquest;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MainMenuScreen implements Screen {

    final TurnQuest game;

    OrthographicCamera camera;

    public static final Graphics.DisplayMode dm = Gdx.graphics.getDisplayMode();

    public static final int VIRTUAL_WIDTH = dm.width;

    public static final int VIRTUAL_HEIGHT = dm.height;
    ShapeRenderer shape;

    int x = 100;

    int y = 100;

    int x1 = 0;

    int x2 = 50;

    int y1 = 0;

    int y2 = 50;

    int xspeed = 10;

    int yspeed = 5;

    int x1speed = 10;

    int y1speed = 5;

    int x2speed = 20;

    int y2speed = 10;

    Viewport viewport;

    public MainMenuScreen(final TurnQuest game) {
        this.game = game;

        shape = new ShapeRenderer();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, VIRTUAL_WIDTH, VIRTUAL_HEIGHT);

        viewport = new FitViewport(VIRTUAL_WIDTH, VIRTUAL_HEIGHT, camera);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0.3f, 0.7f, 0.8f, 1); // You can also write a color here, this is the background.

        Random r = new Random();

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        game.font.getData().setScale(2); //Changes font size.
        game.font.draw(game.batch, "Welcome to TurnQuest!", x, 400);
        game.font.draw(game.batch, "Click anywhere to begin!", x, 350);
        game.font.draw(game.batch, "Press F11 to switch between fullscreen/windowed mode.", dm.width/2 - 350, dm.height - 50);
        if(Gdx.input.isKeyJustPressed(Input.Keys.F11)){
            if(Gdx.graphics.isFullscreen()){
                Gdx.graphics.setWindowedMode(dm.width/2, dm.height/2);
            }
            else {
                Gdx.graphics.setFullscreenMode(dm);
            }
        }
        game.batch.end();

        x += xspeed;
        y += yspeed;
        x1 += x1speed;
        y1 += y1speed;
        x2 += x2speed;
        y2 += y2speed;
        shape.begin(ShapeRenderer.ShapeType.Filled);
        shape.circle(x1, y1, 50);
        shape.line(x1, y1, x2, y2);
        shape.circle(x2, y2, 10);

        if (x >= (Gdx.graphics.getWidth() - 50)) {
            xspeed = -r.nextInt(0, 20);
        } else if (x <= 50) {
            xspeed = r.nextInt(0, 20);
        }

        if (y >= (Gdx.graphics.getHeight()) - 50) {
            yspeed = -r.nextInt(0, 20);
        } else if (y <= 50) {
            yspeed = r.nextInt(0, 20);
        }

        if (x1 >= (Gdx.graphics.getWidth()) - 50) {
            x1speed = -r.nextInt(0, 20);
        } else if (x1 <= 50) {
            x1speed = r.nextInt(0, 20);
        }

        if (y1 >= (Gdx.graphics.getHeight()) - 50) {
            y1speed = -r.nextInt(0, 20);
        } else if (y1 <= 50) {
            y1speed = r.nextInt(0, 20);
        }

        if (x2 >= (Gdx.graphics.getWidth()) - 10) {
            x2speed = -r.nextInt(0, 20);
        } else if (x2 <= 10) {
            x2speed = r.nextInt(0, 20);
        }

        if (y2 >= (Gdx.graphics.getHeight()) - 10) {
            y2speed = -r.nextInt(0, 20);
        } else if (y2 <= 10) {
            y2speed = r.nextInt(0, 20);
        }

        shape.end();

//        if (Gdx.input.isTouched()) {
//            game.setScreen(new GameScreen(game));
//            dispose();
//        }
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
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

    }
}
