package fr.arolla;

import fr.arolla.card.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class DeckManager {
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
}
