package com.geektech.rickandmorty.model

import com.google.gson.annotations.SerializedName

data class LocationModel(

    @SerializedName("type")
    val type: String,

    @SerializedName("dimension")
    val dimension: String,

    @SerializedName("id")
    val id: Int
)
