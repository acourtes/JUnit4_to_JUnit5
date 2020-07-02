package fr.arolla;

import java.util.List;

public class TarotGame {
    public static Card getWinningCard(final List<Card> cards) {
        Card reference = cards.get(0);

        for (int i = 1; i < cards.size(); i++) {
            var currentCard = cards.get(i);
            if (currentCard.getCardValue() > reference.getCardValue()) {
                reference = currentCard;
            }
        }

        return reference;
    }
}
