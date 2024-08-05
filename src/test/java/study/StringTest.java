package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }
    @Test
    @DisplayName("split regex matched & contains test")
    void split_string_test_use_contains() {
        String target = "1,2";
        assertThat(target.split(",")).contains("1", "2");
    }
    @Test
    @DisplayName("split regex not matched test")
    void split_regex_(){
        String target = "1";
        String[] split = target.split(",");
        assertThat(split).containsExactly("1");
    }
    @Test
    @DisplayName("split regex matched & containsExactly test")
    void split_regex_matched_use_containsExactly() {
        String target = "1,2,3";
        String[] split = target.split(",");
        assertThat(split).containsExactly("1", "2", "3");
    }
    @Test
    @DisplayName("Delete bracket & split target test")
    void substringBracket() {
        String target = "(1,2)";
        String[] splitTarget = target.substring(1, 4).split(",");
        assertThat(splitTarget).contains("1", "2");
    }
    @Test
    @DisplayName("charAt() return index char")
    void charAt_return_target_index_of_character(){
        String target = "abc";
        assertThat(target.charAt(1)).isEqualTo('b');

        assertThrows(StringIndexOutOfBoundsException.class, () -> target.charAt(100));

        assertThatThrownBy(() -> {
            target.charAt(100);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);

        assertThat(catchThrowable(() -> target.charAt(100)))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
