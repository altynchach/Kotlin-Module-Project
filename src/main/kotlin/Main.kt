import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val menuManager = MenuManager(scanner)
    val noteManager = NoteManager(menuManager)
    val archiveManager = ArchiveManager(menuManager, noteManager)
    var isRunning = true

    while (isRunning) {
        val mainMenu = listOf("Выбор архива", "Выход из приложения")
        val choice = menuManager.showMenu(mainMenu, "Главный экран:")
        when (choice) {
            1 -> archiveManager.selectArchive()
            2 -> isRunning = false
        }
    }
}

