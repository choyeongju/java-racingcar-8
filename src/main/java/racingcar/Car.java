package racingcar;

class Car {
    private final String name;
    private int position = 0;

    Car(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("이름은 1~5자여야 합니다.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 1~5자여야 합니다.");
        }
        this.name = name;
    }

    String getName() {
        return name;
    }

    int getPosition() {
        return position;
    }

    void moveIf(MoveStrategy strategy) {
        if (strategy.movable()) {
            position++;
        }
    }
}