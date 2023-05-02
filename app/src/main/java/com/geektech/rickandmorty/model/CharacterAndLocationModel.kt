package com.geektech.rickandmorty.model

import com.geektech.rickandmorty.base.IBaseDiffModel

data class CharacterAndLocationModel(

    val character: CharacterModel,
    val location: LocationModel,
    override val id: Int = 0,
) :IBaseDiffModel
