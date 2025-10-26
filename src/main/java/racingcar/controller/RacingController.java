package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.TryCount;
import racingcar.service.*;
import racingcar.service.strategy.RandomMoveStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        String carNamesInput = inputView.readCarNames();
        String tryCountInput = inputView.readTryCount();

        Cars cars = Cars.of(carNamesInput);
        TryCount tryCount = TryCount.from(tryCountInput);
        RacingGame racingGame = new RacingGame(cars);

        outputView.printExecutionHeader();

        for (int i = 0; i < tryCount.value(); i++) {
            racingGame.raceOneRound(new RandomMoveStrategy());
            outputView.printRound(cars);
        }

        outputView.printWinners(cars.findWinners());
    }
}