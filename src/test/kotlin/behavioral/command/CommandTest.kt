package behavioral.command

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CommandTest {

    @Test
    fun `should execute command`() {
        // given
        val resultWriter = ResultWriter()

        // when
        CommandProcessor()
            .addToQueue(OrderAddCommand(1L, resultWriter))
            .addToQueue(OrderAddCommand(2L, resultWriter))
            .addToQueue(OrderPayCommand(2L, resultWriter))
            .addToQueue(OrderPayCommand(1L, resultWriter))
            .processCommands()

        // then
        val results = resultWriter.getResults()
        assertThat(results).contains(
            "Processing add command with id: 1",
            "Processing add command with id: 2",
            "Processing pay command with id: 2",
            "Processing pay command with id: 1"
        )
    }
}
