class Produto(val nome: String) {
    var preco: Double = 0.0
        set(value) {
            if (value >= 0) {
                field = value
                println("Preço do produto '$nome' atualizado para R$ $field")
            } else {
                println("Erro: O preço não pode ser negativo! (Tentativa: R$ $value)")
            }
        }
}

fun main() {
    println("--- Testando Exercício 7: Produto ---")
    val teclado = Produto("Teclado Mecânico")
    teclado.preco = 150.0 // Válido
    teclado.preco = -50.0 // Inválido, vai exibir erro
    println("Preço final do ${teclado.nome}: R$ ${teclado.preco}\n")
}



class ContaBancaria(val titular: String) {
    var saldo: Double = 0.0
        private set
  
    fun depositar(valor: Double) {
        if (valor > 0) {
            saldo += valor
            println("Depósito de R$ $valor realizado. Saldo atual: R$ $saldo")
        }
    }

    fun sacar(valor: Double) {
        if (valor <= saldo) {
            saldo -= valor
            println("Saque de R$ $valor realizado. Saldo atual: R$ $saldo")
        } else {
            println("Erro: Saldo insuficiente para sacar R$ $valor. Saldo atual: R$ $saldo")
        }
    }

}

fun main(){

    println("--- Testando Exercício 8: Conta Bancária ---")
    val conta = ContaBancaria("Marcelo Santana Jr.")
    conta.depositar(500.0)
    conta.sacar(200.0) // Válido
    conta.sacar(400.0) // Inválido (saldo será 300)
    println()
    
}    