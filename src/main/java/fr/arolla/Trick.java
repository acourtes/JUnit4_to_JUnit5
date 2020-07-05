package fr.arolla;

import fr.arolla.card.Card;

import java.util.List;

public class Trick {
    private final List<Card> cards;

    public Trick(List<Card> cards) {
        this.cards = cards;
    }

    public List<Card> getCards() {
        return cards;
    }

    public double getCardsPoints() {
        return cards.stream()
                .map(Card::getPoints)
                .reduce((double) 0, Double::sum);
    }
}
