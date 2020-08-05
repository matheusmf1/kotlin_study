package br.com.matheus.financaskotlin.delegate

import br.com.matheus.financaskotlin.model.Transacao

interface TransacaoDelegate {

  fun delegate( transacao: Transacao )
}