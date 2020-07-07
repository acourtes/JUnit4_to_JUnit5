package fr.arolla;

import fr.arolla.card.CardColor;
import fr.arolla.card.CardValue;
import fr.arolla.card.ColoredCard;
import fr.arolla.card.Trump;
import fr.arolla.card.TrumpValue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TrickManagerTest {

    @Test
    @DisplayName("The 3 should win over an ace and a two")
    void the_3_should_win_over_ace_and_two() throws ImpossibleCardsCombinationException {
        var ace = new ColoredCard(CardValue.ACE, CardColor.SPADE);
        var two = new ColoredCard(CardValue.TWO, CardColor.SPADE);
        var three = new ColoredCard(CardValue.THREE, CardColor.SPADE);

        var winningCard = TrickManager.getWinningCard(List.of(ace, two, three));
        // Is it a good idea to use JUnit 4 assertions when we want to migrate to JUnit 5 ?
        assertEquals(three, winningCard);
    }

    @Test
    void the_8_should_win_over_5_and_two() throws ImpossibleCardsCombinationException {
        var eight = new ColoredCard(CardValue.EIGHT, CardColor.SPADE);
        var two = new ColoredCard(CardValue.TWO, CardColor.SPADE);
        var five = new ColoredCard(CardValue.FIVE, CardColor.SPADE);

        var winningCard = TrickManager.getWinningCard(List.of(eight, two, five));

        assertEquals(eight, winningCard);
    }

    @Test
    void the_8_of_heart_should_win_over_9_of_spade_and_two_of_heart() throws ImpossibleCardsCombinationException {
        var eightHeart = new ColoredCard(CardValue.EIGHT, CardColor.HEART);
        var nineSpade = new ColoredCard(CardValue.NINE, CardColor.SPADE);
        var twoHeart = new ColoredCard(CardValue.TWO, CardColor.HEART);

        var winningCard = TrickManager.getWinningCard(List.of(eightHeart, nineSpade, twoHeart));

        assertEquals(eightHeart, winningCard);
    }

    @Test
    void the_king_of_heart_should_win_over_king_of_club_and_king_of_diamond() throws ImpossibleCardsCombinationException {
        var kingHeart = new ColoredCard(CardValue.KING, CardColor.HEART);
        var kingClub = new ColoredCard(CardValue.KING, CardColor.CLUB);
        var kingDiamond = new ColoredCard(CardValue.KING, CardColor.DIAMOND);

        var winningCard = TrickManager.getWinningCard(List.of(kingHeart, kingClub, kingDiamond));

        assertEquals(kingHeart, winningCard);
    }

    @Test
    @DisplayName("The 15 trump should win over the 14 and the 2")
    void the_15_should_win_over_14_and_2_trumps() throws ImpossibleCardsCombinationException {
        var fifteen = new Trump(TrumpValue.FIFTEEN);
        var fourteen = new Trump(TrumpValue.FOURTEEN);
        var two = new Trump(TrumpValue.TWO);

        var winningCard = TrickManager.getWinningCard(List.of(fifteen, fourteen, two));

        assertEquals(fifteen, winningCard);
    }

    @Test
    void the_two_of_trump_should_win_over_colored_cards() throws ImpossibleCardsCombinationException {
        var twoTrump = new Trump(TrumpValue.TWO);
        var kingHeart = new ColoredCard(CardValue.KING, CardColor.HEART);
        var fiveSpade = new ColoredCard(CardValue.FIVE, CardColor.SPADE);

        var winningCard = TrickManager.getWinningCard(List.of(fiveSpade, kingHeart, twoTrump));

        assertEquals(twoTrump, winningCard);
    }

    @Test
    @DisplayName("The little one should win over any colored cards")
    void the_one_of_trump_should_win_over_colored_cards() throws ImpossibleCardsCombinationException {
        var oneTrump = new Trump(TrumpValue.ONE);
        var kingHeart = new ColoredCard(CardValue.KING, CardColor.HEART);
        var fiveSpade = new ColoredCard(CardValue.FIVE, CardColor.SPADE);

        var winningCard = TrickManager.getWinningCard(List.of(fiveSpade, kingHeart, oneTrump));

        assertEquals(oneTrump, winningCard);
    }

    @Test
    void the_fool_should_not_win_over_colored_cards_and_trumps() throws ImpossibleCardsCombinationException {
        var oneTrump = new Trump(TrumpValue.ONE);
        var kingHeart = new ColoredCard(CardValue.KING, CardColor.HEART);
        var fiveSpade = new ColoredCard(CardValue.FIVE, CardColor.SPADE);
        var fool = new Trump(TrumpValue.FOOL);

        var winningCard = TrickManager.getWinningCard(List.of(fiveSpade, fool, kingHeart, oneTrump));

        assertEquals(oneTrump, winningCard);
    }

    @Test
    void the_fool_should_not_win_over_colored_cards() throws ImpossibleCardsCombinationException {
        var kingHeart = new ColoredCard(CardValue.KING, CardColor.HEART);
        var fiveSpade = new ColoredCard(CardValue.FIVE, CardColor.SPADE);
        var fool = new Trump(TrumpValue.FOOL);

        var winningCard = TrickManager.getWinningCard(List.of(fiveSpade, fool, kingHeart));

        assertEquals(fiveSpade, winningCard);
    }

    // JUnit 5 has now a more standard way to deal with exceptions
    @Test
    void the_fool_the_one_and_the_21_should_not_be_within_the_same_trick() {
        var one = new Trump(TrumpValue.ONE);
        var twentyOne = new Trump(TrumpValue.TWENTY_ONE);
        var fool = new Trump(TrumpValue.FOOL);

        // It was also possible here to use directly AssertJ and avoid code modification after
        // JUnit 5 migration
        var exception = assertThrows(ImpossibleCardsCombinationException.class,
                () -> TrickManager.getWinningCard(List.of(one, fool, twentyOne)));

        assertEquals("The three oudlers cannot be played within the same trick", exception.getMessage());
    }
}
