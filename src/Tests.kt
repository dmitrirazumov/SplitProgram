import junit.framework.Assert.assertEquals
import org.junit.Test
import java.io.File

class Tests {

    //Проверяем правильность выходного файла
    private fun assertFileContent(name: String, expectedContent: String) {
        val file = File(name)
        val content = file.readLines().joinToString("\n")
        assertEquals(expectedContent, content)
    }

    @Test
    fun toFile() {
        toFile("temp", "line" + "\n" + "line2", 1)
        assertFileContent("temp1", "line" + "\n" + "line2")
        File("temp1").delete()
    }

    @Test
    fun fileQuantity() {
        val file = File.createTempFile("temp", ".txt", File("C:/Users/bigbo/IdeaProjects/Split"))
       file.writeText("Мама" + "\n" + "мыла" + "\n" + "раму")
        fileQuantity(file.canonicalPath, "result", 1)
        assertFileContent("result0", "Мама" + "\n" + "мыла" + "\n" + "раму")
        File(file.canonicalPath).deleteOnExit()
        File("result0").deleteOnExit()
    }

    @Test
    fun fileSizeSymbolTest() {
        val file = File.createTempFile("temp", ".txt", File("C:/Users/bigbo/IdeaProjects/Split"))
        file.writeText("Mum" + "\n" + "washed" + "\n" + "frame")
        try {
            fileSizeSymbol(file.canonicalPath, "file", 2)

        } finally {
            for (i in 0..6) {
                File("file" + i).deleteOnExit()
            }
            File(file.canonicalFile.toString()).deleteOnExit()
        }
    }

    @Test
    fun fileSizeString() {

        val file = File.createTempFile("temp", ".txt", File("C:/Users/bigbo/IdeaProjects/Split"))
        file.writeText("Мама" + "\n" + "мыла" + "\n" + "раму")
        try {
            fileSizeString(file.canonicalFile.toString(), "result", 1)
            assertFileContent("result0", "Мама")
            assertFileContent("result1", "мыла")
            assertFileContent("result2", "раму")
            File("result0").deleteOnExit()
            File("result1").deleteOnExit()
            File("result2").deleteOnExit()
        } finally {
            File(file.canonicalFile.toString()).deleteOnExit()
        }
    }


}