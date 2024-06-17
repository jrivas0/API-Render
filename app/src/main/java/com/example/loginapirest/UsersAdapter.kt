package com.example.loginapirest

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class UsersAdapter(private var users: MutableList<UserEntity>): RecyclerView.Adapter<UsersViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_menu,parent,false)

        return UsersViewHolder(view,parent.context)
    }

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        val item = users[position]
        holder.render(item)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateUsers(users: MutableList<UserEntity>) {
        this.users = users
        notifyDataSetChanged()
    }


}