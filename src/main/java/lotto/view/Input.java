package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.Money;
import lotto.domain.WinningNumbers;

public interface Input {
    Money getUserMoney();

    WinningNumbers getUserWinningNumbers();

    LottoNumber getUserBonusNumber();
}
