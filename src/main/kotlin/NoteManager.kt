class NoteManager(private val menuManager: MenuManager) {
    fun manageNotes(archive: Archive) {
        while (true) {
            if (archive.notes.isEmpty()) {
                println("Нет заметок. Создайте новую.")
            }
            val noteOptions = archive.notes.map { it.noteName } + "Создать заметку" + "Выход"
            val noteId = menuManager.showMenu(noteOptions, "Выберите заметку в архиве или действие:")
            when (noteId) {
                archive.notes.size + 1 -> addNoteToArchive(archive)
                archive.notes.size + 2 -> return
                else -> viewNote(archive.notes[noteId - 1])
            }
        }
    }

    fun addNoteToArchive(archive: Archive) {
        val noteName = menuManager.getUserInput("Введите название заметки:")
        val content = menuManager.getUserInput("Введите содержимое заметки:")
        val note = Note(noteName, content)
        archive.notes.add(note)
        println("Заметка '$noteName' добавлена в архив '${archive.archiveName}'.")
    }

    fun viewNote(note: Note) {
        println("Заметка: ${note.noteName}\nСодержимое: ${note.content}")}}
