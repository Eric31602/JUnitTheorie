package be.vdab;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.assertj.core.api.Assertions.assertThat;

public class ConverterTest {

    @Test
    public void eenInchIs2Komma54Centimeter() {
        assertThat(new Converter().inchesNaarCentimeter(BigDecimal.ONE)).isEqualByComparingTo("2.54");
    }

    @Test
    public void tweehonderdInchesIs508Centimeter() {
        assertThat(new Converter().inchesNaarCentimeter(BigDecimal.valueOf(200))).isEqualByComparingTo("508");
    }
}
