package br.gturcheti.api_dh_practice.data

import br.gturcheti.api_dh_practice.data.dto.UserResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserRepository {
    private val api = userApi

    suspend fun fetchUser():UserResponse = withContext(Dispatchers.IO) {
        api.fetchUser()
    }
}