package br.com.matheus.financas.model;

public enum Tipo {
	RECEITA {
		@Override
		public String toString() {
			return "Receita";
		}
	}, DESPESA {
		@Override
		public String toString() {
			return "Despesa";
		}
	}
}