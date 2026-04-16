Kotlin
import kotlinx.coroutines.*

class ContaCoroutines(var saldo: Double)

fun main() = runBlocking { // Escopo principal
    val conta = ContaCoroutines(100.0)
    
    // Usando um Mutex para resolver o problema da aula anterior de forma elegante
    val mutex = kotlinx.coroutines.sync.Mutex()

    val job1 = launch(Dispatchers.Default) {
        val valor = 70.0
        mutex.withLock {
            if (conta.saldo >= valor) {
                delay(100) // Suspensão, não bloqueio!
                conta.saldo -= valor
                println("Coroutine 1: Sucesso. Saldo: ${conta.saldo}")
            }
        }
    }

    val job2 = launch(Dispatchers.Default) {
        val valor = 70.0
        mutex.withLock {
            if (conta.saldo >= valor) {
                delay(100)
                conta.saldo -= valor
                println("Coroutine 2: Sucesso. Saldo: ${conta.saldo}")
            } else {
                println("Coroutine 2: Saldo insuficiente!")
            }
        }
    }

    // Aguarda ambas terminarem
    joinAll(job1, job2)
    println("Saldo Final Seguro: ${conta.saldo}")
}