package com.geektech.rickandmorty.ui.fragments

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android4lesson1dz.R
import com.example.android4lesson1dz.databinding.FragmentCharacterAndLocationBinding
import com.geektech.rickandmorty.Utils.Resource
import com.geektech.rickandmorty.base.BaseFragment
import com.geektech.rickandmorty.ui.adapter.CharacterAndLocationAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterAndLocationFragment :
    BaseFragment<CharacterAndLocationViewModel, FragmentCharacterAndLocationBinding>
        (R.layout.fragment_character_and_location) {

    override val binding by viewBinding(FragmentCharacterAndLocationBinding::bind)
    override val viewModel by viewModels<CharacterAndLocationViewModel>()
    private var characterAndLocationAdapter = CharacterAndLocationAdapter()

    override fun initialize() {
        binding.characterAndLocationRecView.adapter = characterAndLocationAdapter
    }

    override fun setupSubscribers() {
        subscribeToGetData()
    }

    private fun subscribeToGetData() {
        viewModel.noteLiveData.observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Error -> {}
                is Resource.Loading -> {

                }

                is Resource.Success -> {
                    characterAndLocationAdapter.submitList(it.data)
                }
            }
        }
    }
}

//    override fun setupSubscribers() {
//        viewModel.fetchCharacter().observe(viewLifecycleOwner) {
//            viewModel.viewModelScope.launch {
//                it.data.let { it ->
////                    val dataList = mutableListOf<CharacterAndLocationModel>()
//                    characterAndLocationAdapter.submitData(it?.result to )
//
//                    viewModel.fetchLocation().observe(viewLifecycleOwner) {
//                        viewModel.viewModelScope.launch {
//                        it.data.let {
//                            characterAndLocationAdapter.submitData(it.result)
//        viewModel.viewModelScope.launch {
//            val rick = viewModel.fetchCharacter()
//            val morty = viewModel.fetchLocation()
//
//            val dataList = mutableListOf<CharacterAndLocationModel>()
//            characterAndLocationAdapter.submitData(rick)
//            characterAndLocationAdapter.submitData(morty)
//

//            awaitAll(viewModel.fetchLocation(),viewModel.fetchLocation())
//                characterAndLocationAdapter.submitData(it)
//            }
