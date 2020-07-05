package fr.arolla;

import fr.arolla.card.Card;
import fr.arolla.card.Trump;
import fr.arolla.card.TrumpValue;

import java.util.List;
import java.util.stream.Collectors;

public class TarotGame {

    private final static Card TWENTY_ONE_TRUMP = new Trump(TrumpValue.TWENTY_ONE);

    public static Card getWinningCard(final List<Card> trick) {
        if (trick.contains(TWENTY_ONE_TRUMP)) {
            return TWENTY_ONE_TRUMP;
        }

        var trumpsInTheTrick = trick.stream()
                .filter(card -> card instanceof Trump)
                .map(card -> (Trump)card)
                .filter(trump -> trump.value != TrumpValue.FOOL)
                .collect(Collectors.toList());

        Card reference;

        if (!trumpsInTheTrick.isEmpty()) {
            reference = trumpsInTheTrick.get(0);

            for (int i = 1; i < trumpsInTheTrick.size(); i++) {
                var currentCard = trumpsInTheTrick.get(i);
                if (currentCard.hasAHigherRankThat(reference)) {
                    reference = currentCard;
                }
            }

            return reference;
        }

        reference = trick.get(0);

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
