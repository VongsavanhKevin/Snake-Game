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
import javafx.application.Application;
import javafx.stage.Stage;

public class SnakeMain extends Application {
    private GraphicsContext gc;

    public void start(Stage primaryStage) {
        SnakeModel snakeModel = new SnakeModel();
        SnakeView snakeView = new SnakeView();
        SnakeController controller = new SnakeController(snakeModel, snakeView);
        controller.start(primaryStage); // Démarrer le jeu via le contrôleur
    }

    public static void main(String[] args) {
        launch(args); // Lancer JavaFX
    }
}
