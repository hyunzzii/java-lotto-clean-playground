package domain;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum Rank {
    NONE(0, 0,
            (matchCount, isBonus) -> matchCount < 3),
    FIFTH(5000, 3,
            (matchCount, isBonus) -> matchCount == 3),
    FOURTH(50000, 4,
            (matchCount, isBonus) -> matchCount == 4),
    THIRD(1500000, 5,
            (matchCount, isBonus) -> matchCount == 5 && !isBonus),
    SECOND(30000000, 5,
            (matchCount, isBonus) -> matchCount == 5 && isBonus),
    FIRST(2000000000, 6,
            (matchCount, isBonus) -> matchCount == 6);

    private final Integer prize;
    private final Integer matchNum;
    private final BiPredicate<Integer, Boolean> condition;

    Rank(Integer prize, Integer matchNum, BiPredicate<Integer, Boolean> condition) {
        this.prize = prize;
        this.matchNum = matchNum;
        this.condition = condition;
    }

    public Integer getPrize() {
        return prize;
    }

    public Integer getMatchCount() {
        return matchNum;
    }

    public boolean test(Integer match, boolean bonus){
        return condition.test(match, bonus);
    }

    public static Rank findRank(Integer match, boolean bonusMatch) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.test(match,bonusMatch))
                .findAny()
                .orElse(NONE);
    }
}
