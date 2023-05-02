package com.geektech.rickandmorty.ui.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.geektech.rickandmorty.Utils.Resource
import com.geektech.rickandmorty.base.BaseViewModel
import com.geektech.rickandmorty.data.repository.CharacterRepository
import com.geektech.rickandmorty.data.repository.LocationRepository
import com.geektech.rickandmorty.model.CharacterAndLocationModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterAndLocationViewModel @Inject constructor(
    private val characterRepositories: CharacterRepository,
    private val locationRepositories: LocationRepository
) : BaseViewModel() {
    
    private val _noteLiveData =
        MutableLiveData<Resource<List<CharacterAndLocationModel>>>(Resource.Loading())
    val noteLiveData: LiveData<Resource<List<CharacterAndLocationModel>>> = _noteLiveData

    init {
        getData()
    }

    private fun getData() {
        val character = viewModelScope.async {
            characterRepositories.fetchCharacter()
        }
        val location = viewModelScope.async {
            locationRepositories.fetchLocation()
        }
        viewModelScope.launch {
            character.await().combine(location.await()) { character, location ->
                Pair(character, location)
            }.collect {
                when {
                    it.first is Resource.Error && it.second is Resource.Error -> {
                        _noteLiveData.value = Resource.Error(it.first.message + it.second.message)
                    }
                    it.first is Resource.Success && it.second is Resource.Success -> {
                        val modelsList = mutableListOf<CharacterAndLocationModel>()
                        it.first.data!!.results.zip(it.second.data!!.results).forEach { models ->
                            modelsList.add(
                                CharacterAndLocationModel(
                                    models.first,
                                    models.second,
                                    models.first.id
                                )
                            )
                        }
                        _noteLiveData.value = Resource.Success(modelsList)
                    }
                }
            }
        }
    }

//    fun fetchCharacter() = characterRepositories.fetchCharacter()
//
//    fun fetchLocation() = locationRepositories.fetchLocation()
}