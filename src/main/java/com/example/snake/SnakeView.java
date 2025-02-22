package com.example.snake;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import java.awt.*;
import java.util.List;

public class SnakeView {
    public void drawBackGround(GraphicsContext gc) {
        for (int i = 0; i < SnakeModel.ROWS; i++) {
            for (int j = 0; j < SnakeModel.COLUMNS; j++) {
                gc.setFill((i + j) % 2 == 0 ? Color.web("#1E4620") : Color.web("#2C7038"));
                gc.fillRect(i * SnakeModel.SQUARE_SIZE, j * SnakeModel.SQUARE_SIZE, SnakeModel.SQUARE_SIZE, SnakeModel.SQUARE_SIZE);
            }
        }
    }
    public void drawFood(GraphicsContext gc, int foodX, int foodY, Image foodImage) {
        gc.drawImage(foodImage, foodX * SnakeModel.SQUARE_SIZE, foodY * SnakeModel.SQUARE_SIZE, SnakeModel.SQUARE_SIZE, SnakeModel.SQUARE_SIZE);
    }
    public void drawSnake(GraphicsContext gc, List<Point> snakeBody) {
        gc.setFill(Color.web("#4674E9"));
        for (Point point : snakeBody) {
            gc.fillRoundRect(point.x * SnakeModel.SQUARE_SIZE, point.y * SnakeModel.SQUARE_SIZE, SnakeModel.SQUARE_SIZE-1, SnakeModel.SQUARE_SIZE-1, 20, 20);
        }
    }

    public void gameOver(GraphicsContext gc) {
        if (SnakeModel.gameOver) {
            gc.setFill(Color.RED);
            gc.setFont(javafx.scene.text.Font.font("Digital-7", 70)); // Utilisez Font de JavaFX
            String gameOverText = "Game Over";
            gc.fillText(gameOverText, SnakeModel.WIDTH/3.5, SnakeModel.HEIGHT/2);
            return;
        }
    }

    public void drawScore(GraphicsContext gc){
        gc.setFill(Color.WHITE);
        gc.setFont(javafx.scene.text.Font.font("Digital-7", 35));
        gc.fillText("Score: "+ SnakeModel.score,10,35);
    }
}
