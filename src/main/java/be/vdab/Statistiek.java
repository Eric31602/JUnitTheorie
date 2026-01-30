package be.vdab;

import java.math.BigDecimal;
import java.util.Arrays;

public class Statistiek {

    public static BigDecimal getGemiddelde(BigDecimal[] getallen) {
        if (getallen.length == 0) {
            throw new IllegalArgumentException("Array mag niet leeg zijn");
        }

        return Arrays.stream(getallen)
                .reduce(BigDecimal.ZERO, (vorigTotaal, getal) -> vorigTotaal.add(getal))
                .divide(BigDecimal.valueOf(getallen.length));
    }
}
