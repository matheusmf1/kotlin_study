package br.com.matheus.nybooksmvvm.data.response

import com.squareup.moshi.Json

data class BookResultsResponse(
  @Json( name = "book_details" )
  val bookDetailsResponse: List<BookDetailsResponse>
)