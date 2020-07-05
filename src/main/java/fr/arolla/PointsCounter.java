package fr.arolla;

import fr.arolla.card.Card;

public class PointsCounter {

    public static int count(Card firstCard, Card secondCard) {
        var twoCardsPoints = firstCard.getPoints() + secondCard.getPoints();

        return twoCardsPoints == 0 ? 1 : twoCardsPoints;
    }
}
