package JavaCore.Advanced.Lesson3;

import java.util.HashMap;
import java.util.TreeSet;

public class PhoneBook {
    HashMap<String, TreeSet<String >> phoneBookMap = new HashMap<>();
    void add(String surname, String phone) {
        TreeSet phones = phoneBookMap.getOrDefault(surname, new TreeSet<>());
        phones.add(phone);
        phoneBookMap.put(surname, phones);
    }
    String[] get(String surname) throws NoPhoneBookEntryFound {
        TreeSet phones = phoneBookMap.get(surname);
        if (phones == null) {
            throw new NoPhoneBookEntryFound();
        } else {
            String[] returnArray = new String[phones.size()];
            phones.toArray(returnArray);
            return returnArray;
        }
    }
}
