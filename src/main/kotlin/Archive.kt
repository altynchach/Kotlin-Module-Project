class Archive(val archiveName: String) {
    init {
        if (archiveName.isBlank()) {
            println("Имя архива не может быть пустым. Пожалуйста, введите корректное имя.")
            throw IllegalArgumentException("Имя архива не может быть пустым.")
        }
    }
    val notes = mutableListOf<Note>()

}
