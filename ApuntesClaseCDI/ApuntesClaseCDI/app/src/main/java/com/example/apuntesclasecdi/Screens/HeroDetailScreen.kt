package com.example.apuntesclasecdi.Screens

import android.os.Build
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.example.apuntesclasecdi.Heroes.HeroData
import com.example.apuntesclasecdi.R

class HeroDetailScreen : ComponentActivity () {

    val nameText by lazy { findViewById<TextView>(R.id.hero_detail_title)}
    val descriptionText by lazy { findViewById<TextView>(R.id.hero_detail_description)}
    val backArrow by lazy { findViewById<ImageButton>(R.id.hero_detail_back_arrow)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hero_detail)

        var hero: HeroData?

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            hero = intent.getSerializableExtra("Hero", HeroData::class.java)
        } else {
            hero = intent.getSerializableExtra("Hero") as? HeroData
        }

        hero?.let {hero ->
            nameText.text = hero.name
            descriptionText.text = hero.description
        }

        backArrow.setOnClickListener {
            finish()
        }
    }
}