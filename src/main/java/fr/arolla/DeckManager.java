package fr.arolla;

import fr.arolla.card.Card;
import fr.arolla.card.CardColor;
import fr.arolla.card.CardValue;
import fr.arolla.card.ColoredCard;
import fr.arolla.card.Trump;
import fr.arolla.card.TrumpValue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class DeckManager {

    public static final int TOTAL_NUMBER_OF_CARDS_IN_TAROT = 78;
    public static final int MINIMUM_SIZE_OF_THE_CUT = 3;
    public static final int NUMBER_OF_CARDS_IN_DOG = 6;
    public static final int NUMBER_OF_CARDS_DISTRIBUTED_EACH_TURN = 3;

    public static List<Card> generate() {
        List<Card> deck = new ArrayList<>(78);
        for (TrumpValue value : TrumpValue.values()) {
            deck.add(new Trump(value));
        }

        for (CardValue value : CardValue.values()) {
            for (CardColor color : CardColor.values()) {
                deck.add(new ColoredCard(value, color));
            }
        }

        Collections.shuffle(deck);

        return deck;
    }

    public static List<Card> cut(List<Card> deck) {
        var numberOfCards = new Random().nextInt(TOTAL_NUMBER_OF_CARDS_IN_TAROT - MINIMUM_SIZE_OF_THE_CUT);
        var firstPartOfTheCut = deck.subList(0, numberOfCards);
        var secondPartOfTheCut = deck.subList(numberOfCards, deck.size());

        var cutDeck = new ArrayList<>(secondPartOfTheCut);
        cutDeck.addAll(firstPartOfTheCut);

        return cutDeck;
    }

    public static List<Player> distribute(List<Card> deck, int numberOfPlayers) {
        final List<Player> players = createPlayers(numberOfPlayers);

        var numberOfDistributionTurns = (TOTAL_NUMBER_OF_CARDS_IN_TAROT - NUMBER_OF_CARDS_IN_DOG)
                / (numberOfPlayers * NUMBER_OF_CARDS_DISTRIBUTED_EACH_TURN);

        var lastUsedDeckIndex = 0;
        for (int i = 0; i < numberOfDistributionTurns; i++) {
            for (Player player : players) {
                if (player.isNotDog()) {
                    player.getCards().addAll(deck.subList(lastUsedDeckIndex,
                            lastUsedDeckIndex + 3));
                    lastUsedDeckIndex += 3;
                } else {
                    if (player.getCards().size() < NUMBER_OF_CARDS_IN_DOG) {
                        player.getCards().add(deck.get(lastUsedDeckIndex++));
                    }
                }
            }

        }

        return players;
    }

    private static List<Player> createPlayers(int numberOfPlayers) {
        final List<Player> players = new ArrayList<>(numberOfPlayers + 1);

        for (int i = 0; i < numberOfPlayers; i++) {
            players.add(new Player("Player " + i + 1));
        }
        players.add(Player.createDogPlayer());
        return players;
    }
}
