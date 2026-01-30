package be.vdab;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

class StatistiekTest {
    @Test
    public void hetGemiddeldeVan0En10Is5() {
        assertThat(Statistiek.getGemiddelde(new BigDecimal[] {BigDecimal.ZERO, BigDecimal.TEN}))
                .isEqualByComparingTo("5");
    }

    @Test
    public void gemiddeldeVan1GetalIsDatGetal() {
        assertThat(Statistiek.getGemiddelde(new BigDecimal[]{BigDecimal.ONE}))
                .isEqualByComparingTo(BigDecimal.ONE);
    }

    @Test void hetGemiddeldeVanEenLegeVerzamelingKanJeNietBerekenen() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> Statistiek.getGemiddelde(new BigDecimal[] {}));
    }
    @Test void hetGemiddeldeVanNullKanJeNietBerekenen() {
        assertThatNullPointerException().isThrownBy(
                () -> Statistiek.getGemiddelde(null));
    }
    @Test void eenArrayElementMagNietNullBevatten() {
        assertThatNullPointerException().isThrownBy(
                () -> Statistiek.getGemiddelde(new BigDecimal[] { null }));
    }
}