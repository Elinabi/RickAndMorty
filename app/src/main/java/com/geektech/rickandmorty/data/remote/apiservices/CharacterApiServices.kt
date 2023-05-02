package com.geektech.rickandmorty.data.remote.apiservices

import com.geektech.rickandmorty.model.CharacterModel
import com.geektech.rickandmorty.model.RickAndMortyResponse
import retrofit2.http.GET

interface CharacterApiServices {

    @GET("api/character")
    suspend fun fetchCharacter(
//        @Query("page")page: Int
    ): RickAndMortyResponse<CharacterModel>
}