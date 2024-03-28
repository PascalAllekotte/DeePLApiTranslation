package com.example.deeplapitranslation.Data.Api.Response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Translation(
    @Json(name = "detected_source_language")  val detected_source_language: String,
    @Json(name = "text") val text: String
)