package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {
    public static final String WINNING_NUMBER_ERROR_MSG = "당첨번호는 ,로 구분된 숫자 6자리여야 합니다.";
    private static final String NUMBER_SEPARATOR = ",";
    private final List<Integer> winningNumbers = new ArrayList<>();

    public WinningNumbers(String userInput) {
        validateNotNull(userInput);
        StringListToWinningNumbers(stringToStringList(userInput));
    }

    private void validateNotNull(String userInput) {
        if (userInput == null || "".equals(userInput) || !userInput.contains(NUMBER_SEPARATOR)) {
            throw new IllegalArgumentException(WINNING_NUMBER_ERROR_MSG);
        }
    }

    private List<String> stringToStringList(String userInput) {
        return List.of(userInput.split(NUMBER_SEPARATOR));
    }

    private void StringListToWinningNumbers(List<String> inputList) {
        try {
            for (String input : inputList) {
                winningNumbers.add(Integer.parseInt(input));
            }
        } catch (NumberFormatException | NullPointerException e) {
            throw new IllegalArgumentException(WINNING_NUMBER_ERROR_MSG);
        }
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
