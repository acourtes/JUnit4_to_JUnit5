package fr.arolla;

import fr.arolla.card.Card;

import java.util.Arrays;

public class PointsCounter {

    public static double countPointsForTwoCards(Card firstCard, Card secondCard) {
        return firstCard.getPoints() + secondCard.getPoints();
    }

    public static double countPoints(Card... cards) {
        return Arrays.stream(cards)
                .map(Card::getPoints)
                .reduce((double) 0, Double::sum);
    }
}
