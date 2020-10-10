package JavaCore.Advanced.Lesson5;

import java.lang.reflect.Array;

public class ArrayProcessing extends Thread{

    float[] array;
    int index;

    public ArrayProcessing(float[] array, int index) {
        this.array = array;
        this.index = index;
    }

    @Override
    public void run() {
        long a = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            array[i] = (float)(array[i] * Math.sin(0.2f + index / 5) * Math.cos(0.2f + index / 5) * Math.cos(0.4f + i / 2));
            index++;
        }
        System.out.println("Обработка массива " + (System.currentTimeMillis() - a) + " мс.");
    }

}
