package racingcar.domain;

import racingcar.service.common.ErrorMessage;
import racingcar.service.common.GameRules;
import racingcar.service.strategy.MoveStrategy;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NAME_LENGTH);
        }
        if (name.length() > GameRules.MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NAME_LENGTH);
        }
        this.name = name;
    }

    public String getName() { return name; }

    public int getPosition() { return position; }

    public void moveIf(MoveStrategy strategy) {
        if (strategy.movable()) {
            position++;
        }
    }
}