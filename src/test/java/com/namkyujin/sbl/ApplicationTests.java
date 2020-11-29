package com.namkyujin.sbl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(OutputCaptureExtension.class)
class ApplicationTests {

    @DisplayName("디버그, 트레이스 로그는 남기지 않음.")
    @Test
    void test1(CapturedOutput output) {
        //when
        Application.main(new String[0]);

        //then
        assertThat(output)
                .contains(Application.ERROR_MESSAGE)
                .contains(Application.WARN_MESSAGE)
                .contains(Application.INFO_MESSAGE)

                .doesNotContain(Application.DEBUG_MESSAGE)
                .doesNotContain(Application.TRACE_MESSAGE);
    }

    @DisplayName("지정 된 패키지의 디버그, 트레이스 로그를 남김")
    @Test
    void test2(CapturedOutput output) {
        //when
        Application.main(new String[] { "--logging.level.com.namkyujin=trace" });

        //then
        assertThat(output)
                .contains(Application.ERROR_MESSAGE)
                .contains(Application.WARN_MESSAGE)
                .contains(Application.INFO_MESSAGE)
                .contains(Application.DEBUG_MESSAGE)
                .contains(Application.TRACE_MESSAGE);
    }
}
