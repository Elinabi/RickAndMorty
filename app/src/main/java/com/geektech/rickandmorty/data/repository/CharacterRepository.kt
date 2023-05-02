package com.geektech.rickandmorty.data.repository

import com.geektech.rickandmorty.Utils.Resource
import com.geektech.rickandmorty.data.remote.apiservices.CharacterApiServices
import com.geektech.rickandmorty.model.CharacterModel
import com.geektech.rickandmorty.model.RickAndMortyResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val characterApiServices: CharacterApiServices
){

    fun fetchCharacter(): Flow<Resource<RickAndMortyResponse<CharacterModel>>> = flow {
        emit(Resource.Loading())
        val fetchCharacter = characterApiServices.fetchCharacter()
        emit(Resource.Success(fetchCharacter))
    }.flowOn(Dispatchers.IO).catch {
        emit(Resource.Error(it.localizedMessage ?: "Error!", null))
    }
}