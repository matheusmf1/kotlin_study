package br.com.matheus.bytebank.Conta.Funcionarios

interface Autenticavel {

  fun autentica( senha: Int ): Boolean
}