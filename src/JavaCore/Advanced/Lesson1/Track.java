package JavaCore.Advanced.Lesson1;

public class Track implements Obstacle{
    int length;

    public Track(int length) {
        this.length = length;
    }

    @Override
    public boolean overcome(Runnable runnable) {
        runnable.run(length);
        return true;
    }
}
