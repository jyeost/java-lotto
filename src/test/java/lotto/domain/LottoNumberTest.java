package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {
    @DisplayName("로또 넘버가 숫자로 되어있지 않으면 예외가 발생한다")
    @ValueSource(strings = {"d", "", " ", "하하"})
    @ParameterizedTest
    void createLottoNumberNotInt(String input) {
        assertThatThrownBy(() -> new LottoNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 넘버가 범위에 맞지 않으면 예외가 발생한다")
    @ValueSource(strings = {"0", "-1", "46"})
    @ParameterizedTest
    void createLottoNotInRange(String input) {
        assertThatThrownBy(() -> new LottoNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 넘버가 범위에 맞지 않으면 예외가 발생한다2")
    @ValueSource(ints = {0, -1, 46})
    @ParameterizedTest
    void createLottoNotInRange2(int input) {
        assertThatThrownBy(() -> new LottoNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}