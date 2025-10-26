package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.TryCount;

import static org.assertj.core.api.Assertions.*;

class TryCountTest {

    @Test
    void 시도_횟수는_자연수여야_한다() {
        assertThatThrownBy(() -> TryCount.from("0"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> TryCount.from("-3"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> TryCount.from("abc"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThat(TryCount.from("5").value()).isEqualTo(5);
    }
}