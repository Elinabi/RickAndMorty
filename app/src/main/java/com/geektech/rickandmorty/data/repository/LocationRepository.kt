package com.geektech.rickandmorty.data.repository

import com.geektech.rickandmorty.Utils.Resource
import com.geektech.rickandmorty.base.BaseRepository
import com.geektech.rickandmorty.data.remote.apiservices.LocationApiServices
import com.geektech.rickandmorty.model.CharacterModel
import com.geektech.rickandmorty.model.LocationModel
import com.geektech.rickandmorty.model.RickAndMortyResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class LocationRepository @Inject constructor(
    private val locationApiServices: LocationApiServices
):BaseRepository() {

    fun fetchLocation(): Flow<Resource<RickAndMortyResponse<LocationModel>>> = flow {
        emit(Resource.Loading())
        val fetchCharacter = locationApiServices.fetchLocation()
        emit(Resource.Success(fetchCharacter))
    }.flowOn(Dispatchers.IO).catch {
        emit(Resource.Error(it.localizedMessage ?: "Error!", null))
    }
}