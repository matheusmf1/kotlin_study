package br.com.matheus.financaskotlin.model

import java.math.BigDecimal

class Resumo( private val transacoes : List<Transacao> ) {

  fun receita(): BigDecimal {

//    var totalReceita = BigDecimal.ZERO
//    for (transacao in transacoes) {
//      if (transacao.tipo == Tipo.RECEITA) {
//        totalReceita = totalReceita.plus(transacao.valor)
//      }
//    }
    return sumBy( Tipo.RECEITA )
  }

  fun despesa(): BigDecimal = sumBy( Tipo.DESPESA )

  fun balance() = receita().subtract( despesa() )

  private fun sumBy( tipo: Tipo ): BigDecimal {
    return BigDecimal(transacoes
      .filter { transacao -> transacao.tipo == tipo }
      .sumByDouble { it.valor.toDouble() })
  }
}