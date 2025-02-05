package com.example.snake;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class SnakeModel
{
    public static final int WIDTH = 800;
    public static final int HEIGHT = 800;
    public static final int ROWS = 20;
    public static final int COLUMS = ROWS;
    public static final int SQUARE_SIZE = WIDTH/ROWS;
    private GraphicsContext gc;

    public void drawBackGround(GraphicsContext gc)
    {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMS; j++) {
                if ((i + j) % 2 == 0) {
                    gc.setFill(Color.web("#1E4620"));
                } else {
                    gc.setFill(Color.web("#2C7038"));
                }
                gc.fillRect(i * SQUARE_SIZE, j * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
            }
        }
    }

    private void run()
    {
        drawBackGround(gc);
    }


}