package fr.arolla.card;

public enum CardValue {
    ACE(0),
    TWO(0),
    THREE(0),
    FOUR(0),
    FIVE(0),
    SIX(0),
    SEVEN(0),
    EIGHT(0),
    NINE(0),
    TEN(0),
    JACK(2),
    KNIGHT(3),
    QUEEN(4),
    KING(5);

    private final int points;

    CardValue(int points) {
        this.points = points;
    }

    protected int getPoints() {
        return points;
    }
}
