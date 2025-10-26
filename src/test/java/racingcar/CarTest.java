package racingcar;

import org.junit.jupiter.api.Test;
import service.Car;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    @Test
    void 자동차는_이름을_가진다() {
        Car car = new Car("pobi");
        assertThat(car.getName()).isEqualTo("pobi");
        assertThat(car.getPosition()).isZero();
    }

    @Test
    void 이름이_1에서_5자가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new Car(""))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Car("abcdefg"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이동_조건이_참이면_전진하고_거짓이면_정지한다() {
        Car car = new Car("pobi");
        car.moveIf(() -> true);
        car.moveIf(() -> false);
        car.moveIf(() -> true);
        assertThat(car.getPosition()).isEqualTo(2);
    }
}