package behavioral.listener

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ListenerTest {

    @Test
    fun `should listen an event`() {
        // given
        val listener = PrintingTextChangedListener()

        // and
        val textView = TextView().apply {
            addListener(listener)
        }

        // when
        with(textView) {
            text = "Lorem ipsum"
            text = "dolor sit amet"
        }

        // then
        assertThat(listener.text).isEqualTo("Text has been changed: Lorem ipsum -> dolor sit amet")
    }
}