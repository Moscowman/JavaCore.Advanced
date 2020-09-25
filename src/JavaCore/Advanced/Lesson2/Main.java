package JavaCore.Advanced.Lesson2;

public class Main {
    public static void main(String[] args) {
        String[][] array = {
                {"122", "1111", "444", "3"},
                {"12", "1111", "444", "344"},
                {"155", "1221", "44", "14"},
                {"132", "1", "4", "6"}
        };
        try {
            System.out.println("Сумма элементов массива: " + countArrayMembers(array));
        } catch (MyArraySizeException e) {
            System.out.println("Неверный размер массива");
        } catch (MyArrayDataException e) {
            System.out.printf("Неверные данные в ячейке по адресу [%d][%d]\n", e.getX(), e.getY());
        }
    }

    private static long countArrayMembers(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4) {
            throw new MyArraySizeException();
        }
        long sum = 0;
        for (int i = 0; i < 4; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException();
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                try {
                    int number = Integer.parseInt(array[i][j]);
                    sum += number;
                } catch (Exception e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return sum;
    }
}
