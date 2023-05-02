package com.geektech.rickandmorty.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VM : BaseViewModel, VB : ViewBinding>(@LayoutRes layoutId: Int) :
    Fragment(layoutId) {

    abstract val viewModel: VM
    abstract val binding: VB

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupListener()
        setupRequest()
        setupSubscribers()
    }

    protected open fun initialize(){}

    protected open fun setupListener(){}

    protected open fun setupRequest(){}

    protected open fun setupSubscribers(){}
}