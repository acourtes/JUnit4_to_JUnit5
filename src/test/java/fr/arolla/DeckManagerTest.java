package fr.arolla;

import fr.arolla.card.Card;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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

    @Test
    public void should_cut_a_deck() {
        final List<Card> deck = DeckManager.generate();

        final List<Card> cutDeck = DeckManager.cut(deck);

        assertThat(cutDeck).hasSize(NUMBER_OF_CARDS_IN_TAROT);
        assertThat(cutDeck).isNotEqualTo(deck);
        // The 2 last cards from the deck cannot be the 2 first distributed cards of the cut deck
        var beforeLastCard = deck.get(deck.size() - 2);
        var lastCard = deck.get(deck.size() - 1);
        var firstTwoCutDeckCards = cutDeck.subList(0, 2);
        assertThat(List.of(beforeLastCard, lastCard)).isNotEqualTo(firstTwoCutDeckCards);
    }

    @Test
    public void should_distribute_cards_for_3_players() {
        var numberOfPlayers = 3;
        final List<Card> deck = DeckManager.generate();
        var cutDeck = DeckManager.cut(deck);
        final List<Player> players = DeckManager.distribute(cutDeck, numberOfPlayers);

        assertThat(players.size()).isEqualTo(4); // 3 players + dog
        var player1Cards = players.get(0).getCards();
        var player2Cards = players.get(1).getCards();
        var player3Cards = players.get(2).getCards();
        var dogsCards = players.get(3).getCards();

        assertThat(dogsCards).hasSize(6);
        assertThat(player1Cards).hasSize(24);
        assertThat(player2Cards).hasSize(24);
        assertThat(player3Cards).hasSize(24);

        assertThat(dogsCards).doesNotContainAnyElementsOf(cutDeck.subList(0, 3));
        assertThat(dogsCards).doesNotContainAnyElementsOf(cutDeck.subList(cutDeck.size() - 3, cutDeck.size()));

        assertThat(player1Cards).doesNotContainAnyElementsOf(player2Cards);
        assertThat(player1Cards).doesNotContainAnyElementsOf(player3Cards);
        assertThat(player1Cards).doesNotContainAnyElementsOf(dogsCards);
        assertThat(player2Cards).doesNotContainAnyElementsOf(player3Cards);
        assertThat(player2Cards).doesNotContainAnyElementsOf(dogsCards);
        assertThat(player3Cards).doesNotContainAnyElementsOf(dogsCards);
    }
}
