package com.example.apuntesclasecdi.Heroes

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.apuntesclasecdi.R

class HeroViewHolder(view: View, var hero: HeroData? = null) : ViewHolder(view) {

    val name by lazy { view.findViewById<TextView>(R.id.hero_cell_title) }
    val description by lazy { view.findViewById<TextView>(R.id.hero_cell_description) }

    fun SetupWith(hero: HeroData) {
        name.text = hero.name
        description.text = hero.description
        this.hero = hero
    }
}