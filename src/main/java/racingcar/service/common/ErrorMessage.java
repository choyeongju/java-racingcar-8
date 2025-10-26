package racingcar.service.common;

public final class ErrorMessage {
    private ErrorMessage() {}

    public static final String EMPTY_NAMES = "이름은 비어 있을 수 없습니다.";
    public static final String INVALID_NAME_LENGTH = "각 이름은 1~5자여야 합니다.";
    public static final String TRYCOUNT_POSITIVE = "시도 횟수는 자연수여야 합니다.";
    public static final String CAR_NOT_FOUND = "해당 이름의 자동차를 찾을 수 없습니다.";
    public static final String DUPLICATE_NAME = "중복된 자동차 이름은 허용되지 않습니다.";
}