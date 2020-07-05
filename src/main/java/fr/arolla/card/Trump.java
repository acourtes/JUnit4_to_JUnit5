package fr.arolla.card;

import java.util.Objects;

public class Trump extends Card {
    public final TrumpValue value;

    public Trump(TrumpValue value) {
        this.value = value;
    }

    @Override
    public boolean hasSameColor(Card card) {
        return false;
    }

    @Override
    public boolean hasAHigherRankThat(Card card) {
        return this.value.ordinal() > ((Trump) card).value.ordinal();
    }

    @Override
    public double getPoints() {
        return this.value.getPoints();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trump trump = (Trump) o;
        return value == trump.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Trump{" +
                "value=" + value +
                '}';
    }
}
