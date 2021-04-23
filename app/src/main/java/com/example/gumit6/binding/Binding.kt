package com.example.gumit6.binding

import android.R
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.Spinner
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

class Binding {
    companion object {
        @BindingAdapter("android:adapter")
        @JvmStatic
        fun loadData(view: Spinner, data: MutableLiveData<List<String>?>) {
            data.value?.let {
                view.adapter = ArrayAdapter<String>(
                    view.context,
                    R.layout.simple_spinner_dropdown_item, it
                )
            }
        }
        @BindingAdapter("android:getValue")
        @JvmStatic
        fun getData(view: Spinner, data: MutableLiveData<String?>) {
            data.value?.let {
                data.postValue(view.selectedItem.toString())
            }
        }
        @BindingAdapter("android:adapter")
        @JvmStatic
        fun loadData(view: ListView, data: MutableLiveData<List<String>?>) {
            data.value?.let {
                view.adapter = ArrayAdapter<String>(
                    view.context,
                    R.layout.simple_spinner_dropdown_item, it
                )
            }
        }
    }
}