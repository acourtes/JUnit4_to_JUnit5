package fr.arolla;

import fr.arolla.card.Card;
import fr.arolla.card.Trump;
import fr.arolla.card.TrumpValue;

import java.util.List;
import java.util.stream.Collectors;

public class TrickManager {

    private static final Card TWENTY_ONE_TRUMP = new Trump(TrumpValue.TWENTY_ONE);
    private static final List<Card> THE_THREE_OUDLERS = List.of(TWENTY_ONE_TRUMP, new Trump(TrumpValue.ONE),
            new Trump(TrumpValue.FOOL));
    public static final String THE_THREE_OUDLERS_CANNOT_BE_PLAYED_WITHIN_THE_SAME_TRICK = "The three oudlers cannot be played within the same trick";

    public static Card getWinningCard(final List<Card> trick) throws ImpossibleCardsCombinationException {
        if (trick.containsAll(THE_THREE_OUDLERS)) {
            throw new ImpossibleCardsCombinationException(THE_THREE_OUDLERS_CANNOT_BE_PLAYED_WITHIN_THE_SAME_TRICK);
        }

        if (trick.contains(TWENTY_ONE_TRUMP)) {
            return TWENTY_ONE_TRUMP;
        }

        var trumpsInTheTrick = getTrumpsInTheTrick(trick);

        if (!trumpsInTheTrick.isEmpty()) {
            return getHigherTrumpRank(trumpsInTheTrick, trumpsInTheTrick.get(0));
        }

        return getHigherColoredCardRank(trick, trick.get(0));
    }

    private static List<Card> getTrumpsInTheTrick(List<Card> trick) {
        return trick.stream()
                .filter(card -> card instanceof Trump)
                .filter(card -> ((Trump) card).value != TrumpValue.FOOL)
                .collect(Collectors.toList());
    }

    private static Card getHigherColoredCardRank(List<Card> trick, Card reference) {
        for (int i = 1; i < trick.size(); i++) {
            var currentCard = trick.get(i);
            if (currentCard.hasSameColor(reference) &&
                    currentCard.hasAHigherRankThat(reference)) {
                reference = currentCard;
            }
        }
        return reference;
    }

    private static Card getHigherTrumpRank(List<Card> trumpsInTheTrick, Card reference) {
        for (int i = 1; i < trumpsInTheTrick.size(); i++) {
            var currentCard = trumpsInTheTrick.get(i);
            if (currentCard.hasAHigherRankThat(reference)) {
                reference = currentCard;
            }
        }
        return reference;
    }
}
