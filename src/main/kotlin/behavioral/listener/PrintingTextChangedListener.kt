package behavioral.listener

class PrintingTextChangedListener : TextChangedListener {

    var text = ""

    override fun onTextChanged(oldText: String, newText: String) {
        text = "Text has been changed: $oldText -> $newText"
    }
}
