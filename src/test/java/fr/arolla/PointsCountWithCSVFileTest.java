package fr.arolla;

import fr.arolla.card.Trump;
import fr.arolla.card.TrumpValue;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.assertj.core.api.Assertions.assertThat;

public class PointsCountWithCSVFileTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/trumpsTricks.csv", numLinesToSkip = 1)
    void test_points_count_for_trumps_with_csv_file(@ConvertWith(TrumpConverter.class) Trump firstTrump,
                                                    @ConvertWith(TrumpConverter.class) Trump secondTrump,
                                                    double expectedPoints) {
        assertThat(PointsCounter.countPoints(firstTrump, secondTrump)).isEqualTo(expectedPoints);
    }

    static class TrumpConverter implements ArgumentConverter {
        @Override
        public Object convert(Object o, ParameterContext parameterContext) throws ArgumentConversionException {
            return new Trump(TrumpValue.valueOf((String) o));
        }
    }

}
