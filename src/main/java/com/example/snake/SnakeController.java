package com.example.snake;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import javafx.scene.input.KeyEvent;

import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SnakeController {
    private SnakeModel model;
    private SnakeView view;

    public SnakeController(SnakeModel model, SnakeView view) {
        this.model = model;
        this.view = view;
    }

    public void start(Stage primaryStage) {
        Group root = new Group();
        Canvas canvas = new Canvas(SnakeModel.WIDTH, SnakeModel.HEIGHT);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        root.getChildren().add(canvas);
        Scene scene = new Scene(root, SnakeModel.WIDTH, SnakeModel.HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Snake Game");
        primaryStage.show();
        scene.setOnKeyPressed(event -> model.handle(event));

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(200), event -> {
            model.update();
            view.drawBackGround(gc);
            view.drawFood(gc, model.getFoodX(), model.getFoodY(), model.getFoodImage());
            view.drawSnake(gc, model.getSnakeBody());
            view.gameOver(gc);
            view.drawScore(gc);
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
}
