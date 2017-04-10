import junit.framework.Assert.assertEquals
import org.junit.Test
import java.io.File

class Tests {


    private fun assertFileContent(name: String, expectedContent: String) {
        val file = File(name)
        val content = file.readLines().joinToString("\n")
        assertEquals(expectedContent, content)
    }

    @Test
    fun toFile() {
        toFile("temp.txt", "line" + "\n" + "line2", 1)
        assertFileContent("temp.txt", "line" + "\n" + "line2")
        File("temp.txt").delete()
    }

    @Test
    fun fileQuantitu() {
        val file = File.createTempFile("temp", ".txt", File("C:/Users/bigbo/IdeaProjects/Split"))
        file.writeText("Мама" + "\n" + "мыла" + "\n" + "раму")
        fileQuantity(file.canonicalPath, "result.txt", 1)
        assertFileContent("result.txt", "Мама" + "\n" + "мыла" + "\n" + "раму")
        File(file.canonicalPath).deleteOnExit()
        File("result.txt").deleteOnExit()
    }

    @Test
    fun fileSizeSymbolTest() {
        val file = File.createTempFile("temp", ".txt", File("C:/Users/bigbo/IdeaProjects/Split"))
        file.writeText("Мама" + "\n" + "мыла" + "\n" + "раму")
        try {
            fileSizeSymbol(file.canonicalPath, "file", 2)

        } finally {
            File(file.canonicalFile.toString()).deleteOnExit()
        }
    }

    @Test
    fun fileSizeStriing() {

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