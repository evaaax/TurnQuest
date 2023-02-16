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

    int x = 0;

    int y = 0;

    int xspeed = 5;

    int yspeed = 2;

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
        shape.begin(ShapeRenderer.ShapeType.Filled);
        shape.circle(x, y, 50);
        shape.line(x, y, 2*x, 3*y);
        shape.circle(2*x, 3*y, 10);

        if (x > Gdx.graphics.getWidth() - 200) {
            xspeed = -10;
        } else if (x < 200) {
            xspeed = 10;
        }

        if (y > Gdx.graphics.getHeight() - 200) {
            xspeed = -10;
        } else if (y < 200) {
            xspeed = 10;
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
