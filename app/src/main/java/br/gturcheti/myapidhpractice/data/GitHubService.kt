package br.gturcheti.api_dh_practice.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://api.github.com/"

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val userApi: UserGitHubApi = retrofit.create(UserGitHubApi::class.java)