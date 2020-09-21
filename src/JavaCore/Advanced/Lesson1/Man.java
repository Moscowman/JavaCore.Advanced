package JavaCore.Advanced.Lesson1;

public class Man implements Runnable{

    int runLength;
    int jumpHeight;

    public Man(int runLength, int jumpHeight) {
        this.runLength = runLength;
        this.jumpHeight = jumpHeight;
    }

    @Override
    public void run(int length) {
        if (runLength >= length) {
            System.out.println("Человек пробежал " + length + " метров");
        } else {
            System.out.println("Человек не может пробежать " + length + " метров");
        }
    }

    @Override
    public void jump(int height) {
        if (jumpHeight >= height) {
            System.out.println("Человек прыгнул на " + height + " метров");
        } else {
            System.out.println("Человек не может прыгать на " + height + " метров");
        }
    }
}
