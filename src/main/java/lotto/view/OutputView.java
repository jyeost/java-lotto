package lotto.view;

import lotto.domain.AutoLotteries;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;

public class OutputView implements Output {
    @Override
    public void printAutoLotteries(AutoLotteries autoLotteries) {
        System.out.println(System.lineSeparator() + autoLotteries.getSize() + "개를 구매했습니다.");
        for (int i = 0; i < autoLotteries.getSize(); i++) {
            printAutoLotto(autoLotteries.get(i));
        }
    }

    private void printAutoLotto(Lotto lotto) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < lotto.getSize(); i++) {
            sb.append(lotto.get(i).toString());
            if (i != lotto.getSize() - 1) sb.append(",");
        }
        sb.append("]");
        System.out.println(sb);
    }

    @Override
    public void printLottoResult(LottoResult lottoResult, int lottoCount) {
        System.out.println(System.lineSeparator() + "당첨통계" + System.lineSeparator() + "--");
        System.out.println(lottoResult.toString());
        System.out.println("총 수익률은 " + lottoResult.calculateYield(lottoCount) + "%입니다.");
    }

}
