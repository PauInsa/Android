package com.example.apuntesclasecdi.Heroes

import com.example.apuntesclasecdi.Heroes.Repositories.HeroRepository

class HeroProvider(val repository: HeroRepository) {

    suspend fun GetAllHeroes() : MutableList<HeroData> {
        return repository.GetHeroes()
    }

}