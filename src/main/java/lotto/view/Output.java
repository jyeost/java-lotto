package lotto.view;

import lotto.domain.AutoLotteries;
import lotto.domain.LottoResult;

public interface Output {
    void printAutoLotteries(AutoLotteries autoLotteries);

    void printLottoResult(LottoResult lottoResult, int lottoCount);
}
