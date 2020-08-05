package br.com.matheus.financaskotlin.ui.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import br.com.matheus.financaskotlin.R
import br.com.matheus.financaskotlin.delegate.TransacaoDelegate
import br.com.matheus.financaskotlin.model.Transacao
import br.com.matheus.financaskotlin.ui.ResumeView
import br.com.matheus.financaskotlin.ui.adapter.ListaTransacoesAdapter
import br.com.matheus.financaskotlin.ui.dialog.AddTransacaoDialog
import kotlinx.android.synthetic.main.activity_lista_transacoes.*

class ListaTransacoesActivity : AppCompatActivity() {

  private val transacoes: MutableList<Transacao> = mutableListOf()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_lista_transacoes)

    configureResume()

    configureList()

    dialogReceita()

    despesaDialog()

  }

  private fun despesaDialog() {
    lista_transacoes_adiciona_despesa.setOnClickListener {
      AddTransacaoDialog(window.decorView as ViewGroup, this)
        .configDialog(object : TransacaoDelegate {
          override fun delegate(transacao: Transacao) {
            updateTransactions(transacao)
            lista_transacoes_adiciona_menu.close(true)
          }
        })
    }
  }

  private fun dialogReceita() {
    lista_transacoes_adiciona_receita.setOnClickListener {

      val layout = LayoutInflater.from( this ).inflate( R.layout.form_transacao,
      window.decorView as ViewGroup, false )

    }
  }


  private fun updateTransactions(transacao: Transacao) {
    transacoes.add(transacao)
    configureList()
    configureResume()
  }

  private fun configureResume() {
    val resumeView = ResumeView(this, window.decorView, transacoes)
    resumeView.updateData()
  }

  private fun configureList() {
    lista_transacoes_listview.adapter = ListaTransacoesAdapter(transacoes, this)
  }

}