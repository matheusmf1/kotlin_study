package br.com.matheus.bytebank.Conta.Funcionarios

abstract class Funcionario (
  val nome: String,
  val cpf: String,
  val salario: Double
){
  abstract val bonificacao: Double

}