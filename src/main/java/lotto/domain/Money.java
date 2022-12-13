package lotto.domain;

public class Money {
    public static final int lottoPrice = 1000;
    private static final String MONEY_ERROR_MSG = "[ERROR] 금액은 " + lottoPrice + "단위로만 입력가능합니다.";
    private final int lottoCount;

    public Money(String userInput) {
        validateNotNull(userInput);
        validateNumber(userInput);
        validateNoChange(Integer.parseInt(userInput));
        this.lottoCount = Integer.parseInt(userInput) / lottoPrice;
    }

    private void validateNotNull(String userInput) {
        if (userInput == null || "".equals(userInput)) {
            throw new IllegalArgumentException(MONEY_ERROR_MSG);
        }
    }

    private void validateNumber(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(MONEY_ERROR_MSG);
        }
    }

    private void validateNoChange(int userInput) {
        if (userInput < lottoPrice || userInput % lottoPrice != 0) throw new IllegalArgumentException(MONEY_ERROR_MSG);
    }

    public int getLottoCount() {
        return lottoCount;
    }
}
