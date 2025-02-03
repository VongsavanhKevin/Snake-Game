package com.example.snake;


import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.canvas.Canvas;

public class SnakeView
{
    private static final int TILE_SIZE = 20;
    private Canvas canvas;
    private ModelSnake model;

    public SnakeView(Canvas unCanvas, ModelSnake unModelSnake)
    {
        this.canvas = unCanvas;
        this.model = unModelSnake;
    }
}
