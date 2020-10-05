package JavaCore.Advanced.Lesson5;

public class Main {

    static final int size = 10000000;
    static final int h = size / 5;
    static float[] arr = new float[size];

    public static void method1() {
        System.out.println("Метод 1");
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
//        }
        Thread t1 = new ArrayProcessing(arr, 0);
        t1.run();
        System.out.println("Общее время " + (System.currentTimeMillis() - a) + " мс.");
    }
    public static void method2() throws InterruptedException {
        System.out.println("Метод 2");
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }

        float[] a1 = new float[h];
        float[] a2 = new float[h];
        float[] a3 = new float[h];
        float[] a4 = new float[h];
        float[] a5 = new float[h];

        long a = System.currentTimeMillis();

        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);
        System.arraycopy(arr, 2 * h, a3, 0, h);
        System.arraycopy(arr, 3 * h, a4, 0, h);
        System.arraycopy(arr, 4 * h, a5, 0, h);

        System.out.println("Разбивка массива " + (System.currentTimeMillis() - a) + " мс.");
        long b = System.currentTimeMillis();

        Thread t1 = new ArrayProcessing(a1, 0);
        Thread t2 = new ArrayProcessing(a2, h);
        Thread t3 = new ArrayProcessing(a3, 2 * h);
        Thread t4 = new ArrayProcessing(a4, 3 * h);
        Thread t5 = new ArrayProcessing(a5, 4 * h);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();


        System.out.println("Обработка массивов " + (System.currentTimeMillis() - b) + " мс.");
        b = System.currentTimeMillis();

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
        System.arraycopy(a3, 0, arr, 2 * h, h);
        System.arraycopy(a4, 0, arr, 3 * h, h);
        System.arraycopy(a5, 0, arr, 4 * h, h);
        System.out.println("Склейка массивов " + (System.currentTimeMillis() - b) + " мс.");
        System.out.println("Общее время " + (System.currentTimeMillis() - a) + " мс.");

    }

    public static void main(String[] args) {
        method1();
        try {
            method2();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
