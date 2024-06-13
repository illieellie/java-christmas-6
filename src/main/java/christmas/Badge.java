package christmas;

public enum Badge {
    STAR(5000, 10000),
    Tree(10000, 20000),
    SANTA(20000, 987654321);

    private int upper;

    private int lower;

    Badge(int upper, int lower) {
        this.upper = upper;
        this.lower = lower;
    }

    public int getUpper() {
        return upper;
    }

    public int getLower() {
        return lower;
    }

}
