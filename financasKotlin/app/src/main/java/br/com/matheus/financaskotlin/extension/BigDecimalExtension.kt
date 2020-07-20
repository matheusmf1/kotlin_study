package br.com.matheus.financaskotlin.extension

import java.math.BigDecimal
import java.text.DecimalFormat
import java.util.*

fun BigDecimal.formatCurrencyBrasil() : String {
  val formatedCurrency = DecimalFormat.getCurrencyInstance( Locale( "pt", "br" ) )
  return formatedCurrency.format( this ).replace( "R$", "R$ " ).replace( "-R$ ", "R$ -" )
}