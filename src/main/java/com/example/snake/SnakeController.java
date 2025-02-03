package com.example.snake;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;

import java.sql.SQLOutput;

public class SnakeController
{
    @FXML private Canvas gameCanvas;
    private SnakeView view;
    private ModelSnake model;
    private Timeline gameTimeline;

    public void initialize()
    {
        model = new ModelSnake();
        view = new SnakeView(gameCanvas, model);
        startGame();
    }

    public void startGame()
    {
        System.out.println("Le jeu commence");
        model = new ModelSnake();
        draw();
    }

    private void draw()
    {
        var graphicsContext = gameCanvas.getGraphicsContext2D();
        graphicsContext.clearRect(0, 0, gameCanvas.getWidth(), gameCanvas.getHeight());
    }

    public void exitGame()
    {
        System.out.println("Au revoir !");
        System.exit(0);
    }

    public void handleKeyPress(KeyEvent event) {
        switch (event.getCode()) {
            case UP:
                ModelSnake.setDirection(ModelSnake.Direction.UP);
                break;
            case DOWN:
                ModelSnake.setDirection(ModelSnake.Direction.DOWN);
                break;
            case LEFT:
                ModelSnake.setDirection(ModelSnake.Direction.LEFT);
                break;
            case RIGHT:
                ModelSnake.setDirection(ModelSnake.Direction.RIGHT);
                break;
        }
    }



}