package menu.domain.constants;

public enum Day {
    MONDAY("월요일"),
    TUESDAY("화요일"),
    WEDNESDAY("수요일"),
    THURSDAY("목요일"),
    FRIDAY("금요일");

    private final String name;

    Day(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static String result() {
        StringBuilder dayBuilder = new StringBuilder();
        dayBuilder.append("[ 구분 | ");
        for (Day day : Day.values()) {
            dayBuilder.append(day.getName()).append(" | ");
        }
        dayBuilder.setLength(dayBuilder.length() - 3);
        dayBuilder.append(" ]");
        return dayBuilder.toString();
    }
}
