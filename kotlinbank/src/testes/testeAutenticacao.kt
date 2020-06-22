package testes

import Cliente
import Funcionarios.Diretor
import Funcionarios.Gerente
import SistemaInterno

fun testaAutenticacao() {
  val gerente = Gerente(
    nome = "Matheus",
    cpf = "111.111.111-11",
    salario = 1000.0,
    senha = 1000
  )
  val diretora = Diretor(
    nome = "Matheus2",
    cpf = "222.222.222-22",
    salario = 2000.0,
    senha = 2000,
    plr = 200.0
  )
  val cliente = Cliente(
    nome = "Matheus3",
    cpf = "333.333.333-33",
    senha = 1234
  )

  val sistema = SistemaInterno()
  sistema.entra(gerente, 1000)
  sistema.entra(diretora, 2000)
  sistema.entra(cliente, 1234)
}