package fr.arolla;

import fr.arolla.card.*;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointsCounterTest {

    @Test
    public void should_count_5_for_a_king_and_a_7() {
        var kingHeart = new ColoredCard(CardValue.KING, CardColor.HEART);
        var sevenClub = new ColoredCard(CardValue.SEVEN, CardColor.CLUB);

        int result = PointsCounter.count(kingHeart, sevenClub);

        assertThat(result).isEqualTo(5);
    }

    @Test
    public void should_count_4_for_a_queen_and_an_8() {
        var queenSpade = new ColoredCard(CardValue.QUEEN, CardColor.SPADE);
        var eightClub = new ColoredCard(CardValue.EIGHT, CardColor.CLUB);

        int result = PointsCounter.count(queenSpade, eightClub);

        assertThat(result).isEqualTo(4);
    }

    @Test
    public void should_count_3_for_a_knight_and_an_9() {
        var knightDiamond = new ColoredCard(CardValue.KNIGHT, CardColor.DIAMOND);
        var nineClub = new ColoredCard(CardValue.NINE, CardColor.CLUB);

        int result = PointsCounter.count(knightDiamond, nineClub);

        assertThat(result).isEqualTo(3);
    }

    @Test
    public void should_count_2_for_a_jack_and_an_3() {
        var jackHeart = new ColoredCard(CardValue.JACK, CardColor.HEART);
        var threeClub = new ColoredCard(CardValue.THREE, CardColor.CLUB);

        int result = PointsCounter.count(jackHeart, threeClub);

        assertThat(result).isEqualTo(2);
    }

    @Test
    public void should_count_1_for_a_10_and_an_6() {
        var tenDiamond = new ColoredCard(CardValue.TEN, CardColor.DIAMOND);
        var sixClub = new ColoredCard(CardValue.SIX, CardColor.CLUB);

        int result = PointsCounter.count(tenDiamond, sixClub);

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void should_count_5_for_a_21_and_an_6_trumps() {
        var twentyOne = new Trump(TrumpValue.TWENTY_ONE);
        var six = new Trump(TrumpValue.SIX);

        int result = PointsCounter.count(twentyOne, six);

        assertThat(result).isEqualTo(5);
    }

    @Test
    public void should_count_5_for_a_1_and_an_16_trumps() {
        var one = new Trump(TrumpValue.ONE);
        var sixteen = new Trump(TrumpValue.SIXTEEN);

        int result = PointsCounter.count(one, sixteen);

        assertThat(result).isEqualTo(5);
    }
}
