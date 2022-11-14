package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Auto {

    private static final String SEPARATOR = ",";

    public static List<List<Integer>> AUTO_LOTTOS = new ArrayList<>();
    public static List<Integer> WINNING_NUMBERS = new ArrayList<>();
    public static double YIELD;

    public Auto() {
    }

    public Auto(int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lotto = new ArrayList<>();
            lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            try {
                Collections.sort(lotto);
            } catch (UnsupportedOperationException e) {
            }

            AUTO_LOTTOS.add(lotto);
        }
    }

    public void makeWinningNumbers(String userInput) {
        List<String> userInputs = Arrays.asList(userInput.split(SEPARATOR));
        for (String userNumber : userInputs) {
            WINNING_NUMBERS.add(Integer.parseInt(userNumber));
        }
    }

    public void checkWining(int bonusNumber) {
        for (List<Integer> autoLotto : AUTO_LOTTOS) {
            int win = countWin(autoLotto);
            int bonusWin = 0;

            if (autoLotto.contains(bonusNumber)) {
                bonusWin++;
            }
            countWinningResult(win, bonusWin);
        }
    }

    private int countWin(List<Integer> autoLotto) {
        int win = 0;
        for (int winningNumber : WINNING_NUMBERS) {
            if (autoLotto.contains(winningNumber)) {
                win++;
            }
        }
        return win;
    }

    private void countWinningResult(int win, int bonusWin) {
        if (win == Rank.FIRST.getWin()) Rank.FIRST.plusCount();
        if (win == Rank.SECOND.getWin() && bonusWin == Rank.SECOND.getBonusWin()) Rank.SECOND.plusCount();
        if (win == Rank.THIRD.getWin() && bonusWin == Rank.THIRD.getBonusWin()) Rank.THIRD.plusCount();
        if (win == Rank.FOURTH.getWin()) Rank.FOURTH.plusCount();
        if (win == Rank.FIFTH.getWin()) Rank.FIFTH.plusCount();
    }

    public void yieldCalculation(int money) {
        long yield = Rank.FIRST.getCount() * Rank.FIRST.getMoney() + Rank.SECOND.getCount() * Rank.SECOND.getMoney() + Rank.THIRD.getCount() * Rank.THIRD.getMoney()
                + Rank.FOURTH.getCount() * Rank.FOURTH.getMoney() + Rank.FIFTH.getCount() * Rank.FIFTH.getMoney();
        YIELD = yield / (double) money * 100;
    }
}
