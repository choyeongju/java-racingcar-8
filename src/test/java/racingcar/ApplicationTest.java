package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    String out = output();
                    assertThat(out).contains("실행 결과");
                    assertThat(out).contains("pobi : -", "woni : ");
                    assertThat(out).contains("최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 여러_회차_진행_및_공동우승자_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "3");
                    String out = output();

                    assertThat(out).contains("실행 결과");
                    assertThat(out).contains("pobi : --");
                    assertThat(out).contains("jun : --");
                    assertThat(out).contains("최종 우승자 : pobi, jun");
                },
                4, 3, 4,
                4, 3, 4,
                4, 3, 4
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입출력_흐름_테스트() {
        run("pobi,woni,jun", "2");
        String out = output();
        assertThat(out).contains("경주할 자동차 이름을 입력하세요");
        assertThat(out).contains("시도할 횟수는 몇 회인가요?");
        assertThat(out).contains("실행 결과");
        assertThat(out).contains("최종 우승자 :");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}