package racingcar.service;

public class RacingGame {
    private final Cars cars;

    public RacingGame(Cars cars) {
        this.cars = cars;
    }

    public void raceOneRound(MoveStrategy moveStrategy) {
        for (Car car : cars.list()) {
            car.moveIf(moveStrategy);
        }
    }
}