package br.com.matheus.bytebank.Conta.Funcionarios

class CalculadoraBonificacao {

  var total: Double = 0.0
    private set

  fun registra(funcionario: Funcionario ) {
    this.total += funcionario.bonificacao
  }

}