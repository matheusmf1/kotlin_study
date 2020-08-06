package br.com.matheus.nybooksmvvm.data

import br.com.matheus.nybooksmvvm.data.response.BookBodyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NYTServices {

  @GET("lists.json")
  fun getBook(
    @Query("api-key") apiKey : String = "idY88CEbiGyQbhijngMEGouEgpNWMvze",
    @Query("list") list : String = "hardcover-fiction"
  ): Call<BookBodyResponse>
}