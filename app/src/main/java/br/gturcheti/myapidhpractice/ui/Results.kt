package br.gturcheti.myapidhpractice.ui

import br.gturcheti.myapidhpractice.ui.vo.UserVO

sealed class Results

object Loading : Results()

data class Success(
    val data: List<UserVO>
) : Results()

object Error : Results() {
    val errorMessage: String = "Algo deu errado!"
}