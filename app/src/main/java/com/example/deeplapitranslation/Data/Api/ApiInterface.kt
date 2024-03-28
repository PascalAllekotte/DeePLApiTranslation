package de.syntax.androidabschluss.data.remote

import com.example.deeplapitranslation.Data.Api.Response.DeeplResponse
import com.example.deeplapitranslation.utils.DEEPL_AUTH_KEY
import de.syntax.androidabschluss.adapter.Request.DeeplRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiInterface {


    @POST("/v2/translate")
    fun deepLTranslate(
        @Body deeplRequest: DeeplRequest,
        @Header("Content-Type") contentType: String = "application/json",
        @Header("Authorization") authorization: String = "DeepL-Auth-Key $DEEPL_AUTH_KEY",


        ): Call<DeeplResponse>


}