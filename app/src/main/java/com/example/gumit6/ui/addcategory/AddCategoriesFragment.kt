package com.example.gumit6.ui.addcategory

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.gumit6.R
import com.example.gumit6.databinding.FragmentAddCategoriesBinding
import com.example.gumit6.ui.BaseFragment
import com.example.gumit6.ui.addmovie.AddMovieFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class AddCategoriesFragment :BaseFragment<FragmentAddCategoriesBinding>(){
    override fun getLayoutRes(): Int {
        return R.layout.fragment_add_categories
    }
    val viewmodel: AddCategoriesViewmodel by viewModel()
    override fun onCreateViews() {
        baseBinding.viewmodel = viewmodel
        viewmodel.isonClick.observe(viewLifecycleOwner, Observer {
            it?.let {
                requireActivity().supportFragmentManager.beginTransaction()
                    .add(R.id.contentFragment,AddMovieFragment())
                    .addToBackStack(AddCategoriesFragment::class.simpleName)
                    .commit()
            }
        })
    }

}