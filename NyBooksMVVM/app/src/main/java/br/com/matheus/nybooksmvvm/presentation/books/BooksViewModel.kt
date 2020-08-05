package br.com.matheus.nybooksmvvm.presentation.books

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.matheus.nybooksmvvm.data.model.Book

class BooksViewModel : ViewModel() {

  //ViewModel tem que ser independente da activity
  // NÃO PASSAR A REFERENCIA DA ACTIVITY PARA DENTRO DO ViewModel

  val booksLiveData : MutableLiveData<List<Book>> = MutableLiveData()

  fun getBooks() {
    booksLiveData.value = createMokedBooks()
  }

  fun createMokedBooks() : List<Book> {
    return listOf(
      Book("E o vento levou", "Eu"),
      Book("E o vento levou 2", "Eu"),
      Book("E o vento levou 3", "Eu"),
      Book("E o vento levou 4",  "Eu")
    )
  }


}