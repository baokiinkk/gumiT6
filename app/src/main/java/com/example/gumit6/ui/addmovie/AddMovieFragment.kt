package com.example.gumit6.ui.addmovie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import com.example.gumit6.R
import com.example.gumit6.databinding.FragmentAddMovieBinding
import com.example.gumit6.ui.BaseFragment
import com.example.gumit6.ui.home.HomeFragment
import org.koin.androidx.viewmodel.ext.android.viewModel


class AddMovieFragment : BaseFragment<FragmentAddMovieBinding>(){
    val viewmodel:AddMovieViewmodel by viewModel()
    override fun getLayoutRes(): Int {
        return R.layout.fragment_add_movie
    }

    override fun onCreateViews() {
        baseBinding.viewmodel = viewmodel
        viewmodel.getCategory()
        viewmodel.dataCategory.observe(viewLifecycleOwner, Observer {
            it?.let {
                val listCategoryName = mutableListOf<String>()
                baseBinding.spinner.adapter = ArrayAdapter<String>(requireContext(),
                    android.R.layout.simple_spinner_dropdown_item,
                    it.map {
                        data->data.categories
                })

            }
        })
        viewmodel.isClick.observe(viewLifecycleOwner, Observer {
            it?.let {
               viewmodel.addMovie(baseBinding.spinner.selectedItem.toString())
                Toast.makeText(context,"OK",Toast.LENGTH_SHORT).show()
            }
        })

        viewmodel.isFinish.observe(viewLifecycleOwner, Observer {
            it?.let {
               requireActivity().supportFragmentManager
                   .popBackStack(HomeFragment::class.simpleName,FragmentManager.POP_BACK_STACK_INCLUSIVE)
            }
        })
    }

}