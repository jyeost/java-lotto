package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoLotteries {
    private final List<Lotto> autoLotteries = new ArrayList<>();

    public AutoLotteries(int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER, Lotto.LOTTO_SIZE);
            List<Integer> copyOfNumbers = new ArrayList<>(numbers);
            Collections.sort(copyOfNumbers);
            autoLotteries.add(new Lotto(copyOfNumbers));
        }
    }

    public Lotto get(int index) {
        return this.autoLotteries.get(index);
    }

    public int getSize() {
        return this.autoLotteries.size();
    }
}
