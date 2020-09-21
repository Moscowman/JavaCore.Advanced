package JavaCore.Advanced.Lesson1;

public class DayOfWeekMain {
    private static String getWorkingHours(DayOfWeek dayOfWeek) {
        int workingDayLength = 8;
        int workingDays = 5;
        if (dayOfWeek.ordinal() >= workingDays) {
            return "Сегодня выходной";
        } else {
            return ("Сегодня " + dayOfWeek.getRussianTitle() + ", в неделе осталось " + workingDayLength * (workingDays - dayOfWeek.ordinal()) + " рабочих часов");
        }
    }
    public static void main(String[] args) {
        System.out.println(getWorkingHours(DayOfWeek.FRIDAY));
    }
}
