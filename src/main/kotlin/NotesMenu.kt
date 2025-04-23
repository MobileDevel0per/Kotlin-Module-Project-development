import java.util.Scanner

class NotesMenu(
    classMenuItems: MutableList<String>,
    typeList: MutableList<Notes>
) : MenuNavigation<Notes>(classMenuItems, typeList) {

    override fun createType(typeName: String, typeList: MutableList<Notes>) {
        val notes = Notes(typeName)
        while (true) {
            println("Введи текст заметки")
            val notesText = Scanner(System.`in`).nextLine() // Исправлено здесь
            val trimmedText = notesText.trim()
            if (trimmedText != "") {
                notes.text = notesText
                typeList.add(notes)
                break
            } else {
                println("Текст заметки не может быть пустым")
            }
        }
    }

    override fun handleSelection(userSelection: Int, typeList: MutableList<Notes>) {
        val selectedName = typeList[userSelection].notesName
        println("$selectedName")
        val notesText = typeList[userSelection].text
        println("$notesText")
    }

    override fun printList(typeList: MutableList<Notes>) {
        for (i in typeList.indices) {
            println("$i: ${typeList[i].notesName}")
        }
    }
}