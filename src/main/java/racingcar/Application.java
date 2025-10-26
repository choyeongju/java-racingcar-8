package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        try {
            String namesInput = readNames();
            String tryInput = readTryCount();

            Cars cars = Cars.of(namesInput);
            TryCount tryCount = TryCount.from(tryInput);
            RacingGame game = new RacingGame(cars);

            System.out.println();
            System.out.println("실행 결과");

            for (int i = 0; i < tryCount.value(); i++) {
                game.raceOneRound(new RandomMoveStrategy());
                printRound(cars);
                System.out.println();
            }
            printWinners(cars);
        } finally {
            Console.close();
        }
    }

    private static String readNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    private static String readTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Console.readLine();
    }

    private static void printRound(Cars cars) {
        for (Car c : cars.list()) {
            String bar = "-".repeat(c.getPosition());
            System.out.println(c.getName() + " : " + bar);
        }
    }

    private static void printWinners(Cars cars) {
        String winners = cars.findWinners().stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println("최종 우승자 : " + winners);
    }
}