package com.example.gumit6.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.example.gumit6.R
import com.example.gumit6.databinding.FragmentHomeBinding
import com.example.gumit6.ui.BaseFragment
import com.example.gumit6.ui.addcategory.AddCategoriesFragment
import com.example.gumit6.ui.movies.MovieFragment
import com.example.gumit6.ui.movies.MovieViewmodel

class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override fun getLayoutRes(): Int {
        return R.layout.fragment_home
    }

    override fun onCreateViews() {
        baseBinding.btnAdd.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .add(R.id.contentFragment,AddCategoriesFragment())
                .addToBackStack(HomeFragment::class.simpleName)
                .commit()
        }
        baseBinding.btnShow.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .add(R.id.contentFragment,MovieFragment())
                .addToBackStack(HomeFragment::class.simpleName)
                .commit()
        }
    }

}