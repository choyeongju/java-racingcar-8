package racingcar;

import org.junit.jupiter.api.Test;
import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.service.common.NameParser;

import static org.assertj.core.api.Assertions.*;

class NameParserTest {
    @Test
    void 쉼표로_구분된_이름들을_파싱한다() {
        List<String> names = NameParser.parse("pobi,woni,jun");
        assertThat(names).containsExactly("pobi", "woni", "jun");
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,,jun", "   ", ",,,"})
    void 공백이나_빈_이름이_포함되면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> NameParser.parse(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 각_이름은_1자_이상_5자_이하여야_한다() {
        assertThatThrownBy(() -> NameParser.parse("pobi,toolong"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,pobi", "a,a", "woni,woni,jun"})
    void 중복된_이름이_있으면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> NameParser.parse(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}