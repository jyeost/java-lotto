package lotto.domain;

import java.text.DecimalFormat;

public enum Rank {
    SIXTH(3, false, 5000),
    FOURTH(4, false, 50000),
    THIRD(5, false, 1500000),
    SECOND(5, true, 30000000),
    FIRST(6, false, 2000000000),
    MISS(0, false, 0);

    private final int countOfMatch;
    private final boolean isBonusMatch;
    private final int prizeMoney;

    Rank(int countOfMatch, boolean isBonusMatch, int prizeMoney) {
        this.countOfMatch = countOfMatch;
        this.isBonusMatch = isBonusMatch;
        this.prizeMoney = prizeMoney;
    }

    public static Rank calculateMatch(int countOfMatch, boolean isBonusMatch) {
        if (SECOND.countOfMatch == countOfMatch && SECOND.isBonusMatch == isBonusMatch) return SECOND;
        for (Rank rank : Rank.values()) {
            if (rank.countOfMatch == countOfMatch) return rank;
        }
        return MISS;
    }

    public static String printRank(Rank rank, Integer countOfMatch) {
        DecimalFormat df = new DecimalFormat("###,###");
        if (rank == Rank.SECOND)
            return rank.countOfMatch + "개 일치, 보너스볼 일치 (" + df.format(rank.prizeMoney) + ") - " + countOfMatch + "개" + System.lineSeparator();
        return rank.countOfMatch + "개 일치 (" + df.format(rank.prizeMoney) + ") - " + countOfMatch + "개" + System.lineSeparator();
    }


    public static int calculateYield(Rank rank, int countOfMatch) {
        return rank.prizeMoney * countOfMatch;
    }
}
