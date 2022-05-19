package br.gturcheti.api_dh_practice.data

import br.gturcheti.api_dh_practice.data.dto.UserResponse
import retrofit2.http.GET

interface UserGitHubApi {

    @GET("search/users?q=language:java+location:saopaulo")
    suspend fun fetchUser(): UserResponse

}