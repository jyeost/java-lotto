package lotto.domain;

import java.util.*;

public class Lotto {
    public static final int LOTTO_SIZE = 6;
    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = validateRange(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(WinningNumbers.WINNING_NUMBER_ERROR_MSG);
        }
    }

    private List<LottoNumber> validateRange(List<Integer> numbers) {
        List<LottoNumber> lottoNumberList = new ArrayList<>();
        for (int number : numbers) {
            lottoNumberList.add(new LottoNumber(number));
        }
        return validateDuplicate(lottoNumberList);
    }

    private List<LottoNumber> validateDuplicate(List<LottoNumber> lottoNumberList) {
        Set<LottoNumber> numberSet = new HashSet<>(lottoNumberList);
        if (numberSet.size() != LOTTO_SIZE) throw new IllegalArgumentException("당첨번호는 중복이 없어야 합니다.");
        return lottoNumberList;
    }

    public void validateBonusNumberNoDuplicate(LottoNumber bonusNumber) {
        if (this.numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨번호와 중복된 번호를 사용할 수 없습니다.");
        }
    }

    public LottoNumber get(int index) {
        return this.numbers.get(index);
    }

    public int getSize() {
        return this.numbers.size();
    }

    public boolean contains(LottoNumber lottoNumber) {
        return this.numbers.contains(lottoNumber);
    }

}
