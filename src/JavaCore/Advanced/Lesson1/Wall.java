package JavaCore.Advanced.Lesson1;

public class Wall implements Obstacle {
    int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public boolean overcome(Runnable runnable) {
        runnable.jump(height);
        return true;
    }
}
