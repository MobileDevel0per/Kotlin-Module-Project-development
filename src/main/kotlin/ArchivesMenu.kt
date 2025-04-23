class ArchivesMenu(
    classMenuItems: MutableList<String>,
    typeList: MutableList<Archive>
) : MenuNavigation<Archive>(classMenuItems, typeList) {
    override fun createType(typeName: String, typeList: MutableList<Archive>) {
        val archive = Archive(typeName)
        typeList.add(archive)
    }

    override fun handleSelection(userSelection: Int, typeList: MutableList<Archive>) {
        val notesMenuPoints = mutableListOf("0 - Создать заметку", "1 - Cозданная заметка","2 - Выход")
        val notesList = mutableListOf<Notes>()
        val notesMenu = NotesMenu(notesMenuPoints, typeList.get(userSelection).notelist)
        notesMenu.open()

    }
    override fun printList(typeList: MutableList<Archive>) {
        for(i in typeList.indices) {
            println("${i}: ${typeList[i].archiveName}")
        }
    }
}