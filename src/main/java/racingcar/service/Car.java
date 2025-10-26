package racingcar.service;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("이름은 1~5자여야 합니다.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 1~5자여야 합니다.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void moveIf(MoveStrategy strategy) {
        if (strategy.movable()) {
            position++;
        }
    }
}