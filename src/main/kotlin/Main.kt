fun main(args: Array<String>) {
    val menuPoints = mutableListOf("0 - Создать архив", "1 - Cозданный архив","2 - Выход")
    val archiveList = mutableListOf<Archive>()
    val archiveMenu = ArchivesMenu(menuPoints, archiveList)
    archiveMenu.open()


}