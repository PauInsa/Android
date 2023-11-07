package com.example.apuntesclasecdi.Heroes

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.apuntesclasecdi.R
import com.example.apuntesclasecdi.Screens.HeroDetailScreen

class HeroAdapter(private val heroList: List<HeroData>) : Adapter<HeroViewHolder>() {

    private val provider: HeroProvider = HeroProvider(repository)
    private var heroList: MutableList<HeroData> = mutableListOf()
    private var requestingData = false

    init {
        GetMoreData()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        val viewHolder = HeroViewHolder(layoutInflater.inflate(R.layout.hero_cell, parent, false))

        viewHolder.itemView.setOnClickListener{
            val intent = Intent(parent.context, HeroDetailScreen::class.java)
            intent.putExtra("Hero", viewHolder.hero)

            parent.context.startActivity(intent)
        }
        return HeroViewHolder(layoutInflater.inflate(R.layout.hero_cell, parent, false))
    }

    override fun getItemCount(): Int = heroList.size

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        holder.SetupWith(heroList[position])
        if(position >= heroList.)
    }

}