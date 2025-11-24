package com.codepath.lab6

import androidx.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class ParksResponse(
    @SerialName("data")
    val data: List<Park>?
)

@Keep
@Serializable
data class Park(
    @SerialName("fullName")
    val fullName: String?,

    @SerialName("description")
    val description: String?,

    @SerialName("images")
    val images: List<ParkImage>? = null
) : java.io.Serializable {

    // Safe getter — prevents all adapter errors
    val imageUrl: String
        get() = images?.firstOrNull()?.url ?: ""
}

@Keep
@Serializable
data class ParkImage(
    @SerialName("url")
    val url: String?
) : java.io.Serializable
