package domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private final List<LottoNumber> lottoNumbers;

    public Lotto(final List<LottoNumber> lottoNumbers) {
        validate(lottoNumbers);
        Collections.sort(lottoNumbers);
        this.lottoNumbers = List.copyOf(lottoNumbers);
    }

    private void validate(final List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> lottoNumberSet = new HashSet<>(lottoNumbers);
        if (lottoNumberSet.size() > LottoIntegerConstant.of(LottoIntegerConstant.LOTTO_SIZE)) {
            throw new IllegalArgumentException(ErrorMessage.of(ErrorMessage.INVALID_LOTTO_SIZE));
        }
    }

    public Integer countMatch(Lotto otherLotto) {
        return (int) lottoNumbers.stream().filter(otherLotto::contains).count();
    }

    public boolean contains(LottoNumber otherNumber) {
        return lottoNumbers.stream()
                .anyMatch(lottoNumber -> lottoNumber.isSame(otherNumber));
    }
}