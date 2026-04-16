//Kotlin
import kotlin.concurrent.thread

class ContaBancaria(var saldo: Double)

fun main() {
    val conta = ContaBancaria(100.0)
    println("Saldo Inicial: ${conta.saldo}")

    // Simulando dois saques simultâneos de 70.0
    val t1 = thread {
        val valorSaque = 70.0
        if (conta.saldo >= valorSaque) {
            Thread.sleep(100) // Simula atraso de processamento
            conta.saldo -= valorSaque
            println("Thread 1: Saque de $valorSaque realizado. Saldo: ${conta.saldo}")
        } else {
            println("Thread 1: Saldo insuficiente.")
        }
    }

    val t2 = thread {
        val valorSaque = 70.0
        if (conta.saldo >= valorSaque) {
            Thread.sleep(100) // Simula atraso de processamento
            conta.saldo -= valorSaque
            println("Thread 2: Saque de $valorSaque realizado. Saldo: ${conta.saldo}")
        } else {
            println("Thread 2: Saldo insuficiente.")
        }
    }

    t1.join()
    t2.join()

    println("Saldo Final: ${conta.saldo} (Deveria ser 30.0, mas provavelmente será -40.0)")
}