package domain;


import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultTest {

    @Test
    @DisplayName("1등 당첨 1개")
    void resultThreeWinTest() {
        //given
        final List<Integer> winningNumbers = List.of(new Integer[]{2, 15, 13, 43, 25, 23});
        final Lotto lottoForWin = new Lotto(winningNumbers.stream().map(LottoNumber::new).collect(Collectors.toList()));
        final WinningLotto winningLotto = new WinningLotto(lottoForWin, new LottoNumber(3));

        final List<List<Integer>> integerLottos = List.of(
                List.of(2, 15, 13, 43, 25, 23),
                List.of(2, 15, 13, 43, 25, 3),
                List.of(7, 11, 16, 35, 36, 44)
        );
        final Lottos lottos =new Lottos();
        for(List<Integer> integerLotto : integerLottos) {
            Lotto lotto = new Lotto(integerLotto.stream().map(LottoNumber::new).collect(Collectors.toList()));
            lottos.addLotto(lotto);
        }

        //when
        Result result = new Result(lottos, winningLotto);

        //then
        assertThat(result.getRankCount(Rank.SECOND)).isEqualTo(1);
    }
}
