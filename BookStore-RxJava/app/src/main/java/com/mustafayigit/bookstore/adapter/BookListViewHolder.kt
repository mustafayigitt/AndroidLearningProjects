package com.mustafayigit.bookstore.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.mustafayigit.bookstore.R
import com.mustafayigit.bookstore.data.model.Book
import com.mustafayigit.bookstore.databinding.AdapterItemBookListBinding
import com.mustafayigit.bookstore.ui.HomeFragmentDirections

/**
 * Created By MUSTAFA
 * on 20/05/2020
 */
class BookListViewHolder(private val binding: AdapterItemBookListBinding) :
    RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun create(container: ViewGroup): BookListViewHolder {
            return BookListViewHolder(
                DataBindingUtil.inflate<AdapterItemBookListBinding>(
                    LayoutInflater.from(container.context),
                    R.layout.adapter_item_book_list,
                    container,
                    false
                )
            )
        }
    }

    fun bind(book: Book) {

        binding.book = book

        binding.root.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(book)
            binding.root.findNavController().navigate(action)
        }
    }
}