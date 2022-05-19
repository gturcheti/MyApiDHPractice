package br.gturcheti.myapidhpractice.ui.vo

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserVO(
    val login: String,
    val id: Int,
    val url: String,
    val avatarUrl: String,
) : Parcelable