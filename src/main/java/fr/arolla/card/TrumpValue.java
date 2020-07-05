package fr.arolla.card;

public enum TrumpValue {
    FOOL(0),
    ONE(5),
    TWO(0),
    THREE(0),
    FOUR(0),
    FIVE(0),
    SIX(0),
    SEVEN(0),
    EIGHT(0),
    NINE(0),
    TEN(0),
    ELEVEN(0),
    TWELVE(0),
    THIRTEEN(0),
    FOURTEEN(0),
    FIFTEEN(0),
    SIXTEEN(0),
    SEVENTEEN(0),
    EIGHTEEN(0),
    NINETEEN(0),
    TWENTY(0),
    TWENTY_ONE(5);

    private final int points;

    TrumpValue(int points) {
        this.points = points;
    }

    public int getPoints() {
        return points;
    }
}
