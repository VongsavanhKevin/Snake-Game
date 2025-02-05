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
        this.model = new SnakeModel();
        this.view = new SnakeView();
    }


    public void start(Stage primaryStage) {
        // Création de la scène et du canvas
        Group root = new Group();
        Canvas canvas = new Canvas(SnakeModel.WIDTH, SnakeModel.HEIGHT);
        gc = canvas.getGraphicsContext2D(); // 🔹 Initialisation de gc

        root.getChildren().add(canvas);
        Scene scene = new Scene(root, SnakeModel.WIDTH, SnakeModel.HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Snake Game");
        primaryStage.show();

        // 🔹 Initialisation du modèle avec gc
        model = new SnakeModel();
        view = new SnakeView();

        // Dessiner l’arrière-plan
        model.drawBackGround(gc);
    }
}