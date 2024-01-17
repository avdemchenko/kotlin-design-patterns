package behavioral.strategy

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StrategyTest {

    @Test
    fun `should apply strategy`() {
        // given
        val inputString = "lOrEM iPsum DOlOR Sit amEt"

        // when
        val lowerCaseConverter = Converter(lowerCaseFormatter).convert(inputString)
        val upperCaseConverter = Converter(upperCaseFormatter).convert(inputString)

        // then
        assertThat(lowerCaseConverter).isEqualTo("lorem ipsum dolor sit amet")
        assertThat(upperCaseConverter).isEqualTo("LOREM IPSUM DOLOR SIT AMET")
    }
}
