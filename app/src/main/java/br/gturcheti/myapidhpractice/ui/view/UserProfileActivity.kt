package br.gturcheti.myapidhpractice.ui.view

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import br.gturcheti.myapidhpractice.R
import br.gturcheti.myapidhpractice.ui.vo.UserVO
import com.squareup.picasso.Picasso

class UserProfileActivity : AppCompatActivity(R.layout.activity_user_profile) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val user = intent.getParcelableExtra<UserVO>("user")
        user?.let { bind(it) }
        Log.i("GetExtra", "$user")
    }

    fun bind(userVO: UserVO) {
        findViewById<TextView>(R.id.user_profile_tv_login).text = userVO.login
        findViewById<TextView>(R.id.user_profile_tv_id).text = userVO.id.toString()
        findViewById<TextView>(R.id.user_profile_tv_url).text = userVO.url

        Picasso.with(this)
            .load(userVO.avatarUrl)
            .into(findViewById<ImageView>(R.id.user_profile_img_avatar))
    }

}