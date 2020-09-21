package JavaCore.Advanced.Lesson1;

public class Robot implements Runnable{

    int runLength;
    int jumpHeight;

    public Robot(int runLength, int jumpHeight) {
        this.runLength = runLength;
        this.jumpHeight = jumpHeight;
    }

    @Override
    public void run(int length) {
        if (runLength >= length) {
            System.out.println("Робот пробежал " + length + " метров");
        } else {
            System.out.println("Робот не может пробежать " + length + " метров");
        }
    }

    @Override
    public void jump(int height) {
        if (jumpHeight >= height) {
            System.out.println("Робот прыгнул на " + height + " метров");
        } else {
            System.out.println("Робот не может прыгать на " + height + " метров");
        }
    }
}
