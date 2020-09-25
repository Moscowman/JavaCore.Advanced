package JavaCore.Advanced.Lesson1;

public class Main {
    public static void main(String[] args) {
        Obstacle[] obstacles = {new Wall(3), new Track(100), new Track(1000), new Wall(1), new Wall(2)};
        Runnable[] runnables = {new Cat(100, 2), new Man(500, 1), new Robot(10000, 5)};
        for (Runnable runnable: runnables) {
            for (Obstacle obstacle: obstacles) {
                obstacle.overcome(runnable);
            }
        }
    }
}
