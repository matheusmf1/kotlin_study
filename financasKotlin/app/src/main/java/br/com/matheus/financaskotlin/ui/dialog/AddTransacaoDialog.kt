package br.com.matheus.financaskotlin.ui.dialog

import android.app.DatePickerDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import br.com.matheus.financaskotlin.R
import br.com.matheus.financaskotlin.extension.convertToCalendar
import br.com.matheus.financaskotlin.extension.formatDateToBrasil
import br.com.matheus.financaskotlin.model.Tipo
import br.com.matheus.financaskotlin.model.Transacao
import kotlinx.android.synthetic.main.activity_lista_transacoes.*
import kotlinx.android.synthetic.main.form_transacao.view.*
import java.math.BigDecimal
import java.text.SimpleDateFormat
import java.util.*

class AddTransacaoDialog(
  private val viewGroup: ViewGroup,
  private val context: Context
) {

  private val addView = createLayout()

  private fun configDialog() {

    configDateField()
    configCategoryField()

    configDialog()
  }

  private fun configDialog() {

    AlertDialog.Builder(context)
      .setTitle(R.string.adiciona_receita)
      .setView(addView)
      .setPositiveButton("Adicionar") { _, _ ->
        val textValue = addView.form_transacao_valor.text.toString()
        val textDate = addView.form_transacao_data.text.toString()
        val textCategory = addView.form_transacao_categoria.selectedItem.toString()

        val value = convertValueField( textValue )

        val createdTransacao = Transacao(
          tipo = Tipo.RECEITA,
          valor = value,
          data = textDate.convertToCalendar(),
          categoria = textCategory
        )

        updateTransactions(createdTransacao)
        lista_transacoes_adiciona_menu.close(true)

      }
      .setNegativeButton("Cancelar", null)
      .show()
  }


  private fun convertValueField(textValue: String): BigDecimal {
    return try {
      BigDecimal(textValue)
    } catch (exception: NumberFormatException) {
      Toast.makeText(context, "Falha na conversão de valor", Toast.LENGTH_LONG).show()
      BigDecimal.ZERO
    }
  }

  private fun configCategoryField() {
     val adapter = ArrayAdapter.createFromResource(
      context, R.array.categorias_de_receita,
      android.R.layout.simple_spinner_dropdown_item
    )
    addView.form_transacao_categoria.adapter = adapter
  }

  private fun configDateField() {
    val today = Calendar.getInstance()

    val year = today.get(Calendar.YEAR)
    val month = today.get(Calendar.MONTH)
    val day = today.get(Calendar.DAY_OF_MONTH)

    addView.form_transacao_data.setText(today.formatDateToBrasil())
    addView.form_transacao_data.setOnClickListener {

      DatePickerDialog(
        context,
        DatePickerDialog.OnDateSetListener { _, year, month, day ->
          val dateSelected = Calendar.getInstance()
          dateSelected.set(year, month, day)
          addView.form_transacao_data.setText(dateSelected.formatDateToBrasil())
        }, year, month, day
      ).show()
    }
  }

  private fun createLayout(): View {
    return LayoutInflater.from(context)
      .inflate(
        R.layout.form_transacao,
        viewGroup,
//      window.decorView as ViewGroup,
        false
      )
  }

}