package lotto.domain;

import java.util.Objects;

public class LottoNumber {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final String NUMBER_ERROR_MEG = "각 번호는 " + MIN_NUMBER + "와 " + MAX_NUMBER + "사이어야 합니다";
    private final int number;

    public LottoNumber(int number) {
        validateRange(number);
        this.number = number;
    }

    public LottoNumber(String userInput) {
        this(stringToInt(userInput));
    }

    private static int stringToInt(String userInput) {
        try {
            return Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_ERROR_MEG);
        }
    }

    private void validateRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(NUMBER_ERROR_MEG);
        }
    }

    @Override
    public boolean equals(Object obj) {
        LottoNumber lottoNumber = (LottoNumber) obj;
        return number == lottoNumber.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return String.valueOf(this.number);
    }
}
