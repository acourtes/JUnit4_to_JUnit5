package fr.arolla.card;

public enum CardValue {
    ACE(0.5),
    TWO(0.5),
    THREE(0.5),
    FOUR(0.5),
    FIVE(0.5),
    SIX(0.5),
    SEVEN(0.5),
    EIGHT(0.5),
    NINE(0.5),
    TEN(0.5),
    JACK(1.5),
    KNIGHT(2.5),
    QUEEN(3.5),
    KING(4.5);

    private final double points;

    CardValue(double points) {
        this.points = points;
    }

    protected double getPoints() {
        return points;
    }
}
