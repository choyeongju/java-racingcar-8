package racingcar.service.strategy;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.service.common.GameRules;

public class RandomMoveStrategy implements MoveStrategy {
    @Override
    public boolean movable() {
        int n = Randoms.pickNumberInRange(GameRules.RANDOM_MIN, GameRules.RANDOM_MAX);
        return n >= GameRules.MOVE_THRESHOLD;
    }
}