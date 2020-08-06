package br.com.matheus.nybooksmvvm.presentation.books

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.matheus.nybooksmvvm.data.APIService
import br.com.matheus.nybooksmvvm.data.model.Book
import br.com.matheus.nybooksmvvm.data.response.BookBodyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BooksViewModel : ViewModel() {

  //ViewModel tem que ser independente da activity
  // NÃO PASSAR A REFERENCIA DA ACTIVITY PARA DENTRO DO ViewModel

  val booksLiveData: MutableLiveData<List<Book>> = MutableLiveData()

  fun getBooks() {
    //enqueue is async
    APIService.service.getBook().enqueue(object : Callback<BookBodyResponse> {

      override fun onResponse(call: Call<BookBodyResponse>, response: Response<BookBodyResponse>) {
        if (response.isSuccessful) {
          val books: MutableList<Book> = mutableListOf()

          response.body()?.let { bookBodyResponse ->

            bookBodyResponse.bookResult.forEach { results ->
              val book = Book(
                title = results.bookDetailsResponse[0].title,
                author = results.bookDetailsResponse[0].author
              )

              books.add(book)
            }
          }
          booksLiveData.value = books
        }
      }

      override fun onFailure(call: Call<BookBodyResponse>, t: Throwable) {
        Log.d("[Book]", "Erro: " + t )
      }

    })
  }

}