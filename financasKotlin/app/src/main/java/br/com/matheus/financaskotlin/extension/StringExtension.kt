package br.com.matheus.financaskotlin.extension

import java.text.SimpleDateFormat
import java.util.*

fun String.shrinkContent( limit: Int ) : String {

  if ( this.length > 14 )
    return "${this.substring( 0,14 )}..."

  return this

}

fun String.convertToCalendar(): Calendar {
  val formatBrasil = SimpleDateFormat("dd/MM/yyyy")
  val convertedDate: Date = formatBrasil.parse( this )
  val date = Calendar.getInstance()
  date.time = convertedDate
  return date
}