package br.com.matheus.financaskotlin.ui.activity

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import br.com.matheus.financaskotlin.R
import br.com.matheus.financaskotlin.extension.formatDateToBrasil
import br.com.matheus.financaskotlin.model.Tipo
import br.com.matheus.financaskotlin.model.Transacao
import br.com.matheus.financaskotlin.ui.ResumeView
import br.com.matheus.financaskotlin.ui.adapter.ListaTransacoesAdapter
import kotlinx.android.synthetic.main.activity_lista_transacoes.*
import kotlinx.android.synthetic.main.form_transacao.view.*
import java.math.BigDecimal
import java.text.SimpleDateFormat
import java.util.*

class ListaTransacoesActivity : AppCompatActivity() {

    private val transacoes: MutableList<Transacao> = mutableListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView( R.layout.activity_lista_transacoes )

        configureResume()

        configureList()

        lista_transacoes_adiciona_receita.setOnClickListener { configDialog() }

    }


    private fun updateTransactions(transacao: Transacao) {
        transacoes.add(transacao)
        configureList()
        configureResume()
    }

    private fun configureResume() {
        val resumeView = ResumeView(  this, window.decorView, transacoes )
        resumeView.updateData()
    }

    private fun configureList() {
        lista_transacoes_listview.adapter = ListaTransacoesAdapter(transacoes, this)
    }

}