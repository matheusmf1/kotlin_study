package br.com.matheus.nybooksmvvm.presentation.books

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.matheus.nybooksmvvm.R
import br.com.matheus.nybooksmvvm.data.model.Book
import kotlinx.android.synthetic.main.activity_books.*

class BooksActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_books)

    toolbarMain.title = getString(R.string.books_title)
    setSupportActionBar(toolbarMain)

    with(recyclerBooks) {
      layoutManager = LinearLayoutManager(this@BooksActivity, RecyclerView.VERTICAL, false)
      setHasFixedSize(true)
      adapter = BooksAdapter(getBooks())
    }
  }

  fun getBooks(): List<Book> {
    return listOf(
      Book("E o vento levou", "Eu"),
      Book("E o vento levou 2", "Eu"),
      Book("E o vento levou 3", "Eu"),
      Book("E o vento levou 4", "Eu")
    )
  }
}