package br.gturcheti.api_dh_practice.data.dto

import com.google.gson.annotations.SerializedName

data class UserDTO(
    val login: String,
    val id: Int,
    val url: String,
    @SerializedName("avatar_url")
    val avatarUrl: String,
)