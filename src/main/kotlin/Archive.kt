class Archive(val archiveName: String) {
    init {
        require(archiveName.isNotBlank()) { "Имя архива не может быть пустым." }
    }
    val notes = mutableListOf<Note>()
}
