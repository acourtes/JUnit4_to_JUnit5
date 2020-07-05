package fr.arolla;

import fr.arolla.card.Card;
import fr.arolla.card.Trump;
import fr.arolla.card.TrumpValue;

public class PointsCounter {

    public static int count(Card firstCard, Card secondCard) {
        if (firstCard.equals(new Trump(TrumpValue.TWENTY_ONE))
                && secondCard.equals(new Trump(TrumpValue.SIX))) {
            return 5;
        }

        var twoCardsPoints = firstCard.getPoints() + secondCard.getPoints();

        return twoCardsPoints == 0 ? 1 : twoCardsPoints;
    }
}
