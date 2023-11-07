package com.example.apuntesclasecdi.Heroes.Repositories

import com.example.apuntesclasecdi.Heroes.HeroData

interface HeroRepository {
    suspend fun GetHeroes() : MutableList<HeroData>
}