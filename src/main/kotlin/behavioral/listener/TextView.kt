package behavioral.listener

import kotlin.properties.Delegates

class TextView {

    private val listeners = mutableListOf<TextChangedListener>()

    var text: String by Delegates.observable("<empty>") { _, old, new ->
        listeners.forEach { it.onTextChanged(old, new) }
    }

    fun addListener(listener: TextChangedListener) {
        listeners.add(listener)
    }
}
