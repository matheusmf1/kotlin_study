package br.com.matheus.bytebank.Conta

class ContaCorrente( titular: String, numero: Int ) : Conta( titular = titular, numero = numero ) {

  override fun saca(valor: Double) {
    val valComTaxa = valor + 0.10

    when {
      this.saldo >= valComTaxa -> {
        this.saldo-= valComTaxa
        println("Saque com taxa de $valComTaxa realizado com sucesso, saldo: ${this.saldo}")
      }
      else -> println("Saldo indisponível para saque, saldo: ${this.saldo}")
    }

  }

}