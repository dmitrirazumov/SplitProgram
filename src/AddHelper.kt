import java.io.File

fun fileSizeString(inputFile: String, outputFile: String, fileSizeString: Int) {
    val result = StringBuilder()
    var k = 0
    var m = 0
    for (line in File(inputFile).readLines()) {
        result.append(line + "\n")
        k += 1
        if (k == fileSizeString) {
            toFile(outputFile, result.toString(), m)
            m += 1
            k = 0
            result.delete(0, result.length)
        }
    }
}

fun fileSizeSymbol(inputFile: String, outputFile: String, fileSizeSymbol: Int) {
    val result = StringBuilder()
    var k = 0
    var m = 0
    for (byte in File(inputFile).readBytes()) {

        result.append((byte + 76).toChar().toString())
        k += 1
        if (k == fileSizeSymbol) {
            toFile(outputFile, result.toString(), m)
            m += 1
            k = 0
            result.delete(0, result.length)
        }
    }
}

fun fileQuantity(inputFile: String, outputFile: String, fileQuantity: Int) {
    val result = StringBuilder()
    var k = 0
    var m = 0
    for (line in File(inputFile).readLines()) {
        result.append(line + "\n")
        k += 1
        if (k == 100) {
            toFile(outputFile, result.toString(), m)
            m += 1
            k = 0
        }
    }
    if (k < 100) {
        toFile(outputFile, result.toString(), m)
        m += 1
    }
}

//Добавляем строки в файл
fun toFile(outputFile: String, line: String, m: Int) {
    var outputFileName = ""
    if (Split.getChangeName() != false) outputFileName = outputFile + m
    else outputFileName = outputFile + ('a' + m)
    val writer = File(outputFileName).bufferedWriter()
    writer.write(line)
    writer.close()
}