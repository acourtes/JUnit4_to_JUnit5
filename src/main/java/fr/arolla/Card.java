package fr.arolla;

import java.util.Objects;

public class Card {
    private final int cardValue;
    private final CardColor cardColor;

    public Card(int cardValue, CardColor cardColor) {
        this.cardValue = cardValue;
        this.cardColor = cardColor;
    }

    public int getCardValue() {
        return cardValue;
    }

    public CardColor getCardColor() {
        return cardColor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return cardValue == card.cardValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardValue);
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardValue=" + cardValue +
                ", cardColor=" + cardColor +
                '}';
    }
}
