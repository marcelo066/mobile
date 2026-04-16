Kotlin
import kotlin.concurrent.thread

fun main() {
    println("Iniciando o teste de Threads... Olhe o Gerenciador de Tarefas!")
    repeat(10_000) { i ->
        thread {
            Thread.sleep(1000000L) // Faz a thread ficar viva mas ociosa
        }
        if (i % 1000 == 0) println("$i threads criadas...")
    }
}