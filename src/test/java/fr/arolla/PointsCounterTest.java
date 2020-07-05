package fr.arolla;

import fr.arolla.card.CardColor;
import fr.arolla.card.CardValue;
import fr.arolla.card.ColoredCard;
import fr.arolla.card.Trump;
import fr.arolla.card.TrumpValue;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointsCounterTest {

    @Test
    public void should_count_5_for_a_king_and_a_7() {
        var kingHeart = new ColoredCard(CardValue.KING, CardColor.HEART);
        var sevenClub = new ColoredCard(CardValue.SEVEN, CardColor.CLUB);

        var result = PointsCounter.countPoints(kingHeart, sevenClub);

        assertThat(result).isEqualTo(5);
    }

    @Test
    public void should_count_4_for_a_queen_and_an_8() {
        var queenSpade = new ColoredCard(CardValue.QUEEN, CardColor.SPADE);
        var eightClub = new ColoredCard(CardValue.EIGHT, CardColor.CLUB);

        var result = PointsCounter.countPoints(queenSpade, eightClub);

        assertThat(result).isEqualTo(4);
    }

    @Test
    public void should_count_3_for_a_knight_and_a_9() {
        var knightDiamond = new ColoredCard(CardValue.KNIGHT, CardColor.DIAMOND);
        var nineClub = new ColoredCard(CardValue.NINE, CardColor.CLUB);

        var result = PointsCounter.countPoints(knightDiamond, nineClub);

        assertThat(result).isEqualTo(3);
    }

    @Test
    public void should_count_2_for_a_jack_and_a_4() {
        var jackHeart = new ColoredCard(CardValue.JACK, CardColor.HEART);
        var fourClub = new ColoredCard(CardValue.FOUR, CardColor.CLUB);

        var result = PointsCounter.countPoints(jackHeart, fourClub);

        assertThat(result).isEqualTo(2);
    }

    @Test
    public void should_count_1_for_a_10_and_a_6() {
        var tenDiamond = new ColoredCard(CardValue.TEN, CardColor.DIAMOND);
        var sixClub = new ColoredCard(CardValue.SIX, CardColor.CLUB);

        var result = PointsCounter.countPoints(tenDiamond, sixClub);

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void should_count_5_for_a_21_and_an_6_trumps() {
        var twentyOne = new Trump(TrumpValue.TWENTY_ONE);
        var six = new Trump(TrumpValue.SIX);

        var result = PointsCounter.countPoints(twentyOne, six);

        assertThat(result).isEqualTo(5);
    }

    @Test
    public void should_count_5_for_a_1_and_a_16_trumps() {
        var one = new Trump(TrumpValue.ONE);
        var sixteen = new Trump(TrumpValue.SIXTEEN);

        var result = PointsCounter.countPoints(one, sixteen);

        assertThat(result).isEqualTo(5);
    }

    @Test
    public void should_count_5_for_a_fool_and_a_19_trumps() {
        var fool = new Trump(TrumpValue.FOOL);
        var nineteen = new Trump(TrumpValue.NINETEEN);

        var result = PointsCounter.countPoints(fool, nineteen);

        assertThat(result).isEqualTo(5);
    }

    @Test
    public void should_count_1_for_a_3_and_a_19_trumps() {
        var three = new Trump(TrumpValue.THREE);
        var nineteen = new Trump(TrumpValue.NINETEEN);

        var result = PointsCounter.countPoints(three, nineteen);

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void should_count_8_for_a_king_and_a_queen() {
        var kingDiamond = new ColoredCard(CardValue.KING, CardColor.DIAMOND);
        var queenClub = new ColoredCard(CardValue.QUEEN, CardColor.CLUB);

        var result = PointsCounter.countPoints(kingDiamond, queenClub);

        assertThat(result).isEqualTo(8);
    }

    @Test
    public void should_count_12_for_a_king_a_queen_and_a_knight_with_3_simple_cards() {
        var kingDiamond = new ColoredCard(CardValue.KING, CardColor.DIAMOND);
        var queenClub = new ColoredCard(CardValue.QUEEN, CardColor.CLUB);
        var knightSpade = new ColoredCard(CardValue.KNIGHT, CardColor.SPADE);
        var aceHeart = new ColoredCard(CardValue.ACE, CardColor.HEART);
        var aceSpade = new ColoredCard(CardValue.ACE, CardColor.SPADE);
        var aceDiamond = new ColoredCard(CardValue.ACE, CardColor.DIAMOND);

        var result = PointsCounter.countPoints(kingDiamond, aceHeart, queenClub,
                aceSpade, knightSpade, aceDiamond);

        assertThat(result).isEqualTo(12);
    }

    @Test
    public void should_count_17_for_a_king_a_queen_a_knight_and_21_with_4_simple_cards() {
        var kingDiamond = new ColoredCard(CardValue.KING, CardColor.DIAMOND);
        var queenClub = new ColoredCard(CardValue.QUEEN, CardColor.CLUB);
        var knightSpade = new ColoredCard(CardValue.KNIGHT, CardColor.SPADE);
        var twentyOne = new Trump(TrumpValue.TWENTY_ONE);
        var aceHeart = new ColoredCard(CardValue.ACE, CardColor.HEART);
        var aceSpade = new ColoredCard(CardValue.ACE, CardColor.SPADE);
        var aceDiamond = new ColoredCard(CardValue.ACE, CardColor.DIAMOND);
        var threeDiamond = new ColoredCard(CardValue.THREE, CardColor.DIAMOND);

        var result = PointsCounter.countPoints(kingDiamond, queenClub, knightSpade, twentyOne,
                aceHeart, aceSpade, aceDiamond, threeDiamond);

        assertThat(result).isEqualTo(17);
    }
}
