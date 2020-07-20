package br.com.matheus.financaskotlin.extension

import java.text.SimpleDateFormat
import java.util.*


fun Calendar.formatDateToBrasil(): String {
    return SimpleDateFormat( "dd/MM/yyyy" ).format(this.time)
}