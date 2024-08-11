package domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {

    @Test
    @DisplayName("로또 번호가 6개여야 한다.")
    void lottoSizeTest() {
        //given
        final List<Integer> numbers = List.of(new Integer[]{2, 15, 13, 43, 25, 23});
        final List<LottoNumber> lottoNumbers = numbers.stream().map(LottoNumber::new).collect(Collectors.toList());

        //when, then
        assertThatCode(() -> new Lotto(lottoNumbers)).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("로또 번호가 6개가 아니면 예외가 발생한다.")
    void lottoSizeExceptionTest() {
        //given
        final List<Integer> numbers = List.of(new Integer[]{2, 15, 13, 43, 25, 23,31});
        final List<LottoNumber> lottoNumbers = numbers.stream().map(LottoNumber::new).collect(Collectors.toList());

        //when, then
        assertThatThrownBy(() -> new Lotto(lottoNumbers)).isInstanceOf(IllegalArgumentException.class);
    }

//    @Test
//    @DisplayName("로또 번호를 정렬해서 저장한다.")
//    void lottoSetTest() {
//        //given
//        final List<Integer> numbers = List.of(new Integer[]{2, 15, 13, 43, 25, 23,31});
//        final List<LottoNumber> lottoNumbers = numbers.stream().map(LottoNumber::new).collect(Collectors.toList());
//
//        //when, then
//        assertThatThrownBy(() -> new Lotto(lottoNumbers)).isInstanceOf(IllegalArgumentException.class);
//    }
}
