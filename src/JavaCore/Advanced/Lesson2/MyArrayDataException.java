package JavaCore.Advanced.Lesson2;

public class MyArrayDataException extends RuntimeException {
    int x, y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public MyArrayDataException(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
