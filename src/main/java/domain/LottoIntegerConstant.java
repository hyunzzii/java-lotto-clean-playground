package domain;

public enum LottoIntegerConstant {
    LOTTO_PRICE(1000),
    LOTTO_SIZE(6);
    
    private final Integer value;

    LottoIntegerConstant(Integer value){
        this.value = value;
    }

    private Integer getValue() {
        return value;
    }

    public static Integer of(LottoIntegerConstant constant) {
        return constant.getValue();
    }
}
