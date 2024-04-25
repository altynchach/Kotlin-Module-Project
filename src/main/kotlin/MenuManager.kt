import java.util.Scanner

class MenuManager(private val scanner: Scanner) {
    fun showMenu(options: List<String>, prompt: String): Int {
        println(prompt)
        for (i in options.indices) {
            println("${i + 1}. ${options[i]}")
        }
        return getUserChoice(options.size)
    }

    fun getUserInput(prompt: String): String {
        println(prompt)
        return scanner.nextLine()
    }

    fun validateInput(input: String, range: IntRange): Int {
        val inputInt = input.toIntOrNull()
        if (inputInt != null && inputInt in range) {
            return inputInt
        }
        return -1
    }

    private fun getUserChoice(menuSize: Int): Int {
        var choice = -1
        while (choice == -1) {
            val input = getUserInput("Введите ваш выбор:")
            choice = validateInput(input, 1..menuSize)
            if (choice == -1) {
                println("Введите, пожалуйста, номер пункта меню. Попробуйте еще раз.")
            }
        }
        return choice
    }
}

