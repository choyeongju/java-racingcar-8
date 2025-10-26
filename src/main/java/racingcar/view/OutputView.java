package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.service.Car;
import racingcar.service.Cars;
public class OutputView {

    public void printExecutionHeader() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printRound(Cars cars) {
        for (Car car : cars.list()) {
            String bar = "-".repeat(car.getPosition());
            System.out.println(car.getName() + " : " + bar);
        }
        System.out.println();
    }

    public void printWinners(List<Car> winners) {
        String names = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println("최종 우승자 : " + names);
    }
}