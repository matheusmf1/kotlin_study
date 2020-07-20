package br.com.matheus.financaskotlin.ui

import android.content.Context
import android.view.View
import androidx.core.content.ContextCompat
import br.com.matheus.financaskotlin.R
import br.com.matheus.financaskotlin.extension.formatCurrencyBrasil
import br.com.matheus.financaskotlin.model.Resumo
import br.com.matheus.financaskotlin.model.Transacao
import kotlinx.android.synthetic.main.resumo_card.view.*
import java.math.BigDecimal


class ResumeView( private val context: Context,
                  private val view: View,
                  private val transacoes: List<Transacao>) {

  private val resumo : Resumo = Resumo( transacoes )
  private val colorReceita = ContextCompat.getColor(context, R.color.receita)
  private val colorDespesa = ContextCompat.getColor(context, R.color.despesa)

 private fun addReceita() {
    with( view.resumo_card_receita ) {
      setTextColor( colorReceita )
      text = resumo.receita().formatCurrencyBrasil()
    }
  }

  private fun addDespesa() {
    with( view.resumo_card_despesa ) {
      setTextColor( colorDespesa )
      text = resumo.despesa().formatCurrencyBrasil()
    }
  }

  private fun addBalance() {
    when {
      resumo.balance() >= BigDecimal.ZERO -> {
        view.resumo_card_total.setTextColor( colorReceita )
      }
      else -> { view.resumo_card_total.setTextColor( colorDespesa ) }
    }
    view.resumo_card_total.text = resumo.balance().formatCurrencyBrasil()
  }

  fun updateData() {
    addReceita()
    addDespesa()
    addBalance()
  }
}