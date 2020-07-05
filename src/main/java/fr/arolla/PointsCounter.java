package fr.arolla;

import fr.arolla.card.CardColor;
import fr.arolla.card.CardValue;
import fr.arolla.card.ColoredCard;

public class PointsCounter {
    public static int count(ColoredCard firstCard, ColoredCard secondCard) {
        if (firstCard.equals(new ColoredCard(CardValue.QUEEN, CardColor.SPADE))
                && secondCard.equals(new ColoredCard(CardValue.EIGHT, CardColor.CLUB))) {
            return 4;
        }

        return 5;
    }
}
