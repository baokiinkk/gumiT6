package com.example.gumit6.ui.movies

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.lifecycle.Observer
import com.example.gumit6.BuildConfig
import com.example.gumit6.R
import com.example.gumit6.data.db.model.Category
import com.example.gumit6.databinding.FragmentMovieBinding
import com.example.gumit6.ui.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieFragment : BaseFragment<FragmentMovieBinding>() {
    private lateinit var sp: SharedPreferences
    val viewmodel:MovieViewmodel by viewModel()
    override fun getLayoutRes(): Int {
        return R.layout.fragment_movie
    }

    override fun onCreateViews() {
        baseBinding.viewmodel = viewmodel
        viewmodel.getCategory()
        sp = requireActivity().getSharedPreferences("keyword", Context.MODE_PRIVATE)
        viewmodel.keyword.postValue(sp.getString("key",null))

        viewmodel.isClick.observe(viewLifecycleOwner, Observer {
            it?.let {
                viewmodel.getMovie(baseBinding.spinner.selectedItem.toString(),viewmodel.keyword.value)
                sp.edit().putString("key",viewmodel.keyword.value).apply()
            }
        })
    }
}