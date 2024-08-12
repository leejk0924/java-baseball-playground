package baseball;

import baseball.service.BaseballService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BaseballServiceTest {
    BaseballService baseballService = new BaseballService();

    @DisplayName("validRestart()_success_테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:false"}, delimiter = ':')
    void validRestartTest(int input, String expected) {
            assertThat(baseballService.validRestart(input)).isEqualTo(Boolean.parseBoolean(expected));
    }

    @DisplayName("validRestart_예외처리_테스트")
    @Test
    void validRestartExceptionTest() {
        assertThatThrownBy(
                () -> baseballService.validRestart(3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효하지 않는 값입니다.");
    }

    @DisplayName("validInputNumber()_success_테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:false", "2:false", "3:true"}, delimiter = ':')
    void validInputNumberTest(int input, String expected) {
        assertThat(baseballService.validateInputNumber(input)).isEqualTo(Boolean.parseBoolean(expected));
    }
}
