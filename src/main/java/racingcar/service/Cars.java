package racingcar.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Cars {
    private final List<Car> carList = new ArrayList<>();

    public static Cars of(String rawCarNames) {
        Cars cars = new Cars();
        for (String carName : NameParser.parse(rawCarNames)) {
            cars.carList.add(new Car(carName));
        }
        return cars;
    }

    public List<Car> list() {
        return carList;
    }
    public List<Car> findWinners() {
        int maxPosition = carList.stream()
                .max(Comparator.comparingInt(Car::getPosition))
                .map(Car::getPosition)
                .orElse(0);

        List<Car> result = new ArrayList<>();
        for (Car car : carList) {
            if (car.getPosition() == maxPosition) {
                result.add(car);
            }
        }
        return result;
    }

    public Car findByName(String targetName) {
        return carList.stream()
                .filter(car -> car.getName().equals(targetName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 이름의 자동차를 찾을 수 없습니다."));
    }
}