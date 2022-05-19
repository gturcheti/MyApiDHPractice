package br.gturcheti.api_dh_practice.data.dto

import com.google.gson.annotations.SerializedName

data class UserResponse (
    @SerializedName("items")
    val userList: List<UserDTO>
)
