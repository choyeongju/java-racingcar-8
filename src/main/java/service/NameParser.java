package service;

import java.util.Arrays;
import java.util.List;

public class NameParser {

    public static List<String> parse(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("이름은 비어 있을 수 없습니다.");
        }

        List<String> carNames = Arrays.stream(input.split(","))
                .map(String::trim)
                .toList();

        if (carNames.isEmpty()) {
            throw new IllegalArgumentException("이름은 비어 있을 수 없습니다.");
        }

        for (String carName : carNames) {
            if (carName.isBlank() || carName.length() > 5) {
                throw new IllegalArgumentException("각 이름은 1~5자여야 합니다.");
            }
        }

        return carNames;
    }
}