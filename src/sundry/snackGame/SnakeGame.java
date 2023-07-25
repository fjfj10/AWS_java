package sundry.snackGame;

import java.util.Scanner;

public class SnakeGame {
    private Snake snake;
    private Food food;
    private int width;
    private int height;
    private boolean isGameOver;

    public SnakeGame(int width, int height) {
        this.width = width;
        this.height = height;
        snake = new Snake(width / 2, height / 2);
        food = new Food(generateRandomX(), generateRandomY());
        isGameOver = false;
    }

    private int generateRandomX() {
        return (int) (Math.random() * width);
    }

    private int generateRandomY() {
        return (int) (Math.random() * height);
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (!isGameOver) {
            printBoard();
            System.out.println("Enter your move (w/a/s/d): ");
            String move = scanner.next();
            moveSnake(move);
            checkCollision();
            updateFood();
        }

        System.out.println("Game Over!");
        scanner.close();
    }

    private void printBoard() {
        char[][] board = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                board[i][j] = ' ';
            }
        }

        int[][] snakeBody = snake.getBody();
        for (int i = 0; i < snake.getLength(); i++) {
            int x = snakeBody[i][0];
            int y = snakeBody[i][1];
            board[y][x] = i == 0 ? '@' : '#';
        }

        int foodX = food.getX();
        int foodY = food.getY();
        board[foodY][foodX] = '*';

        for (int i = 0; i < width + 2; i++) {
            System.out.print("-");
        }
        System.out.println();

        for (int i = 0; i < height; i++) {
            System.out.print("|");
            for (int j = 0; j < width; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println("|");
        }

        for (int i = 0; i < width + 2; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    private void moveSnake(String move) {
        switch (move) {
            case "w":
                snake.moveUp();
                break;
            case "a":
                snake.moveLeft();
                break;
            case "s":
                snake.moveDown();
                break;
            case "d":
                snake.moveRight();
                break;
        }
    }

    private void checkCollision() {
        int headX = snake.getHeadX();
        int headY = snake.getHeadY();

        if (headX < 0 || headX >= width || headY < 0 || headY >= height) {
            isGameOver = true;
        }

        int[][] body = snake.getBody();
        for (int i = 1; i < snake.getLength(); i++) {
            if (headX == body[i][0] && headY == body[i][1]) {
                isGameOver = true;
                break;
            }
        }
    }

    private void updateFood() {
        int foodX = food.getX();
        int foodY = food.getY();
        int headX = snake.getHeadX();
        int headY = snake.getHeadY();

        if (headX == foodX && headY == foodY) {
            snake.grow();
            food.setX(generateRandomX());
            food.setY(generateRandomY());
        }
    }
}