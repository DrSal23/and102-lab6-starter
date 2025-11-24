package com.codepath.lab6

import androidx.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class CampgroundResponse(
    @SerialName("data")
    val data: List<Campground>?
)

@Keep
@Serializable
data class Campground(
    @SerialName("name")
    val name: String?,

    @SerialName("description")
    val description: String?,

    @SerialName("latLong")
    val latLong: String?,

    @SerialName("images")
    val images: List<CampgroundImage>? = null
) : java.io.Serializable {

    // SAFE and NULL-PROOF — eliminates your build errors
    val imageUrl: String
        get() = images?.firstOrNull()?.url ?: ""
}

@Keep
@Serializable
data class CampgroundImage(
    @SerialName("url")
    val url: String?,

    @SerialName("title")
    val title: String?
) : java.io.Serializable
