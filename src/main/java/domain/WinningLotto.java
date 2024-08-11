package domain;

import java.util.List;

public class WinningLotto {
    private final Lotto lotto;
    private final LottoNumber bonusBall;

    public WinningLotto(final Lotto lotto, final LottoNumber bonousBall){
        this.lotto = lotto;
        this.bonusBall = bonousBall;
    }

    public Lotto getLotto(){
        return lotto;
    }

    public LottoNumber getBonusBall(){
        return bonusBall;
    }
}
