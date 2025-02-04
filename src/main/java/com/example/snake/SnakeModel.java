package com.example.snake;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class ModelSnake {
    private Direction direction;  // La direction actuelle du serpent
    private List<Point> snakeBody;
    private Point applePosition;
    private int score;
    private boolean gameOver;
    private int speed;
    private int gridWidth = 25, gridHeight = 25; // Taille de la grille de jeu

    // Constructeur
    public ModelSnake() {
        this.snakeBody = new ArrayList<Point>();
        this.snakeBody.add(new Point(gridWidth / 2, gridHeight / 2)); // Position initiale
        this.score = 0;
        this.gameOver = false;
        this.direction = Direction.RIGHT;  // Direction initiale
        this.speed = 100;  // La vitesse du jeu, ajustable selon tes besoins
        generateApple();  // Génére une pomme au début du jeu
    }

    // Enumération Direction
    public enum Direction {
        UP, DOWN, LEFT, RIGHT
    }

    // Méthode de déplacement du serpent
    public void move() {
        if (gameOver)
            return;

        // Récupère la tête du serpent
        Point head = snakeBody.get(0);
        Point newHead = new Point(head);  // Crée une nouvelle tête

        // Déplace la tête en fonction de la direction
        switch (direction) {
            case UP:
                newHead.y--;
                break;
            case DOWN:
                newHead.y++;
                break;
            case LEFT:
                newHead.x--;
                break;
            case RIGHT:
                newHead.x++;
                break;
        }

        // Ajoute la nouvelle tête en début de la liste
        snakeBody.add(0, newHead);

        // Vérifie si le serpent a mangé la pomme
        if (newHead.equals(getApplePosition())) {
            score += 10;  // Augmente le score
            generateApple();  // Génére une nouvelle pomme
        } else {
            // Retire le dernier segment du serpent
            snakeBody.remove(snakeBody.size() - 1);
        }

        // Vérifie si une collision a eu lieu
        checkCollision();
    }

    // Vérifie les collisions avec les bords ou le corps du serpent
    private void checkCollision() {
        Point head = snakeBody.get(0);

        // Collision avec les bords
        if (head.x < 0 || head.x >= gridWidth || head.y < 0 || head.y >= gridHeight) {
            gameOver = true;
        }

        // Collision avec le corps
        for (int i = 1; i < snakeBody.size(); i++) {
            if (head.equals(snakeBody.get(i))) {
                gameOver = true;
            }
        }
    }

    // Génére une nouvelle pomme dans un emplacement aléatoire
    private void generateApple() {
        applePosition = new Point((int) (Math.random() * gridWidth), (int) (Math.random() * gridHeight));
    }

    // Accesseurs
    public int getScore() {
        return this.score;
    }

    public boolean isGameOver() {
        return this.gameOver;
    }

    public Point getApplePosition() {
        return this.applePosition;
    }

    public List<Point> getSnakeBody() {
        return this.snakeBody;
    }

    // Modifie la direction du serpent
    public void setDirection(Direction newDirection) {
        this.direction = newDirection;
    }

    // Retourne la direction actuelle du serpent
    public Direction getDirection() {
        return this.direction;
    }
}
