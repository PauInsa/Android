package com.example.apuntesclasecdi.Screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.example.apuntesclasecdi.R

class SecondScreen : ComponentActivity() {

    val backButton by lazy { findViewById<ImageButton>(R.id.back_button) }
    val secondScreenText by lazy { findViewById<TextView>(R.id.second_screen_text) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_screen)

        secondScreenText.text = intent.getStringExtra("Extra Text")

        backButton.setOnClickListener {
            finish()
        }
    }
}