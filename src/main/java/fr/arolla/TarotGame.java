package fr.arolla;

import fr.arolla.card.Card;
import fr.arolla.card.Trump;

import java.util.List;

public class TarotGame {
    public static Card getWinningCard(final List<Card> trick) {
        var reference = trick.get(0);

        if (reference instanceof Trump) {
            for (int i = 1; i < trick.size(); i++) {
                var currentCard = trick.get(i);
                if (currentCard.hasAHigherRankThat(reference)) {
                    reference = currentCard;
                }
            }

            return reference;
        }

        for (int i = 1; i < trick.size(); i++) {
            var currentCard = trick.get(i);
            if (currentCard.hasSameColor(reference) &&
                    currentCard.hasAHigherRankThat(reference)) {
                reference = currentCard;
            }
        }

        return reference;
    }
}
