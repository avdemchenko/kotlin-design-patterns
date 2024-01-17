package behavioral.command

class OrderPayCommand(
    private val id: Long,
    private val resultWriter: ResultWriter,
) : OrderCommand {

    override fun execute() {
        resultWriter.addResult("Processing pay command with id: $id")
    }
}
