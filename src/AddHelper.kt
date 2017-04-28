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
        if (byte.toInt() != 10) {
            result.append(byte.toChar())
            k += 1
        }
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
    var f = 0
    for (line in File(inputFile).readLines()) {
        result.append(line + "\n")
        k += 1
        if (k == 100 && f < fileQuantity) {
            toFile(outputFile, result.toString(), m)
            m += 1
            f += 1
            k = 0
            result.delete(0, result.length)
        }
    }
    if (k < 100 && k != 0 && f < fileQuantity) {
        toFile(outputFile, result.toString(), m)
        m += 1
        f += 1
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