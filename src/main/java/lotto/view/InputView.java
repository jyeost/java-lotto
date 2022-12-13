package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.LottoNumber;
import lotto.domain.Money;
import lotto.domain.WinningNumbers;

public class InputView implements Input {
    @Override
    public Money getUserMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            return new Money(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getUserMoney();
        }
    }

    @Override
    public WinningNumbers getUserWinningNumbers() {
        System.out.println(System.lineSeparator() + "당첨 번호를 입력해 주세요.");
        try {
            return new WinningNumbers(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getUserWinningNumbers();
        }
    }

    public LottoNumber getUserBonusNumber() {
        System.out.println(System.lineSeparator() + "보너스 번호를 입력해 주세요.");
        try {
            return new LottoNumber(Console.readLine());
        } catch (IllegalArgumentException | NullPointerException e) {
            System.out.println(e.getMessage());
            return getUserBonusNumber();
        }
    }
}
