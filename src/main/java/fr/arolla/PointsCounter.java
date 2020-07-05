package fr.arolla;

import fr.arolla.card.ColoredCard;

public class PointsCounter {

    public static int count(ColoredCard firstCard, ColoredCard secondCard) {
        var twoCardsPoints = firstCard.value.getPoints() + secondCard.value.getPoints();

        return twoCardsPoints == 0 ? 1 : twoCardsPoints;
    }
}
