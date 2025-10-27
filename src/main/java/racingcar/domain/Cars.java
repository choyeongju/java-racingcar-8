package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import racingcar.service.common.ErrorMessage;
import racingcar.service.common.NameParser;

public class Cars {
    private final List<Car> carList = new ArrayList<>();

    private Cars() {
    }

    public static Cars of(String rawCarNames) {
        Cars cars = new Cars();
        for (String carName : NameParser.parse(rawCarNames)) {
            cars.carList.add(new Car(carName));
        }
        return cars;
    }

    public List<Car> list() {
        return Collections.unmodifiableList(carList);
    }

    public List<Car> findWinners() {
        int maxPosition = carList.stream()
                .max(Comparator.comparingInt(Car::getPosition))
                .map(Car::getPosition)
                .orElse(0);

        List<Car> winners = new ArrayList<>();
        for (Car car : carList) {
            if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }
        return winners;
    }

    public Car findByName(String targetName) {
        return carList.stream()
                .filter(car -> car.getName().equals(targetName))
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException(ErrorMessage.CAR_NOT_FOUND.message())
                );
    }
}