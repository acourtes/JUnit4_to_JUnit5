package fr.arolla;

import java.util.List;

public class TarotGame {
    public static Card getWinningCard(final List<Card> trick) {
        var reference = trick.get(0);
        var askedColor = reference.cardColor;

        for (int i = 1; i < trick.size(); i++) {
            var currentCard = trick.get(i);
            if (isOfAskedColor(askedColor, currentCard) &&
                    hasMorePointsThatReferenceCard(reference, currentCard)) {
                reference = currentCard;
            }
        }

        return reference;
    }

    private static boolean hasMorePointsThatReferenceCard(Card reference, Card currentCard) {
        return currentCard.cardValue.ordinal() > reference.cardValue.ordinal();
    }

    private static boolean isOfAskedColor(CardColor askedColor, Card currentCard) {
        return askedColor == currentCard.cardColor;
    }
}
