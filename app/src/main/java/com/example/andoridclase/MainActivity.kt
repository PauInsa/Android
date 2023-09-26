package com.example.andoridclase

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.andoridclase.ui.theme.AndoridClaseTheme

class MainActivity : ComponentActivity() {
    
    open class Fruit(val name: String = "Fruta Generica")
    {
        
    }
    
    class Apple(): Fruit("Manzana")
    {
        fun AppleFunc(){
            
        }
    }

    class Banana(): Fruit("Banana")
    {
        fun BananaFunc(){

        }
    }

    enum class Colors(val color: Color, val translationKey: String)
    {
        Red(Color.Red, "Color_Key_Red"),
        Green(Color.Green, "Color_Key_Green"),
        Blue(Color.Blue, "Color_Key_Blue"),
        Yellow(Color.Yellow, "Color_Key_Yellow")
    }

    enum class Operations(val operation: (Int, Int) -> Int, val priority: Int)
    {
        Add({a, b -> a + b}, 0),
        Subtract({a, b-> a - b}, 0);

        fun Calculate(a: Int, b: Int) : Int {
            return this.operation(a,b)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndoridClaseTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {

                    Column() {
                        
                        val fruits = listOf(Banana(), Apple(), null)
                        
                        fruits.forEach{ fruit ->
                            when(fruit) {
                                is Banana -> {
                                    fruit.BananaFunc()
                                }
                                is Apple -> {
                                    
                                }
                                else -> PrintToScreen(name = "Kesesto")
                            }
                            
                        }

                        val weekDay = "Dilluns"

                        when(weekDay) {
                            "Lunes" -> "Es lunes"
                            "Martes" -> "Es martes"
                        }

                        /*val operation = Operations.Subtract

                        val result = operation.Calculate(3,2)
                        
                        PrintToScreen(name = result.toString())*/

                        /*val names = listOf("armario", "rigoberto", "cogombre")

                        for(name in names)
                        {
                            PrintToScreen(name)
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        for(i in names.indices)
                        {
                            PrintToScreen(i.toString())
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        names.forEach {
                            name -> PrintToScreen(name)
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        names.forEachIndexed {
                            i, name -> PrintToScreen(i.toString())
                        }*/
                    }
                }
            }
        }
    }
}

@Composable
fun PrintToScreen(name: String, modifier: Modifier = Modifier, color:Color? = null) {

    Text(
        text = "Hello $name!",
        modifier = modifier,
        color = color ?: Color.Black
    )
}