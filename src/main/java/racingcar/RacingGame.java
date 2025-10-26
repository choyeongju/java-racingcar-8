package racingcar;

class RacingGame {
    private final Cars cars;

    RacingGame(Cars cars) {
        this.cars = cars;
    }

    void raceOneRound(MoveStrategy moveStrategy) {
        for (Car car : cars.list()) {
            car.moveIf(moveStrategy);
        }
    }
}