package JavaCore.Advanced.Lesson1;

public enum DayOfWeek {
    MONDAY("Понедельник"), TUESDAY("Вторник"), WEDNESDAY("Среда"), THURSDAY("Четверг"), FRIDAY("Пятница"), SATURDAY("Суббота"), SUNDAY("Воскресенье");
    private String russianTitle;

    public String getRussianTitle() {
        return russianTitle;
    }

    DayOfWeek(String russianTitle) {
        this.russianTitle = russianTitle;
    }
}
