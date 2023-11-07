package com.example.apuntesclasecdi.Heroes.Repositories

import com.example.apuntesclasecdi.Heroes.HeroData

class HeroMockRepository : HeroRepository {

    companion object {

        private val heroesListHardcoded = mutableListOf(
            HeroData("Aquaman", "Es un pez y sabe nadar"),
            HeroData("Superman", "Débil ante una gema verde"),
            HeroData("BatMan", "No es super solo rico"),
            HeroData("SpiderCerdo", "También puede ser Harry popo ter"),
            HeroData("SpiderCerdo2", "También puede ser Harry popo ter"),
            HeroData("SpiderCerdo3", "También puede ser Harry popo ter"),
            HeroData("SpiderCerdo4", "También puede ser Harry popo ter"),
            HeroData("SpiderCerdo5", "También puede ser Harry popo ter"),
        )
    }

    override suspend fun GetHeroes(): MutableList<HeroData> {
        return heroesListHardcoded
    }
}