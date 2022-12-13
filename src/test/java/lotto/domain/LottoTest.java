package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 개수가 6개가 안되면 예외가 발생한다.")
    @Test
    void createLottoByShortSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 범위를 넘어간 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoOverRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 범위보다 작은 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoShortRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, -3)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또번호에 제대로 된 수가 들어오면 예외가 발생하지 않는다")
    @Test
    void createWinning() {
        List<Integer> input = List.of(1, 2, 3, 4, 5, 6);
        assertThat(new Lotto(input))
                .isNotInstanceOf(IllegalArgumentException.class);
    }
}
