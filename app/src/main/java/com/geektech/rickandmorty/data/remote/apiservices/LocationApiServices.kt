package com.geektech.rickandmorty.data.remote.apiservices

import com.geektech.rickandmorty.model.CharacterModel
import com.geektech.rickandmorty.model.LocationModel
import com.geektech.rickandmorty.model.RickAndMortyResponse
import retrofit2.http.GET

interface LocationApiServices {

    @GET("api/location")
    suspend fun fetchLocation(
//        @Query("page")page: Int
    ): RickAndMortyResponse<LocationModel>
}