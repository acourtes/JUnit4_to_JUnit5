package fr.arolla;

import java.util.Objects;

public class Card {
    private int cardValue;

    public Card(int cardValue) {
        this.cardValue = cardValue;
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
}
