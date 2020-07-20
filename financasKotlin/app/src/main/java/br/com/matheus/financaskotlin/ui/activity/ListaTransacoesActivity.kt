package br.com.matheus.financaskotlin.ui.activity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.matheus.financaskotlin.R
import br.com.matheus.financaskotlin.model.Tipo
import br.com.matheus.financaskotlin.model.Transacao
import br.com.matheus.financaskotlin.ui.ResumeView
import br.com.matheus.financaskotlin.ui.adapter.ListaTransacoesAdapter
import kotlinx.android.synthetic.main.activity_lista_transacoes.*
import java.math.BigDecimal

class ListaTransacoesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView( R.layout.activity_lista_transacoes )

        val transacoes : List<Transacao> = transacoesExemplo()

        configureResume(transacoes)

        configureList(transacoes)

        lista_transacoes_adiciona_receita.setOnClickListener( object: View.OnClickListener {
            override fun onClick(p0: View?) {
                Toast.makeText( this@ListaTransacoesActivity, "Oiiii", Toast.LENGTH_LONG ).show()
            }

        })

    }

    private fun configureResume(transacoes: List<Transacao>) {
        val resumeView = ResumeView(  this, window.decorView, transacoes )
        resumeView.updateData()
    }

    private fun configureList(transacoes: List<Transacao>) {
        lista_transacoes_listview.adapter = ListaTransacoesAdapter(transacoes, this)
    }

    private fun transacoesExemplo(): List<Transacao> {
        return listOf(
            Transacao(valor = BigDecimal(20.5), categoria = "Comida", tipo = Tipo.DESPESA),
            Transacao(valor = BigDecimal(100.00), categoria = "Investimento", tipo = Tipo.RECEITA)
        )
    }

}