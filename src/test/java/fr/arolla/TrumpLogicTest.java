package fr.arolla;

import fr.arolla.card.Card;
import fr.arolla.card.Trump;
import fr.arolla.card.TrumpValue;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

// With JUnit 5, the parameterized tests are now much easier to use
public class TrumpLogicTest {

    private static Stream<Arguments> buildTrumpsTricks() {
        return Stream.of(
                Arguments.of(Arrays.asList(new Trump(TrumpValue.ONE), new Trump(TrumpValue.TWO), new Trump(TrumpValue.THREE)),
                        new Trump(TrumpValue.THREE)),
                Arguments.of(Arrays.asList(new Trump(TrumpValue.TWENTY), new Trump(TrumpValue.TWENTY_ONE), new Trump(TrumpValue.SIXTEEN)),
                        new Trump(TrumpValue.TWENTY_ONE)),
                Arguments.of(Arrays.asList(new Trump(TrumpValue.FOUR), new Trump(TrumpValue.FIVE), new Trump(TrumpValue.THIRTEEN)),
                        new Trump(TrumpValue.THIRTEEN)),
                Arguments.of(Arrays.asList(new Trump(TrumpValue.TWELVE), new Trump(TrumpValue.NINETEEN), new Trump(TrumpValue.ELEVEN)),
                        new Trump(TrumpValue.NINETEEN)),
                Arguments.of(Arrays.asList(new Trump(TrumpValue.TWELVE), new Trump(TrumpValue.EIGHTEEN), new Trump(TrumpValue.NINE),
                        new Trump(TrumpValue.TEN)),
                        new Trump(TrumpValue.EIGHTEEN)),
                Arguments.of(Arrays.asList(new Trump(TrumpValue.SEVEN), new Trump(TrumpValue.SEVENTEEN), new Trump(TrumpValue.EIGHT),
                        new Trump(TrumpValue.SIX), new Trump(TrumpValue.ONE)),
                        new Trump(TrumpValue.SEVENTEEN)),
                Arguments.of(Arrays.asList(new Trump(TrumpValue.SEVEN), new Trump(TrumpValue.FIFTEEN), new Trump(TrumpValue.FOOL),
                        new Trump(TrumpValue.SIX), new Trump(TrumpValue.ONE)),
                        new Trump(TrumpValue.FIFTEEN))
        );
    }

    @ParameterizedTest(name = "{index}: Test with a trick of trumps")
    @MethodSource("buildTrumpsTricks")
    void test_trumps_logic(List<Card> trick, Card winningCard) throws ImpossibleCardsCombinationException {
        assertThat(TrickManager.getWinningCard(trick)).isEqualTo(winningCard);
    }

    @ParameterizedTest
    @EnumSource(TrumpValue.class)
    void test_trumps_order(TrumpValue trumpValue) {
        EnumSet<TrumpValue> oudlers = EnumSet.of(TrumpValue.ONE, TrumpValue.FOOL, TrumpValue.TWENTY_ONE);

        Assumptions.assumingThat(oudlers.contains(trumpValue),
                () -> assertThat(trumpValue.getPoints()).isEqualTo(4.5));
        Assumptions.assumingThat(!oudlers.contains(trumpValue),
                () -> assertThat(trumpValue.getPoints()).isEqualTo(0.5));
    }
}
