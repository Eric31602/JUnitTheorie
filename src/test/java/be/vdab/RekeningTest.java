package be.vdab;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class RekeningTest {

    private Rekening rekening;

    @BeforeEach
    void beforeEach() {
        rekening = new Rekening();
    }

    @Test
    void hetSaldoVanEenNieuweRekeningIs€0() {
        assertThat(rekening.getSaldo()).isZero();
    }

    @Test
    void na€10StortingIsSaldo€10() {
        rekening.stort(BigDecimal.TEN);
        assertThat(rekening.getSaldo()).isEqualByComparingTo("10");
    }

    @Test
    void na€10En€1StortenIsHetSaldo€11() {
        rekening.stort(BigDecimal.ONE);
        rekening.stort(BigDecimal.TEN);
        assertThat(rekening.getSaldo()).isEqualByComparingTo("11");
    }
}

