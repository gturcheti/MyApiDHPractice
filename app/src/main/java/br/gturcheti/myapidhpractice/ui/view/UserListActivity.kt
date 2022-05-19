package br.gturcheti.myapidhpractice.ui.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import br.gturcheti.myapidhpractice.R

import br.gturcheti.myapidhpractice.ui.Error
import br.gturcheti.myapidhpractice.ui.Success
import br.gturcheti.myapidhpractice.ui.adapter.UserListAdapter
import br.gturcheti.myapidhpractice.ui.viewmodel.UserViewModel
import br.gturcheti.myapidhpractice.ui.vo.UserVO

class UserListActivity : AppCompatActivity(R.layout.activity_user_list) {

    val viewModel: UserViewModel by viewModels()

    private val fetchBtn by lazy {
        findViewById<Button>(R.id.bnt_fetch)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupObservers()
        setupListeners()
    }

    private fun setupListeners() {
        fetchBtn.setOnClickListener {
            viewModel.fetchUsers()
        }
    }

    fun setupObservers(){
        viewModel.user.observe(this) { result ->
            when (result){
                is Error -> {
                    Toast.makeText(this, result.errorMessage, Toast.LENGTH_SHORT).show()
                }
                is Success -> {
                    setupUserRV(result.data)
                }
            }
        }
    }


    fun setupUserRV(list:List<UserVO>) {
        val recyclerView = findViewById<RecyclerView>(R.id.activity_user_list_recyclerView)
        recyclerView.adapter = UserListAdapter(
            list,
            userItemListener = {
                vaiParaUserProfile(it)
            }
        )
    }

    fun vaiParaUserProfile(userVO: UserVO) {
        val intent = Intent(this@UserListActivity, UserProfileActivity::class.java)
        intent.putExtra("user", userVO)
        startActivity(intent)
    }
}