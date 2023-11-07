package com.example.apuntesclasecdi.Heroes.Repositories

import com.example.apuntesclasecdi.Heroes.HeroData
import com.example.apuntesclasecdi.Utils.Shared

class HeroSharedDatabase : HeroRepository {

    override suspend fun GetHeroes(): MutableList<HeroData> {
        return Shared.Heroes
    }
}