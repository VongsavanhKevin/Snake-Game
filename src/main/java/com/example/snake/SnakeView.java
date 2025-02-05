package com.example.snake;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class SnakeView
{
    private Canvas canvas;
    private GraphicsContext gc;

    private SnakeModel model;
    private SnakeController controller;

    public SnakeView() {
        this.model = new SnakeModel();
        this.canvas = new Canvas();
        this.gc = canvas.getGraphicsContext2D();
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public void drawBackground() {
        for (int i = 0; i < model.ROWS; i++) {
            for (int j = 0; j < model.COLUMS; j++) {
                if ((i + j) % 2 == 0) {
                    gc.setFill(Color.web("#1E4620"));
                } else {
                    gc.setFill(Color.web("#2C7038"));
                }
                gc.fillRect(i * model.SQUARE_SIZE, j * model.SQUARE_SIZE, model.SQUARE_SIZE, model.SQUARE_SIZE);
            }
        }
    }
}

