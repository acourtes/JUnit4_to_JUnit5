package fr.arolla;

import fr.arolla.card.Trump;
import fr.arolla.card.TrumpValue;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class PointsCountWithCSVFileTest {

    @Test
    public void test_points_count_for_trumps_with_csv_file() throws URISyntaxException {
        var csvFileURL = PointsCountWithCSVFileTest.class.getClassLoader()
                .getResource("trumpsTricks.csv");

        try (var csvReader = new Scanner(new File(csvFileURL.toURI()))) {
            csvReader.next(); // We skip the first header line

            while (csvReader.hasNext()) {
                // CSV structure : firstCard,secondCards,expectedPoints
                var elements = csvReader.next().split(",");
                var firstTrump = new Trump(TrumpValue.valueOf(elements[0]));
                var secondTrump = new Trump(TrumpValue.valueOf(elements[1]));
                var expectedPoints = Double.valueOf(elements[2]);

                assertThat(PointsCounter.countPoints(firstTrump, secondTrump)).isEqualTo(expectedPoints);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
