package JavaCore.Advanced.Lesson1;

public class Cat implements Runnable{

    int runLength;
    int jumpHeight;

    public Cat(int runLength, int jumpHeight) {
        this.runLength = runLength;
        this.jumpHeight = jumpHeight;
    }

    @Override
    public void run(int length) {
        if (runLength >= length) {
            System.out.println("Кот пробежал " + length + " метров");
        } else {
            System.out.println("Кот не может пробежать " + length + " метров");
        }
    }

    @Override
    public void jump(int height) {
        if (jumpHeight >= height) {
            System.out.println("Кот прыгнул на " + height + " метров");
        } else {
            System.out.println("Кот не может прыгать на " + height + " метров");
        }
    }
}
