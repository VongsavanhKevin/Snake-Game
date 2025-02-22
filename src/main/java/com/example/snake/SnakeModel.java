package com.example.snake;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.Light;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
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
    public static final int COLUMNS = ROWS;
    public static final int SQUARE_SIZE = WIDTH / ROWS;

    private List<Point> snakeBody = new ArrayList<>();
    private Point snakeHead;
    private int foodX;
    private int foodY;
    public static boolean gameOver = false;
    private int currentDirection;
    private Image foodImage;
    public static int score;

    private static final int RIGHT = 0;
    private static final int LEFT = 1;
    private static final int UP = 2;
    private static final int DOWN = 3;

    public SnakeModel() {
        this.snakeHead = new Point(10, 10);
        snakeBody.add(new Point(snakeHead.x, snakeHead.y));
        foodGeneration();
    }

    public void handle(KeyEvent event) {
        KeyCode code = event.getCode();
        if (code == KeyCode.RIGHT || code == KeyCode.D) {
            if (currentDirection != LEFT) currentDirection = RIGHT;
        } else if (code == KeyCode.LEFT || code == KeyCode.Q) {
            if (currentDirection != RIGHT) currentDirection = LEFT;
        } else if (code == KeyCode.UP || code == KeyCode.Z) {
            if (currentDirection != DOWN) currentDirection = UP;
        } else if (code == KeyCode.DOWN || code == KeyCode.S) {
            if (currentDirection != UP) currentDirection = DOWN;
        }
    }

    public void update() {
        if (gameOver) return;
        switch (currentDirection) {
            case RIGHT -> moveRight();
            case LEFT -> moveLeft();
            case DOWN -> moveDown();
            case UP -> moveUp();
        }
        if (snakeHead.x < 0 || snakeHead.x >= COLUMNS || snakeHead.y < 0 || snakeHead.y >= ROWS) gameOver = true;
        for (Point bodyPart : snakeBody) {
            if (bodyPart.equals(snakeHead)) gameOver = true;
        }
        if (snakeHead.x == foodX && snakeHead.y == foodY) {
            snakeBody.add(new Point(foodX, foodY));
            foodGeneration();
        } else if (!snakeBody.isEmpty()) {
            snakeBody.add(0, new Point(snakeHead.x, snakeHead.y));
            snakeBody.remove(snakeBody.size() - 1);
        }
    }

    private void moveRight() {
        snakeHead.x++;}

    private void moveLeft() {
        snakeHead.x--; }

    private void moveDown() {
        snakeHead.y++; }

    private void moveUp() {
        snakeHead.y--; }

    private void foodGeneration() {
        while (true) {
            foodX = (int) (Math.random() * ROWS);
            foodY = (int) (Math.random() * COLUMNS);
            boolean onSnake = false;
            for (Point snake : snakeBody) {
                if (snake.getX() == foodX && snake.getY() == foodY) {
                    onSnake = true;
                    break;
                }
            }
            if (!onSnake) break;
        }
        foodImage = new Image(getClass().getResource("/img/pomme.png").toExternalForm());
    }

    public void gameOver() {
        // Collision avec les murs
        if (snakeHead.x < 0 || snakeHead.y < 0 || snakeHead.x >= COLUMNS || snakeHead.y >= ROWS) {
            gameOver = true;
        }

        // Collision avec le corps du serpent
        for (int i = 1; i < snakeBody.size(); i++) {
            if (snakeHead.x == snakeBody.get(i).x &&
                    snakeHead.y == snakeBody.get(i).y) {
                gameOver = true;
                break;
            }
        }
    }

    private void eatFood(){
        if (snakeHead.getX() == foodX && snakeHead.getY() == foodY){
            snakeBody.add(new Point(-1, -1));
            foodGeneration();
            score = 10;
        }
    }



    // GETTER

    public List<Point> getSnakeBody(){
        return snakeBody; }

    public Point getSnakeHead(){
        return snakeHead; }

    public int getFoodX(){
        return foodX;
    }
    public int getFoodY(){
        return foodY; }

    public Image getFoodImage(){
        return foodImage; }

    public boolean isGameOver(){
        return gameOver; }
}
