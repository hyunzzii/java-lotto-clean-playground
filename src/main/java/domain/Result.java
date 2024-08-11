package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {
    private Map<Rank, Integer> rankResult = new HashMap<>();

    public Result(Lottos lottos, WinningLotto winningLotto) {
        for (Rank rank : Rank.values()) {
            rankResult.put(rank, 0);
        }
        calculateRank(lottos, winningLotto);
    }

    private void calculateRank(Lottos lottos, WinningLotto winningLotto) {
//        for (Lotto lotto : lottos.getLottos()) {
//            Integer matchCount = lotto.countMatch(winningLotto.getLotto());
//            boolean bonusMatchCount = lotto.contains(winningLotto.getBonusBall());
//            addRankCount(matchCount, bonusMatchCount);
//        }
        List<Integer> lottoMatchCounts = lottos.calculateLottoMatchCounts(winningLotto);
        List<Boolean> bonusMatchs = lottos.calculateBonusMatchs(winningLotto);
        for(int i=0; i<lottoMatchCounts.size();i++){
            addRankCount(lottoMatchCounts.get(i),bonusMatchs.get(i));
        }
    }

    private void addRankCount(Integer matchCount, boolean bonusMatch) {
        Rank rank = Rank.findRank(matchCount, bonusMatch);
        rankResult.put(rank, rankResult.get(rank) + 1);
    }

    public Integer getRankCount(Rank rank) {
        return rankResult.get(rank);
    }
}
