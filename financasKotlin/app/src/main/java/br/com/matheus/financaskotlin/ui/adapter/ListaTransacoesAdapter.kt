package br.com.matheus.financaskotlin.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.core.content.ContextCompat
import br.com.matheus.financaskotlin.R
import br.com.matheus.financaskotlin.extension.formatCurrencyBrasil
import br.com.matheus.financaskotlin.extension.formatDateToBrasil
import br.com.matheus.financaskotlin.extension.shrinkContent
import br.com.matheus.financaskotlin.model.Tipo
import br.com.matheus.financaskotlin.model.Transacao
import kotlinx.android.synthetic.main.transacao_item.view.*

class ListaTransacoesAdapter(private val transacoes: List<Transacao>,
                             private val context: Context) : BaseAdapter() {

  override fun getView( position: Int, view: View?, parent: ViewGroup?): View {

    val createdView = LayoutInflater.from(context).inflate(R.layout.transacao_item, parent, false)

    val transacao = transacoes[position]

    when{
      transacao.tipo == Tipo.RECEITA -> { addValue(createdView) }
      else -> {
        SubtractValue(createdView)
      }

    }

    createdView.transacao_valor.text = transacao.valor.formatCurrencyBrasil()
    createdView.transacao_categoria.text = transacao.categoria.shrinkContent( 14 )
    createdView.transacao_data.text = transacao.data.formatDateToBrasil()

    return createdView
  }

  private fun SubtractValue(createdView: View) {
    createdView.transacao_valor.setTextColor(ContextCompat.getColor(context, R.color.despesa))
    createdView.transacao_icone.setBackgroundResource(R.drawable.icone_transacao_item_despesa)
  }

  private fun addValue(createdView: View) {
    createdView.transacao_valor.setTextColor(ContextCompat.getColor(context, R.color.receita))
    createdView.transacao_icone.setBackgroundResource(R.drawable.icone_transacao_item_receita)
  }

  override fun getItem( position : Int ): Transacao {
    return transacoes[position]
  }

  override fun getItemId(p0: Int): Long {
    return 0
  }

  override fun getCount(): Int {
    return transacoes.size
  }
}