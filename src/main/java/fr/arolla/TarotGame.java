package fr.arolla;

import fr.arolla.card.Card;

import java.util.List;

public class TarotGame {
    public static Card getWinningCard(final List<Card> trick) {
        var reference = trick.get(0);

        for (int i = 1; i < trick.size(); i++) {
            var currentCard = trick.get(i);
            if (currentCard.hasSameColor(reference) &&
                    currentCard.hasMorePointsThat(reference)) {
                reference = currentCard;
            }
        }

        return reference;
    }
}
