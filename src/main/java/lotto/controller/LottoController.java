package lotto.controller;

import lotto.domain.AutoLotteries;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoResult;
import lotto.view.Input;
import lotto.view.Output;

public class LottoController {
    private final Input input;
    private final Output output;

    public LottoController(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public void sellLotto() {
        AutoLotteries autoLotteries = new AutoLotteries(input.getUserMoney().getLottoCount());
        output.printAutoLotteries(autoLotteries);
        Lotto winningNumbers = getWinningNumber();
        LottoNumber bonusNumber = getBonusNumber(winningNumbers);
        printResult(autoLotteries, winningNumbers, bonusNumber);
    }

    private Lotto getWinningNumber() {
        try {
            return new Lotto(input.getUserWinningNumbers().getWinningNumbers());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinningNumber();
        }
    }

    private LottoNumber getBonusNumber(Lotto winningNumbers) {
        try {
            LottoNumber bonusNumber = input.getUserBonusNumber();
            winningNumbers.validateBonusNumberNoDuplicate(bonusNumber);
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getBonusNumber(winningNumbers);
        }
    }

    private void printResult(AutoLotteries autoLotteries, Lotto winningNumbers, LottoNumber bonusNumber) {
        LottoResult lottoResult = new LottoResult();
        lottoResult.calculateResult(autoLotteries, winningNumbers, bonusNumber);
        output.printLottoResult(lottoResult, autoLotteries.getSize());
    }
}
