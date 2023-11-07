package com.example.apuntesclasecdi.Heroes.Repositories

import com.example.apuntesclasecdi.Heroes.HeroData
import com.google.gson.annotations.SerializedName

data class CharactersResponse(
    val code: Int,
    @SerializedName("data") val charactersData: CharactersResponseData)

data class CharactersResponseData(
    val offset: Int,
    val count: Int,
    val total: Int,
    @SerializedName("results") val heroList: MutableList<HeroData>)
