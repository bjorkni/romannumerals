package be.kapture.romannumerals;

import com.github.fracpete.romannumerals4j.RomanNumeralFormat;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class RomanNumeralsTest {

    @Test
    void one() {
        assertThat(
                RomanNumerals.toRoman(1))
                .isEqualTo("I");
    }

    @Test
    void two() {
        assertThat(
                RomanNumerals.toRoman(2))
                .isEqualTo("II");
    }

    @Test
    void five() {
        assertThat(
                RomanNumerals.toRoman(5))
                .isEqualTo("V");
    }

    @Test
    void ten() {
        assertThat(
                RomanNumerals.toRoman(10))
                .isEqualTo("X");
    }

    @Test
    void tooHigh() {
        if (Roman.getHighest() == Roman.M) {
            assertThatIllegalArgumentException().isThrownBy(() ->
                    RomanNumerals.toRoman(4000));
        }
    }

    @Test
    void four() {
        assertThat(
                RomanNumerals.toRoman(4))
                .isEqualTo("IV");
    }

    @Test
    void nine() {
        assertThat(
                RomanNumerals.toRoman(9))
                .isEqualTo("IX");
    }

    @Test
    void oneHundred() {
        assertThat(
                RomanNumerals.toRoman(100))
                .isEqualTo("C");
    }

    /**
     * One test to rule them all; compare with library.
     */
    @Test
    void all() {
        for (int i = 1; i <= 3000; i++) {
            assertThat(
                    RomanNumerals.toRoman(i))
                    .isEqualTo(new RomanNumeralFormat().format(i));
        }
    }

    @Test
    void expandedAboveM() {
        assertThat(
                RomanNumerals.toRoman(7219))
                .isEqualTo("V_MMCCXIX");
    }


}