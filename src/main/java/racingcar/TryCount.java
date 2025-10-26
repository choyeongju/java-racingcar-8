package racingcar;

class TryCount {
    private final int tryCountValue;

    private TryCount(int tryCountValue) {
        if (tryCountValue <= 0) {
            throw new IllegalArgumentException("시도 횟수는 자연수여야 합니다.");
        }
        this.tryCountValue = tryCountValue;
    }

    static TryCount from(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("시도 횟수는 자연수여야 합니다.");
        }

        try {
            int parsedValue = Integer.parseInt(input.trim());
            return new TryCount(parsedValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 자연수여야 합니다.");
        }
    }

    int value() {
        return tryCountValue;
    }
}