package domain;


public class LottoNumber implements Comparable<LottoNumber> {
    private static final Integer MAX_NUM = 45;
    private static final Integer MIN_NUM = 1;

    private final Integer number;

    public LottoNumber(final Integer number) {
        validate(number);
        this.number = number;
    }

    private void validate(final Integer number) {
        if (!(number >= MIN_NUM && number <= MAX_NUM)) {
            throw new IllegalArgumentException(ErrorMessage.of(ErrorMessage.INVALID_LOTTO_NUMBER));
        }
    }

    public boolean isSame(LottoNumber otherNumber){
        return number.equals(otherNumber.number);
    }

    @Override
    public int compareTo(final LottoNumber other) {
        return Integer.compare(this.number, other.number);
    }

}
