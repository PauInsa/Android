package com.example.andoridclase

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.andoridclase.ui.theme.AndoridClaseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndoridClaseTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    PrintToScreen(null)
                }
            }
        }
    }
}

@Composable
fun PrintToScreen(name: String?, modifier: Modifier = Modifier) {

    //val name = name ?: "Pepe"

    val name = name ?: run {
        Log.e("NullError", "Name is Null")
        return
    }

    Text(
        text = "Hello ${name?.uppercase()}!",
        modifier = modifier
    )
}