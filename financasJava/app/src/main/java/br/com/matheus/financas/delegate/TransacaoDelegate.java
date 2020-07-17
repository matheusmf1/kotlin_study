package br.com.matheus.financas.delegate;

import br.com.matheus.financas.model.Transacao;

public interface TransacaoDelegate {
	void executa(Transacao transacao);
}
