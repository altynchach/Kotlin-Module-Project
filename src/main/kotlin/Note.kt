class Note(val noteName: String, val content: String) {
    init {
        require(noteName.isNotBlank()) { "Название заметки не может быть пустое." }
        require(content.isNotBlank()) { "Содержимое заметки не может быть пустым." }
    }
}

