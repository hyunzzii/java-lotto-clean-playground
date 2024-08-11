package domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumberTest {

    @Test
    @DisplayName("범위가 1 ~ 45여야 한다.")
    void lottoNumberRangeTest() {
        //given
        final int number = 45;
        //when, then
        assertThatCode(() -> new LottoNumber(number)).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("범위가 1 ~ 45가 아니면 예외를 발생시킨다.")
    void lottoNumberRangeExceptionTest() {
        //given
        final int number = 47;
        //when, then
        assertThatThrownBy(() -> new LottoNumber(number)).isInstanceOf(IllegalArgumentException.class);
    }
}
