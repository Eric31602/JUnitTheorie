package be.vdab;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class RekeningTest {

    @Test
    void hetSaldoVanEenNieuweRekeningIs€0() {
        var rekening = new Rekening();
        assertThat(rekening.getSaldo()).isZero();
    }

    @Test
    void na€10StortingIsSaldo€10() {
        var rekening = new Rekening();
        rekening.stort(BigDecimal.TEN);
        assertThat(rekening.getSaldo()).isEqualByComparingTo("10");
    }

    @Test
    void na€10En€1StortenIsHetSaldo€11() {
        var rekening = new Rekening();
        rekening.stort(BigDecimal.ONE);
        rekening.stort(BigDecimal.TEN);
        assertThat(rekening.getSaldo()).isEqualByComparingTo("11");
    }
}

