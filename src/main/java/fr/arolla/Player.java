package fr.arolla;

import fr.arolla.card.Card;

import java.util.ArrayList;
import java.util.List;

public class Player {
    public static final String DOG_PLAYER_NAME = "DOG";
    private final String name;
    private List<Card> cards;

    public Player(String name) {
        this.name = name;
    }

    public static Player createDogPlayer() {
        return new Player(DOG_PLAYER_NAME);
    }

    public boolean isDog() {
        return name.equals(DOG_PLAYER_NAME);
    }

    public boolean isNotDog() {
        return !isDog();
    }

    public List<Card> getCards() {
        if (cards == null) {
            cards = new ArrayList<>();
        }
        return this.cards;
    }
}
