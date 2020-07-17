package br.com.matheus.bytebank.Conta

import br.com.matheus.bytebank.Conta.Funcionarios.Autenticavel

class Cliente (
  val nome: String,
  val cpf: String,
  private val senha: Int
) : Autenticavel {

  override fun autentica(senha: Int): Boolean {
    if (this.senha == senha)
      return true

    return false
  }

}