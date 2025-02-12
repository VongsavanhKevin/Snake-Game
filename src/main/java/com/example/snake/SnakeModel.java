package com.example.snake;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.Light;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.image.Image;


import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SnakeModel {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 800;
    public static final int ROWS = 20;
    public static final int COLUMS = ROWS;
    public static final int SQUARE_SIZE = WIDTH / ROWS;
    private GraphicsContext gc;

    private List<Point> snakeBody = new ArrayList<>();
    private Point snakeHead;
    private int foodX;
    private int foodY;
    private boolean gameOver = false;
    private int currentDirection;
    private Image foodImage;

    public SnakeModel(GraphicsContext gc) {
        this.gc = gc;
        this.snakeHead = new Point(10, 10);
        foodGeneration(gc);
    }


    public void drawBackGround(GraphicsContext gc) {
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

    void drawFood(GraphicsContext gc){
        gc.drawImage(foodImage, foodX * SQUARE_SIZE, foodY* SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
    }

    void drawSnake(GraphicsContext gc){
        if (snakeHead == null) {
            System.err.println("Erreur: snakeHead est null !");
            return;
        }

        gc.setFill(Color.web("4674E9"));
        gc.fillRect(snakeHead.getX() * SQUARE_SIZE, snakeHead.getY() * SQUARE_SIZE, SQUARE_SIZE-1, SQUARE_SIZE-1);

        for (int i = 1; i < snakeBody.size(); i++) {
            gc.fillRoundRect(snakeBody.get(i).getX() * SQUARE_SIZE, snakeBody.get(i).getY() * SQUARE_SIZE, SQUARE_SIZE-1, SQUARE_SIZE-1, 20, 20);
        }
    }


    private void foodGeneration(GraphicsContext gc) {
        start:
        while (true) {
            foodX = (int) (Math.random() * ROWS );
            foodY = (int) (Math.random() * COLUMS );

            for(Point snake : snakeBody) {
                if(snake.getX() == foodX && snake.getY() == foodY){
                    continue start;
                }
            }
            foodImage = new Image(getClass().getResource("/img/pomme.png").toExternalForm());

            break;

        }
    }


    private void run() {
        drawBackGround(gc);
        drawFood(gc);
        drawSnake(gc);
    }



}