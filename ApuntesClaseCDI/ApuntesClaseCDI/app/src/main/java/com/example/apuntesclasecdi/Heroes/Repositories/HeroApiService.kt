package com.example.apuntesclasecdi.Heroes.Repositories

import com.example.apuntesclasecdi.Heroes.HeroData
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query
import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp

class HeroApiService : HeroRepository {

    companion object {
        const val BASE_URL = "https://gateway.marvel.com:443/v1/public/"
        const val API_KEY = "1c1a485d398d35aba0bbffacb95e64ed"
        const val PRIVATE_KEY = "9da41f67a88ea1d093b0e89f9ba9a9783deadbb9"

        val Timestamp: String get() = Timestamp(System.currentTimeMillis()).time.toString()

        val Hash: String get() {
            val input = "$Timestamp$PRIVATE_KEY$API_KEY"
            val md = MessageDigest.getInstance("MD5")
            return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
        }

        val ApiService: RetrofitHeroApiService by lazy {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RetrofitHeroApiService::class.java)
        }
    }

    interface RetrofitHeroApiService {
        @GET("characters")
        suspend fun GetHeroes(
            @Query("ts") timestamp: String = Timestamp,
            @Query("apikey") apiKey: String = API_KEY,
            @Query("hash") hash: String = Hash
        ) : Response<CharactersResponse>
    }

    override suspend fun GetHeroes(): MutableList<HeroData> {

        val response = ApiService.GetHeroes()

        if(response.isSuccessful) {

            response.body()?.charactersData?.heroList?.let { heroes ->
                return heroes
            } ?: kotlin.run {
                //Controlar el error de alguna forma
                return mutableListOf()
            }

        } else {
            //Controlar el error de alguna forma
            return mutableListOf()
        }
    }
}