class ArchiveManager(private val menuManager: MenuManager, private val noteManager: NoteManager) {
    val archives = mutableListOf<Archive>()

    fun createArchive() {
        var archiveName: String
        do {
            archiveName = menuManager.getUserInput("Введите имя архива:")
            if (archiveName.isBlank()) {
                println("Имя архива не может быть пустым. Пожалуйста, введите корректное имя.")
            }
        } while (archiveName.isBlank()) // Повторять, пока имя архива не будет корректным
        val archive = Archive(archiveName)
        archives.add(archive)
        println("Архив $archiveName создан.")
    }


    fun selectArchive() {
        if (archives.isEmpty()) {
            println("Нет архивов. Создайте новый.")
            createArchive()
            return
        }
        val archiveOptions = archives.map { it.archiveName } + "Создать архив" + "Выход"
        val archiveId = menuManager.showMenu(archiveOptions, "Выберите архив или действие:")
        when (archiveId) {
            archives.size + 1 -> createArchive()
            archives.size + 2 -> return
            else -> noteManager.manageNotes(archives[archiveId - 1])
        }
    }
}