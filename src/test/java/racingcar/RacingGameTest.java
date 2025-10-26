package racingcar;

import org.junit.jupiter.api.Test;

import java.util.List;
import racingcar.service.Car;
import racingcar.service.Cars;
import racingcar.service.MoveStrategy;
import racingcar.service.RacingGame;

import static org.assertj.core.api.Assertions.*;

class RacingGameTest {

    @Test
    void 주어진_횟수만큼_라운드를_진행한다() {
        Cars cars = Cars.of("pobi,woni");
        RacingGame game = new RacingGame(cars);

        List<MoveStrategy> roundStrategies = List.of(
                () -> true,
                () -> false,
                () -> true
        );

        for (MoveStrategy strategy : roundStrategies) {
            game.raceOneRound(strategy);
        }

        assertThat(cars.findByName("pobi").getPosition()).isEqualTo(2);
        assertThat(cars.findByName("woni").getPosition()).isEqualTo(2);
    }

    @Test
    void 우승자는_최대_거리_기준이며_공동_우승이_가능하다() {
        Cars cars = Cars.of("pobi,woni,jun");
        RacingGame game = new RacingGame(cars);

        List<List<Boolean>> roundMoves = List.of(
                List.of(true, false, false),
                List.of(false, false, true),
                List.of(true, false, true)
        );

        for (List<Boolean> moves : roundMoves) {
            game.raceOneRound(sequentialStrategy(moves));
        }

        List<Car> winners = cars.findWinners();
        assertThat(winners).extracting(Car::getName)
                .containsExactlyInAnyOrder("pobi", "jun");
    }

    private MoveStrategy sequentialStrategy(List<Boolean> moves) {
        return new MoveStrategy() {
            int idx = 0;

            @Override
            public boolean movable() {
                return moves.get(idx++);
            }
        };
    }
}