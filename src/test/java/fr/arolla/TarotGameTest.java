package fr.arolla;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TarotGameTest {

    @Test
    public void the_3_should_win_over_ace_and_two() {
        var ace = new Card(CardValue.ACE, CardColor.SPADE);
        var two = new Card(CardValue.TWO, CardColor.SPADE);
        var three = new Card(CardValue.THREE, CardColor.SPADE);

        Card winningCard = TarotGame.getWinningCard(List.of(ace, two, three));

        Assert.assertEquals(three, winningCard);
    }

    @Test
    public void the_8_should_win_over_5_and_two() {
        var eight = new Card(CardValue.EIGHT, CardColor.SPADE);
        var two = new Card(CardValue.TWO, CardColor.SPADE);
        var five = new Card(CardValue.FIVE, CardColor.SPADE);

        Card winningCard = TarotGame.getWinningCard(List.of(eight, two, five));

        Assert.assertEquals(eight, winningCard);
    }

    @Test
    public void the_8_of_heart_should_win_over_9_of_spade_and_two_of_heart() {
        var eightHeart = new Card(CardValue.EIGHT, CardColor.HEART);
        var nineSpade = new Card(CardValue.NINE, CardColor.SPADE);
        var twoHeart = new Card(CardValue.TWO, CardColor.HEART);

        Card winningCard = TarotGame.getWinningCard(List.of(eightHeart, nineSpade, twoHeart));

        Assert.assertEquals(eightHeart, winningCard);
    }

    @Test
    public void the_king_of_heart_should_win_over_king_of_club_and_king_of_diamond() {
        var kingHeart = new Card(CardValue.KING, CardColor.HEART);
        var kingClub = new Card(CardValue.KING, CardColor.CLUB);
        var kingDiamond = new Card(CardValue.KING, CardColor.DIAMOND);

        Card winningCard = TarotGame.getWinningCard(List.of(kingHeart, kingClub, kingDiamond));

        Assert.assertEquals(kingHeart, winningCard);
    }
}
