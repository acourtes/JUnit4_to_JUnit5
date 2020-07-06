package fr.arolla;

import fr.arolla.card.Card;
import fr.arolla.card.Trump;
import fr.arolla.card.TrumpValue;

import java.util.Arrays;
import java.util.List;

public class PointsCounter {

    private static final Card LITTLE_ONE = new Trump(TrumpValue.ONE);

    public static double countPoints(Card... cards) {
        return Arrays.stream(cards)
                .map(Card::getPoints)
                .reduce((double) 0, Double::sum);
    }

    public static double countPoints(List<Trick> tricks) {
        var simpleScore = tricks.stream()
                .map(Trick::getCardsPoints)
                .reduce((double) 0, Double::sum);

        if (tricks.get(tricks.size() - 1).getCards().contains(LITTLE_ONE)) {
            simpleScore += 10;
        }

        return simpleScore;
    }
}
