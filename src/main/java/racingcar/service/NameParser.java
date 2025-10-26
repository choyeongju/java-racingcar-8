package racingcar.service;

import java.util.Arrays;
import java.util.List;

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

        for (String carName : carNames) {
            if (carName.isBlank() || carName.length() > GameRules.MAX_NAME_LENGTH) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_NAME_LENGTH);
            }
        }
        return carNames;
    }
}