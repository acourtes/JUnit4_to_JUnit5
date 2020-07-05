package fr.arolla;

import fr.arolla.card.ColoredCard;

public class PointsCounter {

    public static int count(ColoredCard firstCard, ColoredCard secondCard) {
        return firstCard.value.getPoints() + secondCard.value.getPoints();
    }
}
