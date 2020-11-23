package com.mcs.assignment3.view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mcs.assignment3.R
import com.mcs.assignment3.model.GitUser
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_layout_list_git_users.view.*

class ListUserViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView)
{
    private val tvUserName :  TextView = itemView.findViewById(R.id.tv_user_list)
    private val ivAvatar: ImageView = itemView.findViewById(R.id.iv_user_avatar)



    fun onBind(dataItem: GitUser, onClickCallback: (GitUser) -> Unit)
    {
        tvUserName.text = dataItem.login ?: "NOT FOUND"
        Picasso.get().load(dataItem.avatar_url).into(ivAvatar)

        itemView.setOnClickListener{onClickCallback.invoke(dataItem)}
    }
}