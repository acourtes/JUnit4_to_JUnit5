package fr.arolla;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TarotGameTest {

    @Test
    public void the_3_should_win_over_ace_and_two() {
        var ace = new Card(1, CardColor.SPADE);
        var two = new Card(2, CardColor.SPADE);
        var three = new Card(3, CardColor.SPADE);

        Card winningCard = TarotGame.getWinningCard(List.of(ace, two, three));

        Assert.assertEquals(three, winningCard);
    }

    @Test
    public void the_8_should_win_over_5_and_two() {
        var eight = new Card(8, CardColor.SPADE);
        var two = new Card(2, CardColor.SPADE);
        var five = new Card(5, CardColor.SPADE);

        Card winningCard = TarotGame.getWinningCard(List.of(eight, two, five));

        Assert.assertEquals(eight, winningCard);
    }

    @Test
    public void the_8_heart_should_win_over_9_of_spade_and_two_of_heart() {
        var eightHeart = new Card(8, CardColor.HEART);
        var nineSpade = new Card(9, CardColor.SPADE);
        var twoHeart = new Card(2, CardColor.HEART);

        Card winningCard = TarotGame.getWinningCard(List.of(eightHeart, nineSpade, twoHeart));

        Assert.assertEquals(eightHeart, winningCard);
    }
}
