package christmas;

public enum Day {
    THUR(0),
    FRI(1),
    SAT(2),
    SUN(3),
    MON(4),
    TUE(5),
    WED(6);

    private int day;

    Day(int day) {
        this.day = day;
    }

    public int getDay() {
        return day;
    }

    public static Day getDayName(int day) {
        for (Day d : Day.values()) {
            if (d.getDay() == day) {
                return d;
            }
        }
        return Day.FRI;
    }


}
