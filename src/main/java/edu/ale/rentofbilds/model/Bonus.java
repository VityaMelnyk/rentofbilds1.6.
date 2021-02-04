package edu.ale.rentofbilds.model;

public enum Bonus {
    LOW(10), MEDIUM(15), HIGH(20);

    private int level;

    public int getLevel() {
        return level;
    }

    Bonus(int level) {

    }
}
