package racingcar.controller;

import service.Cars;
import service.RacingGame;
import service.RandomMoveStrategy;
import service.TryCount;
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
        String namesInput = inputView.readNames();
        String tryInput = inputView.readTryCount();

        Cars cars = Cars.of(namesInput);
        TryCount tryCount = TryCount.from(tryInput);
        RacingGame game = new RacingGame(cars);

        outputView.printExecutionHeader();

        for (int i = 0; i < tryCount.value(); i++) {
            game.raceOneRound(new RandomMoveStrategy());
            outputView.printRound(cars);
        }

        outputView.printWinners(cars.findWinners());
    }
}