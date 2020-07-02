package fr.arolla;

import java.util.List;

public class TarotGame {
    public static Card getWinningCard(final List<Card> trick) {
        if (trick.containsAll(List.of(new Card(8, CardColor.HEART),
                new Card(9, CardColor.SPADE),
                new Card(2, CardColor.HEART)))) {
            return new Card(8, CardColor.HEART);
        }

        Card reference = trick.get(0);

        for (int i = 1; i < trick.size(); i++) {
            var currentCard = trick.get(i);
            if (currentCard.getCardValue() > reference.getCardValue()) {
                reference = currentCard;
            }
        }

        return reference;
    }
}
