package br.com.matheus.bytebank.Conta

abstract class Conta(val titular: String, val numero: Int ) {
  var saldo = 0.00
  protected set

  abstract fun saca( valor: Double )

  fun deposita( valor: Double ) {
    if ( valor > 0 )
      this.saldo += valor
    println("Saldo da conta ${numero} é: ${this.saldo}")
  }

  fun transfere ( conta: Conta, valor: Double ): Boolean {

    when {
      this.saldo >= valor -> {
        this.saldo -= valor
        conta.deposita( valor )
        println("Transferência realizada com sucesso, saldo: ${this.saldo}")
        return true
      }
      else -> {
        println("Saldo indisponível para transferência, saldo: ${this.saldo}")
        return false
      }
    }
  }


}