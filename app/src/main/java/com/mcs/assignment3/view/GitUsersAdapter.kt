package com.mcs.assignment3.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mcs.assignment3.R
import com.mcs.assignment3.model.GitUser

class GitUsersAdapter (val dataSet: List<GitUser>, val callBack: (GitUser)->Unit ): RecyclerView.Adapter<RecyclerView.ViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ListUserViewHolder(
            LayoutInflater.from(parent.context).inflate(
            R.layout.item_layout_list_git_users,
            parent,
            false
        ))

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ListUserViewHolder).onBind(
            dataSet[position],callBack
        )
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }



}