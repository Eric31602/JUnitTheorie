package be.vdab;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Rekening {
    private BigDecimal saldo = BigDecimal.ZERO;
    private final List<BigDecimal> stortingen = new ArrayList<>();

    public void stort(BigDecimal bedrag) {
        if (bedrag.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Bedrag moet groter dan 0 zijn!");
        }
        saldo = saldo.add(bedrag);
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    List<BigDecimal> getStortingen() {
        return stortingen;
    }
    List<BigDecimal> getStortingenGesorteerd() {
        return stortingen.stream().sorted().toList();
    }
}
