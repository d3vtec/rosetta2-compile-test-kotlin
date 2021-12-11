import java.io.File
import java.util.concurrent.TimeUnit

fun main() {

    val times = mutableListOf<Long>()
    for(i in 1..20) {
        print(".")
        val before = System.currentTimeMillis()
        "./compile.sh".runCommand()
        val after = System.currentTimeMillis()
        times.add(after - before)
    }
    println()
    val average = times.average()
    times.forEach { println("  ${(it/1000.0).round()}s") }
    println("Average Runtime: ${(average/1000.0).round()}s")
}

fun Double.round(decimals: Int = 2): Double = "%.${decimals}f".format(this).toDouble()

fun String.runCommand(
    workingDir: File = File("."),
    timeoutAmount: Long = 60,
    timeoutUnit: TimeUnit = TimeUnit.SECONDS
): String? = runCatching {
    ProcessBuilder("\\s".toRegex().split(this))
        .directory(workingDir)
        .redirectOutput(ProcessBuilder.Redirect.PIPE)
        .redirectError(ProcessBuilder.Redirect.PIPE)
        .start().also { it.waitFor(timeoutAmount, timeoutUnit) }
        .inputStream.bufferedReader().readText()
}.onFailure { it.printStackTrace() }.getOrNull()