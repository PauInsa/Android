package com.example.apuntesclasecdi.Heroes

class HeroRepository {

    companion object {
        val heroesListHarcoded = listOf(
            HeroData("Aquaman", "Es un pez y sabe nadar"),
            HeroData("Superman", "Es un gigachad"),
            HeroData("Aironman", "Es rico"),
            HeroData("Batman", "Es rico pero en DC"),
            HeroData("Aquaman", "Es un pez y sabe nadar"),
        )

        fun GetAllHeroes() : List<HeroData> = heroesListHarcoded
    }

}