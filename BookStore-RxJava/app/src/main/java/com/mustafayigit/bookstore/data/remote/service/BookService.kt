package com.mustafayigit.bookstore.data.remote.service

import com.mustafayigit.bookstore.data.model.Book
import io.reactivex.Single
import retrofit2.http.GET

/**
 * Created By MUSTAFA
 * on 20/05/2020
 */
interface BookService {

    @GET("book")
    fun getBookList(): Single<List<Book>>

}