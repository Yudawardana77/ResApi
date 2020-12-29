package com.appslokal.app.ui.news

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.observe
import com.appslokal.app.R
import com.appslokal.app.databinding.FragmentNewsBinding
import com.appslokal.app.ui.home.MainActivity
import com.bumptech.glide.Glide.init
import kotlin.math.log

class NewsFragment : Fragment() {
    private val parent: MainActivity by lazy { activity as MainActivity }
    private lateinit var binding: FragmentNewsBinding
    private val viewModel: NewsViewModel by lazy { NewsViewModel() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewsBinding.inflate(inflater, container, false).apply {
            viewModel = this@NewsFragment.viewModel
            lifecycleOwner = this@NewsFragment
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        init()
        observe()
    }

    private fun init() {
        binding.recyclerview.adapter = NewsAdapter(parent)
        viewModel.listNews()
    }

    private fun observe() {
        viewModel.loading.observe(viewLifecycleOwner) {
        }
        viewModel.actionState.observe(viewLifecycleOwner) {
            if (it.isConsumed) {
                Log.i("ActionState", "isConsumed")
            } else if (it.isSuccess) {
                Toast.makeText(parent, it.message, Toast.LENGTH_SHORT).show()
            }
        }
    }
}