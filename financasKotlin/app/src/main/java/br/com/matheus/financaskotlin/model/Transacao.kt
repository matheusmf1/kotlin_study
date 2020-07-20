package br.com.matheus.financaskotlin.model

import java.math.BigDecimal
import java.util.*

class Transacao(val valor: BigDecimal,
                val categoria: String = "Indefinida",
                val data: Calendar = Calendar.getInstance(),
                val tipo: Tipo) {


//    var valor: BigDecimal = valor
//    set(value) {
//        field = value
//    }
//    get() {
//        return field
//    }
//

//    var valor: BigDecimal = valor
//    private set



}