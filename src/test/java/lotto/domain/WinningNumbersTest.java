package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class WinningNumbersTest {
    @DisplayName("당첨번호에 ,가 포함되어있지 않거나 빈값이 들어오면 예외가 발생한다")
    @ValueSource(strings = {"", "3467", "아에이오우", " "})
    @ParameterizedTest
    void createWinningNumbersNull(String input) {
        assertThatThrownBy(() -> new WinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호에 띄어쓰기가 포함되어 있거나 빈 값이 있으면 예외가 발생한다")
    @ValueSource(strings = {"1,2,3, 4,5,6", "1,2,3,4,,5", "1,2,3,4, ,5"})
    @ParameterizedTest
    void createWinningHavingSpace(String input) {
        assertThatThrownBy(() -> new WinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호에 숫자가 아닌 값이 포함되어 있으면 예외가 발생한다")
    @ValueSource(strings = {"1,2,3,4,5,ㅇ", "ㄱ,ㄴ,ㄷ,ㄹ,ㅁ,ㅂ"})
    @ParameterizedTest
    void createWinningNoNumber(String input) {
        assertThatThrownBy(() -> new WinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호에 제대로 된 수가 들어오면 예외가 발생하지 않는다")
    @Test
    void createWinning() {
        String input = "1,2,3,4,5,6";
        assertThat(new WinningNumbers(input))
                .isNotInstanceOf(IllegalArgumentException.class);
    }

}