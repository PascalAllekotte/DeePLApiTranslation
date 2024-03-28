package com.example.deeplapitranslation.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.deeplapitranslation.Data.Api.Response.DeeplResponse
import com.example.deeplapitranslation.Repository.TranslationRepository
import de.syntax.androidabschluss.adapter.Request.DeeplRequest
import de.syntax.androidabschluss.data.remote.ApiClientDeepL
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TranslationViewModel : ViewModel() {

    private val repository = TranslationRepository(ApiClientDeepL.getInstance())

    private val _translation = MutableLiveData<String>()
    val translation: LiveData<String> get() = _translation

    fun translateText(text: String) {
        try {
            val request = DeeplRequest(target_lang = "EN", text = listOf(text))
            repository.translateText(request).enqueue(object : Callback<DeeplResponse> {
                override fun onResponse(call: Call<DeeplResponse>, response: Response<DeeplResponse>) {
                    if (response.isSuccessful) {
                        _translation.value = response.body()?.translations?.firstOrNull()?.text ?: ""
                    } else {
                        Log.e("TranslationViewModel", "API-Anfragefehler: ${response.errorBody()?.string()}")
                        _translation.value = "Ein Fehler ist aufgetreten"
                    }
                }

                override fun onFailure(call: Call<DeeplResponse>, t: Throwable) {
                    Log.e("TranslationViewModel", "Netzwerkfehler: ${t.message}", t)
                    _translation.value = "Netzwerkfehler: ${t.message}"
                }
            })
        } catch (e: Exception) {
            Log.e("TranslationViewModel", "Ausnahme: ${e.message}", e)
            _translation.value = "Ein Fehler ist aufgetreten"
        }
    }
}
