package domain;

public enum ErrorMessage {
    INVALID_LOTTO_NUMBER("당첨 번호의 범위가 유효하지 않습니다.(1 ~ 45)"),
    INVALID_LOTTO_SIZE("로또 숫자의 개수는 6개 입니다.");

    private final String message;

    ErrorMessage(String message){
        this.message = message;
    }

    private String getMessage() {
        return message;
    }

    public static String of(ErrorMessage errorMessage) {
        return errorMessage.getMessage();
    }
}
