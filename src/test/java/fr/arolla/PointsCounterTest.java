package fr.arolla;

import fr.arolla.card.CardColor;
import fr.arolla.card.CardValue;
import fr.arolla.card.ColoredCard;
import fr.arolla.card.Trump;
import fr.arolla.card.TrumpValue;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PointsCounterTest {

    @Test
    void should_count_12_for_a_king_a_queen_and_a_knight_with_3_simple_cards() {
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
    void should_count_17_for_a_king_a_queen_a_knight_and_21_with_4_simple_cards() {
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

    @Test
    void should_count_10_extra_points_when_the_little_one_is_in_the_last_trick_of_two_tricks() {
        var kingDiamond = new ColoredCard(CardValue.KING, CardColor.DIAMOND);
        var queenClub = new ColoredCard(CardValue.QUEEN, CardColor.CLUB);
        var knightSpade = new ColoredCard(CardValue.KNIGHT, CardColor.SPADE);
        var one = new Trump(TrumpValue.ONE);
        var aceHeart = new ColoredCard(CardValue.ACE, CardColor.HEART);
        var aceSpade = new ColoredCard(CardValue.ACE, CardColor.SPADE);
        var aceDiamond = new ColoredCard(CardValue.ACE, CardColor.DIAMOND);
        var threeDiamond = new ColoredCard(CardValue.THREE, CardColor.DIAMOND);

        var firstTrick = new Trick(List.of(kingDiamond, queenClub, knightSpade, aceHeart));
        var lastTrick = new Trick(List.of(aceSpade, one, aceDiamond, threeDiamond));

        var result = PointsCounter.countPoints(List.of(firstTrick, lastTrick));

        assertThat(result).isEqualTo(27);
    }
}
