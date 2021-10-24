package com.mustafayigit.bookstore.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mustafayigit.bookstore.data.model.Book

/**
 * Created By MUSTAFA
 * on 20/05/2020
 */
class BookListAdapter(private val bookList: ArrayList<Book>) :
    RecyclerView.Adapter<BookListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        BookListViewHolder.create(parent)

    override fun getItemCount() = bookList.size

    override fun onBindViewHolder(holder: BookListViewHolder, position: Int) =
        holder.bind(bookList[position])

    fun updateData(newList: List<Book>) {
        this.bookList.clear()
        bookList.addAll(newList)
        notifyDataSetChanged()
    }
}