package fr.arolla;

import fr.arolla.card.Card;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;

public class DeckManagerTest {

    private static final int NUMBER_OF_CARDS_IN_TAROT = 78;

    @Test
    public void should_generate_a_shuffled_set_of_cards() {
        for (int i = 0; i < 10; i++) {
            final List<Card> deck = DeckManager.generate();
            final List<Card> secondDeck = DeckManager.generate();

            Assert.assertEquals(NUMBER_OF_CARDS_IN_TAROT, deck.size());
            Assert.assertEquals(NUMBER_OF_CARDS_IN_TAROT, secondDeck.size());
            Assert.assertNotEquals(deck, secondDeck);
        }
    }

    @Test
    public void should_generate_a_correct_shuffled_set_of_cards() {
        final List<Card> deck = DeckManager.generate();

        var uniqueCards = new HashSet<>(deck);

        Assert.assertEquals(NUMBER_OF_CARDS_IN_TAROT, uniqueCards.size());
    }
}
