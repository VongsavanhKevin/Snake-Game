package com.example.snake;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.Light;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

import javafx.scene.canvas.Canvas;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SnakeMain extends Application {

    private static final int WIDTH = 800;
    private static final int HEIGHT = WIDTH;
    private static final int ROWS = 20;
    private static final int COLUMNS = ROWS;
    private static final int SQARE_SIZE = WIDTH/ROWS;


    private GraphicsContext gc;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        primaryStage.setTitle("Snake");
        Group root = new Group();
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        root.getChildren().add(canvas);
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();
        gc = canvas.getGraphicsContext2D();
        run();
    }

    private void run()
    {
        drawBackGround(gc);
    }

    private void drawBackGround(GraphicsContext gc)
    {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if ((i + j) % 2 == 0) {
                    gc.setFill(Color.web("#1E4620"));
                } else {
                    gc.setFill(Color.web("#2C7038"));
                }
                gc.fillRect(i * SQARE_SIZE, j * SQARE_SIZE, SQARE_SIZE, SQARE_SIZE);
            }
        }
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}