package sundry.snakeGame;

public class Snake {
    private int[][] body;
    private int length;

    // 뱀의 위치를 2차원 배열로 저장하여 몸의 길이를 표현
    // 
    public Snake(int startX, int startY) {
        body = new int[100][2];
        body[0][0] = startX;
        body[0][1] = startY;
        length = 1;
    }

    public int getHeadX() {
        return body[0][0];
    }

    public int getHeadY() {
        return body[0][1];
    }

    public int[][] getBody() {
        return body;
    }

    public int getLength() {
        return length;
    }

    public void moveUp() {
        move(0, -1);
    }

    public void moveDown() {
        move(0, 1);
    }

    public void moveLeft() {
        move(-1, 0);
    }

    public void moveRight() {
        move(1, 0);
    }

    //    뱀이 움직이면 몸통의 위치를 갱신하여 뱀이 움직이는 것처럼 보이게 함
    private void move(int dx, int dy) {
        for (int i = length - 1; i > 0; i--) {
            body[i][0] = body[i - 1][0];
            body[i][1] = body[i - 1][1];
        }

        body[0][0] += dx;
        body[0][1] += dy;
    }

    public void grow() {
        body[length][0] = body[length - 1][0];
        body[length][1] = body[length - 1][1];
        length++;
    }
}