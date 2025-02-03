package com.example.snake;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class SnakeApp extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SnakeApp.class.getResource("Snake_view.fxml"));
        Image logo = new Image(getClass().getResourceAsStream("/img/logoFenetre.png"));
        primaryStage.getIcons().add(logo);

        // Image de fond
        Image backgroundImage = new Image(getClass().getResourceAsStream("/img/logo.png"));
        ImageView backgroundView = new ImageView(backgroundImage);
        backgroundView.setFitWidth(500);  // Assurez-vous que la largeur est correcte
        backgroundView.setFitHeight(400); // Assurez-vous que la hauteur est correcte

        // Créer le Pane et ajouter l'image en fond
        Pane pane = new Pane();
        pane.getChildren().add(backgroundView);  // Ajouter l'image de fond en premier

        // Charger le contenu FXML par-dessus l'image de fond
        pane.getChildren().add(fxmlLoader.load());

        // Créer la scène avec une taille fixe
        Scene scene = new Scene(pane, 500, 600);


        primaryStage.setTitle("Snake Game !");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);  // Désactive le redimensionnement
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
