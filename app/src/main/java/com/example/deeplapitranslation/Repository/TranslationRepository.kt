package com.example.deeplapitranslation.Repository

import com.example.deeplapitranslation.Data.Api.Response.DeeplResponse
import de.syntax.androidabschluss.adapter.Request.DeeplRequest
import de.syntax.androidabschluss.data.remote.ApiInterface
import retrofit2.Call

class TranslationRepository(private val apiInterface: ApiInterface) {

    fun translateText(deeplRequest: DeeplRequest): Call<DeeplResponse> {
        return apiInterface.deepLTranslate(deeplRequest)
    }
}
