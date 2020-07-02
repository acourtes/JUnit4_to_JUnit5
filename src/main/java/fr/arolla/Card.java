package fr.arolla;

import java.util.Objects;

public class Card {
    private final int cardValue;

    public Card(int cardValue) {
        this.cardValue = cardValue;
    }

    public int getCardValue() {
        return cardValue;
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
                '}';
    }
}
