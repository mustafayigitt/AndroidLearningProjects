package com.mustafayigit.bookstore.data.repository

import com.mustafayigit.bookstore.data.model.Book
import com.mustafayigit.bookstore.data.remote.ApiClient
import com.mustafayigit.bookstore.data.remote.service.BookService
import io.reactivex.Single

/**
 * Created By MUSTAFA
 * on 20/05/2020
 */
class BookRepository {
    private val bookService: BookService by lazy {
        ApiClient.getClient().create(BookService::class.java)
    }

    fun fetchBooks(): Single<List<Book>> {
        return bookService.getBookList()
    }


}