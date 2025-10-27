package racingcar.service.common;

public enum GameRules {
    RANDOM_MIN(0),
    RANDOM_MAX(9),
    MOVE_THRESHOLD(4),
    MAX_NAME_LENGTH(5);

    private final int value;

    GameRules(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}