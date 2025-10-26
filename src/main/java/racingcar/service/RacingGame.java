package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.service.strategy.MoveStrategy;

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