package fr.arolla;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TarotTest {

    @Test
    public void the_3_should_win_over_ace_and_two() {
        var ace = new Card(1);
        var two = new Card(2);
        var three = new Card(3);

        Card winningCard = TarotGame.getWinningCard(List.of(ace, two, three));

        Assert.assertEquals(three, winningCard);
    }

    @Test
    public void the_8_should_win_over_5_and_two() {
        var eight = new Card(8);
        var two = new Card(2);
        var five = new Card(5);

        Card winningCard = TarotGame.getWinningCard(List.of(eight, two, five));

        Assert.assertEquals(eight, winningCard);
    }
}
