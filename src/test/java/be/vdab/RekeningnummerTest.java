package be.vdab;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

class RekeningnummerTest {

    @ParameterizedTest
    @ValueSource(strings = {"BE72091012240116", "BE68539007547034", "BE02063588295840"})
    void correcteNummers(String nummer) {
        new Rekeningnummer(nummer);
    }

   @ParameterizedTest
   @ValueSource(strings={ "BE720910122401160", "BE7209101224011",
           "NL72091012240116", "BEX209101224011", "BE01091012240116",
           "BE99091012240116", "BE72091012240115", ""})
   void incorrecteNummers(String nummer) {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Rekeningnummer(nummer)
        );
   }

    @Test void nummerMetNullIsVerkeerd() {
        assertThatNullPointerException().isThrownBy(() -> new Rekeningnummer(null));
    }

    @Test void toStringGeeftHetNummerTerug() {
        var nummer = "BE72091012240116";
        assertThat(new Rekeningnummer(nummer)).hasToString(nummer);
    }

}