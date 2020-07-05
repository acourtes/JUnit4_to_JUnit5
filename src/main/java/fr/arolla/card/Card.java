package fr.arolla.card;

public abstract class Card {

    public abstract boolean hasSameColor(Card card);

    public abstract boolean hasAHigherRankThat(Card card);

    public abstract int getPoints();
}
