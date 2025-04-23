import java.util.Scanner

abstract class MenuNavigation<T>(val classMenuItems: MutableList<String>, val typeList: MutableList<T>) {
    val menuItems = classMenuItems
    private val items = mutableListOf<T>()

    fun open() {

        while (true) {
            println(menuItems)
            println("Выбери пункт меню")
            val userInput = Scanner(System.`in`).nextLine()
            if (userInput.toIntOrNull() != null) {
                val menuNumber = userInput.toInt()
                if (menuNumber == 0) {
                    while (true) {
                        println("Введи имя")
                        val typeName = Scanner(System.`in`).nextLine()
                        val trimedName = typeName.trim()
                        if (trimedName != "") {
                            createType(typeName, typeList)
                            break
                        } else {
                            println("Имя пользователя не может быть пустым")
                            continue
                        }

                    }
                } else if (menuNumber == 1) {

                    if (typeList.size == 0) {
                        println("Ни одного элемента не создано")
                        continue
                    }
                    printList(typeList)
                    while (true) {
                        println("Введи порядковый номер или Hазад")
                        val choosedElement = Scanner(System.`in`).nextLine()
                        if (choosedElement == "Назад") {
                            break
                        } else if (choosedElement.toIntOrNull() == null) {
                            println("Необходим ввод цифры")
                            continue
                        } else if (choosedElement.toInt() < typeList.size && choosedElement.toInt() >= 0) {
                            handleSelection(choosedElement.toInt(), typeList)
                            break
                        }  else {
                            println("Такой цифры нет")
                            continue
                        }
                    }
                    //todo
                } else if(menuNumber == 2) {
                    println("Выход")
                    return
                } else {
                    println("Такой цифры нет")
                }
            } else {
                println("Необходим ввод цифры")
                continue
            } //todo
        }
    }
    abstract fun createType(typeName: String, typeList: MutableList<T>)
    abstract fun handleSelection(userSelection: Int, typeList: MutableList<T>)
    abstract fun printList(typeList: MutableList<T>)
}