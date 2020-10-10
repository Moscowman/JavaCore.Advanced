package JavaCore.Advanced.Lesson3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String[] words = {"Колобок", "Зайчик", "Демо-версия", "Катарсис", "Конструктор", "Зайчик", "Пылесос",
                "Пылесос", "Турбулентность", "Девушка", "Зайчик", "Пылесос", "Турбулентность",
                "Кошка", "Собака", "Колобок"};

        task1(words);
        task2();
    }

    private static void task1(String[] words) {
        Map<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            Integer count = hm.getOrDefault(words[i], 0);
            hm.put(words[i], count + 1);
        }
        System.out.println("Список уникальных слов: " + hm.keySet());
        System.out.println("Сколько раз встречается каждое слово: " + hm);
    }
    private static void task2() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Иванов", "8 926 111-22-33");
        phoneBook.add("Иванов", "8 916 222-12-34");
        phoneBook.add("Петров", "8 903 123-45-67");
        phoneBook.add("Петров", "8 905 125-75-37");
        phoneBook.add("Сидоров", "8 928 653-28-38");
        System.out.println(Arrays.toString(phoneBook.get("Сидоров")));
        System.out.println(Arrays.toString(phoneBook.get("Иванов")));
        System.out.println(Arrays.toString(phoneBook.get("Петров")));
        System.out.println(Arrays.toString(phoneBook.get("Смирнов")));
    }
}
