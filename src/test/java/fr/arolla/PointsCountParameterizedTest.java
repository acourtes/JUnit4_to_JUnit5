package fr.arolla;

import fr.arolla.card.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.runners.Parameterized.Parameter;

@RunWith(Parameterized.class)
public class PointsCountParameterizedTest {

    @Parameter
    public Card firstCard;
    @Parameter(1)
    public Card secondCard;
    @Parameter(2)
    public double expectedPoints;

    @Parameterized.Parameters(name = "{index}: Points of {0} and {1} = {2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new ColoredCard(CardValue.KING, CardColor.HEART), new ColoredCard(CardValue.SEVEN, CardColor.CLUB), 5},
                {new ColoredCard(CardValue.QUEEN, CardColor.SPADE), new ColoredCard(CardValue.EIGHT, CardColor.CLUB), 4},
                {new ColoredCard(CardValue.KNIGHT, CardColor.DIAMOND), new ColoredCard(CardValue.NINE, CardColor.CLUB), 3},
                {new ColoredCard(CardValue.JACK, CardColor.HEART), new ColoredCard(CardValue.FOUR, CardColor.CLUB), 2},
                {new ColoredCard(CardValue.TEN, CardColor.DIAMOND), new ColoredCard(CardValue.SIX, CardColor.CLUB), 1},
                {new Trump(TrumpValue.TWENTY_ONE), new Trump(TrumpValue.SIX), 5},
                {new Trump(TrumpValue.ONE), new Trump(TrumpValue.SIXTEEN), 5},
                {new Trump(TrumpValue.FOOL), new Trump(TrumpValue.NINETEEN), 5},
                {new Trump(TrumpValue.THREE), new Trump(TrumpValue.NINETEEN), 1},
                {new ColoredCard(CardValue.KING, CardColor.DIAMOND), new ColoredCard(CardValue.QUEEN, CardColor.CLUB), 8}
        });
    }

    @Test
    public void test_points_counting() {
        assertThat(PointsCounter.countPoints(firstCard, secondCard)).isEqualTo(expectedPoints);
    }
}
