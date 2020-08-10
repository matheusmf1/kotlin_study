package br.com.matheus.nybooksmvvm.presentation.books

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.matheus.nybooksmvvm.R
import br.com.matheus.nybooksmvvm.presentation.details.BookDetailsActivity
import kotlinx.android.synthetic.main.activity_books.*

class BooksActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_books)

    toolbarMain.title = getString(R.string.books_title)
    setSupportActionBar(toolbarMain)

    val viewModel: BooksViewModel = ViewModelProviders.of(this).get(BooksViewModel::class.java)

    viewModel.booksLiveData.observe(this, Observer {
//      if null
      it?.let { books ->
        with(recyclerBooks) {
          layoutManager = LinearLayoutManager(this@BooksActivity, RecyclerView.VERTICAL, false)
          setHasFixedSize(true)
          adapter = BooksAdapter( books ) { book ->
            val intent = BookDetailsActivity.getStartIntent(this@BooksActivity, book.title, book.description )
            this@BooksActivity.startActivity( intent )
          }
        }
      }
    })

    viewModel.getBooks()
  }


}