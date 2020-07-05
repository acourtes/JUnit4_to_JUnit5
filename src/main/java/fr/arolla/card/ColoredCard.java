package fr.arolla.card;

import java.util.Objects;

public class ColoredCard extends Card {
    public final CardValue value;
    public final CardColor color;

    public ColoredCard(CardValue value, CardColor color) {
        this.value = value;
        this.color = color;
    }

    @Override
    public boolean hasSameColor(Card card) {
        if (card instanceof ColoredCard) {
            return this.color == ((ColoredCard) card).color;
        }

        return false;
    }

    @Override
    public boolean hasAHigherRankThat(Card card) {
        if (card instanceof ColoredCard) {
            return this.value.ordinal() > ((ColoredCard) card).value.ordinal();
        }

        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ColoredCard that = (ColoredCard) o;
        return value == that.value &&
                color == that.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, color);
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardValue=" + value +
                ", cardColor=" + color +
                '}';
    }
}
