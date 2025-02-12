package com.example.snake;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

public class SnakeController {
    private SnakeModel model;
    private SnakeView view;
    private GraphicsContext gc;


    public SnakeController(SnakeModel model, SnakeView view) {
        this.model = new SnakeModel(gc);
        this.view = new SnakeView();
    }


    public void start(Stage primaryStage) {
        Group root = new Group();
        Canvas canvas = new Canvas(SnakeModel.WIDTH, SnakeModel.HEIGHT);
        gc = canvas.getGraphicsContext2D();

        root.getChildren().add(canvas);
        Scene scene = new Scene(root, SnakeModel.WIDTH, SnakeModel.HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Snake Game");
        primaryStage.show();


        model = new SnakeModel(gc);
        view = new SnakeView();


        model.drawBackGround(gc);
        model.drawFood(gc);
        model.drawSnake(gc);

    }
}