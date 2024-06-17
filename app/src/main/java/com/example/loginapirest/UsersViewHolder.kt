package com.example.loginapirest

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.loginapirest.databinding.ItemsMenuBinding

class UsersViewHolder(view: View, private val context: Context): RecyclerView.ViewHolder(view) {

    private val binding = ItemsMenuBinding.bind(view)

    @SuppressLint("SetTextI18n")
    fun render(user: UserEntity){
        binding.tvName.text = user.first_name +  " " + user.last_name
        binding.tvEmail.text = user.email
        Glide.with(context)
            .load(user.avatar)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .centerCrop()
            .into(binding.ivPhoto)
    }
}
