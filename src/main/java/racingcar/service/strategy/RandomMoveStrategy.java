package racingcar.service.strategy;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.service.common.GameRules;

public class RandomMoveStrategy implements MoveStrategy {
    @Override
    public boolean movable() {
        int n = Randoms.pickNumberInRange(GameRules.RANDOM_MIN.value(), GameRules.RANDOM_MAX.value());
        return n >= GameRules.MOVE_THRESHOLD.value();
    }
}