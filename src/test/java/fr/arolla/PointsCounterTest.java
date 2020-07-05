package fr.arolla;

import fr.arolla.card.CardColor;
import fr.arolla.card.CardValue;
import fr.arolla.card.ColoredCard;
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
}
