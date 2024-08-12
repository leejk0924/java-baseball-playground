package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashMap;
import java.util.function.BiFunction;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {
    private static final HashMap<String, BiFunction<Integer, Integer, Integer>> operations = new HashMap<>();

    @BeforeEach
    void setUp(){
        operations.put("+", (a, b) -> a + b);
        operations.put("-", (a, b) -> a - b);
        operations.put("*", (a, b) -> a * b);
        operations.put("/", (a, b) -> a / b);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "2 + 3 * 4 / 2 = 10",
            "5 - 2 / 3 * 7 = 7" }, delimiter = '=')
    void cal(String input, String expected) {
        String[] values = input.split(" ");
        int result = ofInteger(values[0]);

        for (int i = 1; i < values.length; i += 2) {
            result = operations.get(values[i]).apply(result, ofInteger(values[i+1]));
        }

        assertThat(result).isEqualTo(ofInteger(expected));
    }

    private int ofInteger(String number) {
        return Integer.parseInt(number);
    }
}
