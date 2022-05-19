package br.gturcheti.myapidhpractice.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import br.gturcheti.api_dh_practice.data.dto.UserDTO
import br.gturcheti.myapidhpractice.databinding.RecycleItemUserBinding
import br.gturcheti.myapidhpractice.ui.vo.UserVO
import com.squareup.picasso.Picasso

class UserListAdapter(
    private val users: List<UserVO>,
    var userItemListener: (userVO: UserVO) -> Unit = {},
) : RecyclerView.Adapter<UserListAdapter.ViewHolder>() {

    inner class ViewHolder(
        private val binding: RecycleItemUserBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        private lateinit var user: UserVO

        init {
            itemView.setOnClickListener {
                if (::user.isInitialized) {
                    userItemListener(user)
                }
            }
        }

        fun vincula(user: UserVO) {
            this.user = user
            binding.userItemLogin.text = user.login
            binding.userItemId.text = user.id.toString()
            binding.userItemUrl.text = user.url
            Picasso.with(itemView.context)
                .load(user.avatarUrl)
                .into(binding.userImgAvatar)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RecycleItemUserBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = users[position]
        holder.vincula(user)
    }

    override fun getItemCount(): Int = users.size

}