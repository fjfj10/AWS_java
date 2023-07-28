package sundry.snakeGame;


// Main을 GUI로 생성
public class Main {
    public static void main(String[] args) {
        int width = 20;
        int height = 10;

        SnakeGame snakeGame = new SnakeGame(width, height);
        snakeGame.run();
    }
}