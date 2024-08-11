package domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {
    static class FakeNumberGenerator implements NumberGenerator {
        private final List<List<Integer>> numbers = List.of(
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 1, 4, 2, 11),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(23, 25, 33, 36, 39, 41)
        );

        private int i = 0;

        @Override
        public List<Integer> generate() {
            return numbers.get(i++);
        }
    }

    LottoService lottoService;

    @BeforeEach
    void setLottoService() {
        this.lottoService = new LottoService(new FakeNumberGenerator());
    }

    @Test
    @DisplayName("당첨 통계를 계산한다.")
    void calculateWinningTest() {
        //given
        final Integer count = 8;

        final List<Integer> numbers = List.of(new Integer[]{1,2,3,4,5,6});
        final Lotto lotto = new Lotto(numbers.stream().map(LottoNumber::new).collect(Collectors.toList()));
        final WinningLotto winningLotto = new WinningLotto(lotto, new LottoNumber(7));

        //when
        lottoService.makeLottos(count);

        //then
        Result result = lottoService.calculateResult(winningLotto);
        assertThat(result.getRankCount(Rank.THIRD)).isEqualTo(1);
    }

//    @Test
//    @DisplayName("주어진 개수 만큼 로또를 생성한다.")
//    void makeLottosTest(){
//        // given
//        final Integer count = 3;
//
//        //when
//        lottoService.makeLottos(count);
//
//        //then
//        assertThat(l)
//    }
}