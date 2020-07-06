package fr.arolla;

import fr.arolla.card.Card;
import fr.arolla.card.CardColor;
import fr.arolla.card.CardValue;
import fr.arolla.card.ColoredCard;
import fr.arolla.card.Trump;
import fr.arolla.card.TrumpValue;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

// With JUnit 5, the parameterized tests are now much easier to use
public class PointsCountParameterizedTest {

    private static Stream<Arguments> buildTestData() {
        return Stream.of(
                Arguments.of(new ColoredCard(CardValue.KING, CardColor.HEART), new ColoredCard(CardValue.SEVEN, CardColor.CLUB), 5),
                Arguments.of(new ColoredCard(CardValue.QUEEN, CardColor.SPADE), new ColoredCard(CardValue.EIGHT, CardColor.CLUB), 4),
                Arguments.of(new ColoredCard(CardValue.KNIGHT, CardColor.DIAMOND), new ColoredCard(CardValue.NINE, CardColor.CLUB), 3),
                Arguments.of(new ColoredCard(CardValue.JACK, CardColor.HEART), new ColoredCard(CardValue.FOUR, CardColor.CLUB), 2),
                Arguments.of(new ColoredCard(CardValue.TEN, CardColor.DIAMOND), new ColoredCard(CardValue.SIX, CardColor.CLUB), 1),
                Arguments.of(new Trump(TrumpValue.TWENTY_ONE), new Trump(TrumpValue.SIX), 5),
                Arguments.of(new Trump(TrumpValue.ONE), new Trump(TrumpValue.SIXTEEN), 5),
                Arguments.of(new Trump(TrumpValue.FOOL), new Trump(TrumpValue.NINETEEN), 5),
                Arguments.of(new Trump(TrumpValue.THREE), new Trump(TrumpValue.NINETEEN), 1),
                Arguments.of(new ColoredCard(CardValue.KING, CardColor.DIAMOND), new ColoredCard(CardValue.QUEEN, CardColor.CLUB), 8)
        );
    }

    @ParameterizedTest(name = "{index}: Points of {0} and {1} = {2}")
    @MethodSource("buildTestData")
    void test_points_counting(Card firstCard, Card secondCard, double expectedPoints) {
        assertThat(PointsCounter.countPoints(firstCard, secondCard)).isEqualTo(expectedPoints);
    }
}
