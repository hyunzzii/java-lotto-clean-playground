package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottos = new ArrayList<>();


    public void addLotto(final Lotto lotto) {
        lottos.add(lotto);
    }

    public List<Integer> calculateLottoMatchCounts(final WinningLotto winningLotto) {
        return  lottos.stream().map(
                lotto -> lotto.countMatch(winningLotto.getLotto())).collect(Collectors.toList());
    }

    public List<Boolean> calculateBonusMatchs(final WinningLotto winningLotto) {
        return  lottos.stream().map(
                lotto -> lotto.contains(winningLotto.getBonusBall())).collect(Collectors.toList());
    }
}
