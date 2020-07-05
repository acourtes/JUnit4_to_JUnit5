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
}
