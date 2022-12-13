package lotto.domain;

import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;

public class LottoResult {
    private final Map<Rank, Integer> result;

    public LottoResult() {
        this.result = new LinkedHashMap<>();
        for (Rank rank : Rank.values()) {
            this.result.put(rank, 0);
        }
    }

    public void calculateResult(AutoLotteries autoLotteries, Lotto winningNumbers, LottoNumber bonusNumber) {
        for (int i = 0; i < autoLotteries.getSize(); i++) {
            int countOfMatch = calculateWinning(autoLotteries.get(i), winningNumbers);
            boolean isBonusMatch = autoLotteries.get(i).contains(bonusNumber);
            calculateMatch(countOfMatch, isBonusMatch);
        }
    }

    private int calculateWinning(Lotto autoLotto, Lotto winningNumbers) {
        int countOfMatch = 0;
        for (int i = 0; i < winningNumbers.getSize(); i++) {
            if (autoLotto.contains(winningNumbers.get(i))) countOfMatch++;
        }
        return countOfMatch;
    }

    private void calculateMatch(int countOfMatch, boolean isBonusMatch) {
        Rank rank = Rank.calculateMatch(countOfMatch, isBonusMatch);
        result.put(rank, result.get(rank) + 1);
    }

    public String calculateYield(int lottoCount) {
        DecimalFormat df = new DecimalFormat("###,###.0");
        double yield = 0;
        for (Rank rank : result.keySet()) {
            yield += Rank.calculateYield(rank, result.get(rank));
        }
        return df.format(yield / (lottoCount * Money.lottoPrice) * 100);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Rank rank : result.keySet()) {
            if (rank == Rank.MISS) continue;
            sb.append(Rank.printRank(rank, result.get(rank)));
        }
        return sb.toString();
    }
}
