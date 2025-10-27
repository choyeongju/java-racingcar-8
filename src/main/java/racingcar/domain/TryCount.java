package racingcar.domain;

import racingcar.service.common.ErrorMessage;

public class TryCount {
    private final int tryCountValue;

    private TryCount(int tryCountValue) {
        if (tryCountValue <= 0) {
            throw new IllegalArgumentException(ErrorMessage.TRYCOUNT_POSITIVE.message());
        }
        this.tryCountValue = tryCountValue;
    }

    public static TryCount from(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.TRYCOUNT_POSITIVE.message());
        }
        try {
            int parsedValue = Integer.parseInt(input.trim());
            return new TryCount(parsedValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.TRYCOUNT_POSITIVE.message());
        }
    }

    public int value() {
        return tryCountValue;
    }
}