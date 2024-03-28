package com.example.deeplapitranslation.Data.Api.Response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class DeeplResponse(
    @Json(name = "translations")  val translations: List<Translation>
)