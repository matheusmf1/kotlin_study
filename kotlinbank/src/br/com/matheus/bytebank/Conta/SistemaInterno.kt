package br.com.matheus.bytebank.Conta

import br.com.matheus.bytebank.Conta.Funcionarios.Autenticavel

class SistemaInterno {

  fun entra (admin: Autenticavel, senha: Int) {
    if( admin.autentica(senha) ) {
      println("Welcome to KotlinBank")
    } else {
      println("Autentication failed")
    }
  }

}