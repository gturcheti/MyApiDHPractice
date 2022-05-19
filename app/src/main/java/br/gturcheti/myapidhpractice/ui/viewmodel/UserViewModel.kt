package br.gturcheti.myapidhpractice.ui.viewmodel

import android.util.Log
import br.gturcheti.myapidhpractice.ui.Error
import br.gturcheti.myapidhpractice.ui.Results
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.gturcheti.api_dh_practice.data.UserRepository
import br.gturcheti.myapidhpractice.ui.Loading
import br.gturcheti.myapidhpractice.ui.Success
import br.gturcheti.myapidhpractice.ui.vo.UserVO
import kotlinx.coroutines.launch
import retrofit2.HttpException

class UserViewModel : ViewModel() {
    private val repository: UserRepository = UserRepository()

    private val _user: MutableLiveData<Results> = MutableLiveData()
    val user: LiveData<Results> = _user


    fun fetchUsers() {
        viewModelScope.launch {
            _user.value = Loading
            try {
                val response = repository.fetchUser()
                val vo = response.userList.map { userDTO ->
                    UserVO(
                        login = userDTO.login,
                        id = userDTO.id,
                        url = userDTO.url,
                        avatarUrl = userDTO.avatarUrl
                    )
                }
                Log.i("FETCHUSERS", "$vo")
                _user.value = Success(vo)
            } catch (ex: HttpException) {
                _user.value = Error
            }
        }
    }
}