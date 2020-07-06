package fr.arolla;

import fr.arolla.card.Card;
import fr.arolla.card.Trump;
import fr.arolla.card.TrumpValue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.runners.Parameterized.Parameters;

// With JUnit 5, the parameterized tests are now much easier to use
@RunWith(Parameterized.class)
public class TrumpLogicTest {

    private final List<Card> trick;
    private final Card winningCard;

    public TrumpLogicTest(List<Card> trick, Card winningCard) {
        this.trick = trick;
        this.winningCard = winningCard;
    }

    @Parameters(name = "{index}: Test with a trick of trumps")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {Arrays.asList(new Trump(TrumpValue.ONE), new Trump(TrumpValue.TWO), new Trump(TrumpValue.THREE)),
                        new Trump(TrumpValue.THREE)},
                {Arrays.asList(new Trump(TrumpValue.TWENTY), new Trump(TrumpValue.TWENTY_ONE), new Trump(TrumpValue.SIXTEEN)),
                        new Trump(TrumpValue.TWENTY_ONE)},
                {Arrays.asList(new Trump(TrumpValue.FOUR), new Trump(TrumpValue.FIVE), new Trump(TrumpValue.THIRTEEN)),
                        new Trump(TrumpValue.THIRTEEN)},
                {Arrays.asList(new Trump(TrumpValue.TWELVE), new Trump(TrumpValue.NINETEEN), new Trump(TrumpValue.ELEVEN)),
                        new Trump(TrumpValue.NINETEEN)},
                {Arrays.asList(new Trump(TrumpValue.TWELVE), new Trump(TrumpValue.EIGHTEEN), new Trump(TrumpValue.NINE),
                        new Trump(TrumpValue.TEN)),
                        new Trump(TrumpValue.EIGHTEEN)},
                {Arrays.asList(new Trump(TrumpValue.SEVEN), new Trump(TrumpValue.SEVENTEEN), new Trump(TrumpValue.EIGHT),
                        new Trump(TrumpValue.SIX), new Trump(TrumpValue.ONE)),
                        new Trump(TrumpValue.SEVENTEEN)},
                {Arrays.asList(new Trump(TrumpValue.SEVEN), new Trump(TrumpValue.FIFTEEN), new Trump(TrumpValue.FOOL),
                        new Trump(TrumpValue.SIX), new Trump(TrumpValue.ONE)),
                        new Trump(TrumpValue.FIFTEEN)}
        });
    }

    @Test
    public void test_trumps_logic() throws ImpossibleCardsCombinationException {
        assertThat(TrickManager.getWinningCard(trick)).isEqualTo(winningCard);
    }
}
