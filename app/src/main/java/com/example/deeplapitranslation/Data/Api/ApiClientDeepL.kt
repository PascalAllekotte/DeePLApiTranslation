package de.syntax.androidabschluss.data.remote

import com.example.deeplapitranslation.utils.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ApiClientDeepL {


    @Volatile
    private var INSTANCE : ApiInterface? = null

    fun getInstance() : ApiInterface {
        synchronized(this){
            return INSTANCE ?: Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
                .create(ApiInterface::class.java)
                .also {
                    INSTANCE = it
                }
        }
    }
}