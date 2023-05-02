package com.geektech.rickandmorty.model

import com.google.gson.annotations.SerializedName

data class CharacterModel(

    @SerializedName("image")
    val image: String,

    @SerializedName("status")
    val status: String,

    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String

)