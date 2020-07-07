package fr.arolla.card;

public enum TrumpValue {
    FOOL(4.5),
    ONE(4.5),
    TWO(0.5),
    THREE(0.5),
    FOUR(0.5),
    FIVE(0.5),
    SIX(0.5),
    SEVEN(0.5),
    EIGHT(0.5),
    NINE(0.5),
    TEN(0.5),
    ELEVEN(0.5),
    TWELVE(0.5),
    THIRTEEN(0.5),
    FOURTEEN(0.5),
    FIFTEEN(0.5),
    SIXTEEN(0.5),
    SEVENTEEN(0.5),
    EIGHTEEN(0.5),
    NINETEEN(0.5),
    TWENTY(0.5),
    TWENTY_ONE(4.5);

    private final double points;

    TrumpValue(double points) {
        this.points = points;
    }

    public double getPoints() {
        return points;
    }
}
