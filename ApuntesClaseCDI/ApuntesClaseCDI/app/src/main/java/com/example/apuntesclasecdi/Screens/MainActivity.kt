package com.example.apuntesclasecdi.Screens
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apuntesclasecdi.Heroes.HeroAdapter
import com.example.apuntesclasecdi.Heroes.HeroData
import com.example.apuntesclasecdi.Heroes.HeroProvider
import com.example.apuntesclasecdi.Heroes.Repositories.HeroApiService
import com.example.apuntesclasecdi.Heroes.Repositories.HeroMockRepository
import com.example.apuntesclasecdi.Heroes.Repositories.HeroSharedDatabase
import com.example.apuntesclasecdi.R
import com.example.apuntesclasecdi.Utils.Shared
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    val table by lazy { findViewById<RecyclerView>(R.id.my_heroes_table) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_screen)

        table.layoutManager = LinearLayoutManager(this)

        val repository = HeroMockRepository()
        //val repository = HeroSharedDatabase()
        //val repository = HeroApiService()

        table.adapter = HeroAdapter(repository)

    }
}