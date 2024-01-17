package behavioral.command

class OrderAddCommand(
    private val id: Long,
    private val resultWriter: ResultWriter,
) : OrderCommand {

    override fun execute() {
        resultWriter.addResult("Processing add command with id: $id")
    }
}
