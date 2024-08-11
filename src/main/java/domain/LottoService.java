package domain;

import java.util.stream.Collectors;

public class LottoService {
    private final NumberGenerator numberGenerator;
    private final Lottos lottos;

    public LottoService(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
        this.lottos = new Lottos();
    }

    public void makeLottos(Integer count){
        while(count-- > 0) {
            Lotto lotto = new Lotto(
                    numberGenerator.generate().stream().map(LottoNumber::new).collect(Collectors.toList())
            );
            lottos.addLotto(lotto);
        }
    }

    public Result calculateResult(WinningLotto winningLotto){
        return new Result(lottos, winningLotto);
    }
}
