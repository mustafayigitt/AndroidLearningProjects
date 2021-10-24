package com.mustafayigit.bookstore.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mustafayigit.bookstore.R
import com.mustafayigit.bookstore.adapter.BookListAdapter
import com.mustafayigit.bookstore.databinding.FragmentHomeBinding
import com.mustafayigit.bookstore.viewmodel.BookViewModel

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var bookViewModel: BookViewModel
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<FragmentHomeBinding>(
            inflater,
            R.layout.fragment_home,
            container,
            false
        )
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        bookViewModel = ViewModelProvider(this)[BookViewModel::class.java]
        initUI()
    }

    private fun initUI() {
        binding.recyclerBook.adapter = BookListAdapter(arrayListOf())

        bookViewModel.getBooks().observe(viewLifecycleOwner, Observer {
            binding.resource = it
            (binding.recyclerBook.adapter as BookListAdapter).updateData(it.data.orEmpty())
        })
    }


}
