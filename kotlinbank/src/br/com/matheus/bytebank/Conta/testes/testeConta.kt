package br.com.matheus.bytebank.Conta.testes

import br.com.matheus.bytebank.Conta.ContaCorrente
import br.com.matheus.bytebank.Conta.ContaPoupanca

fun testaComportamentosConta() {
  val conta1 = ContaCorrente( "Matheus", 1000 )
  val conta2 = ContaPoupanca( "Matheus2", 2000 )

  conta1.deposita( 1000.00 )
  conta2.deposita( 1000.00 )

  conta1.saca( 200.00 )
  conta2.saca( 100.00 )

  conta1.transfere( conta2, 700.00 )
  conta2.saca(0.00)

}