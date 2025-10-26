package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMoveStrategy implements MoveStrategy {
    @Override
    public boolean movable() {
        int n = Randoms.pickNumberInRange(GameRules.RANDOM_MIN, GameRules.RANDOM_MAX);
        return n >= GameRules.MOVE_THRESHOLD;
    }
}