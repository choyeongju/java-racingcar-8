package racingcar.service.common;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NameParser {

    public static List<String> parse(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_NAMES);
        }

        List<String> carNames = Arrays.stream(input.split(","))
                .map(String::trim)
                .toList();

        if (carNames.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_NAMES);
        }

        Set<String> seen = new HashSet<>();
        for (String carName : carNames) {
            if (!seen.add(carName)) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NAME);
            }
        }

        for (String carName : carNames) {
            if (carName.isBlank() || carName.length() > GameRules.MAX_NAME_LENGTH) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_NAME_LENGTH);
            }
        }
        return carNames;
    }
}