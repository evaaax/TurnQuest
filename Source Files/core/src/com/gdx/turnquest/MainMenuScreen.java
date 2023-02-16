package com.gdx.turnquest;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.concurrent.TimeUnit;

public class MainMenuScreen implements Screen {

    final TurnQuest game;

    OrthographicCamera camera;

    public static final int VIRTUAL_WIDTH = 1920;

    public static final int VIRTUAL_HEIGHT = 1080;

    ShapeRenderer shape;

    int x = 100;

    int y = 100;

    int x1 = 0;

    int x2 = 0;

    int y1 = 0;

    int y2 = 0;

    int xspeed = 10;

    int yspeed = 5;

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

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        game.font.getData().setScale(2); //Changes font size.
        game.font.draw(game.batch, "Welcome to TurnQuest!", x, 400);
        game.font.draw(game.batch, "Click anywhere to begin!", x, 350);
        game.batch.end();

        x += xspeed;
        y += yspeed;
        x1 += xspeed;
        y1 += yspeed;
        x2 += xspeed;
        y2 += yspeed;
        shape.begin(ShapeRenderer.ShapeType.Filled);
        shape.circle(x1, y1, 50);
        shape.line(x1, y1, 2 * x1, 3 * y1);
        shape.circle(2 * x1, 3 * y1, 10);

        if (x1 >= (Gdx.graphics.getWidth())) {
            xspeed = -10;
        } else if (x1 <= 0) {
            xspeed = 10;
        }

        if (y1 >= (Gdx.graphics.getHeight())) {
            yspeed = -5;
        } else if (y1 <= 0) {
            yspeed = 5;
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
