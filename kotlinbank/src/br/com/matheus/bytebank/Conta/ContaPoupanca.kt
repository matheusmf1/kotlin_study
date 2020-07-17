package Conta

class ContaPoupanca ( titular: String, numero: Int) : Conta( titular = titular, numero = numero) {

  override fun saca( valor: Double ) {

    when {
      this.saldo >= valor -> {
        this.saldo-= valor
        println("Saque de $valor realizado com sucesso, saldo: ${this.saldo}")
      }
      else -> println("Saldo indisponível para saque, saldo: ${this.saldo}")
    }

  }
}