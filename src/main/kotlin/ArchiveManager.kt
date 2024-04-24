class ArchiveManager(private val menuManager: MenuManager, private val noteManager: NoteManager) {
    val archives = mutableListOf<Archive>()

    fun createArchive() {
        val archiveName = menuManager.getUserInput("Введите имя архива:")
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