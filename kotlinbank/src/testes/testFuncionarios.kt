package testes

import Funcionarios.Analista
import Funcionarios.CalculadoraBonificacao
import Funcionarios.Diretor
import Funcionarios.Gerente

fun testaFuncionarios() {
  val matheus1 = Analista (
    nome = "Matheus1",
    cpf = "111.111.111-11",
    salario = 1000.0
  )

  println("nome ${matheus1.nome}")
  println("bonificação ${matheus1.bonificacao}")

  val matheus2 = Gerente (
    nome = "Matheus2",
    cpf = "222.222.222-22",
    salario = 2000.0,
    senha = 1234
  )

  println("nome ${matheus2.nome}")
  println("bonificação ${matheus2.bonificacao}")

  if (matheus2.autentica(1234)) {
    println("autenticou com sucesso")
  } else {
    println("falha na autenticação")
  }

  val matheus3 = Diretor(
    nome = "Matheus3",
    cpf = "333.333.333-33",
    salario = 42000.0,
    senha = 4000,
    plr = 20000.0
  )

  println("nome ${matheus3.nome}")
  println("bonificação ${matheus3.bonificacao}")
  println("plr ${matheus3.plr}")

  if (matheus3.autentica(4000)) {
    println("autenticou com sucesso")
  } else {
    println("falha na autenticação")
  }

  val calculadora = CalculadoraBonificacao()
  calculadora.registra(matheus1)
  calculadora.registra(matheus2)
  calculadora.registra(matheus3)

  println("total de bonificação: ${calculadora.total}")
}