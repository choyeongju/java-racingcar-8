package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.TryCount;

import static org.assertj.core.api.Assertions.*;

class TryCountTest {
    @ParameterizedTest
    @ValueSource(strings = {"0", "-3", "abc", " ", ""})
    void 시도_횟수는_자연수여야_한다(String input) {
        assertThatThrownBy(() -> TryCount.from(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 유효한_숫자_입력은_TryCount_객체로_변환된다() {
        TryCount tryCount = TryCount.from("5");
        assertThat(tryCount.value()).isEqualTo(5);
    }
}