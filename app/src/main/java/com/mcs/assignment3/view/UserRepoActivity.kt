package com.mcs.assignment3.view

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.mcs.assignment3.R
import com.mcs.assignment3.model.GitUser
import com.mcs.assignment3.model.UserProperties
import com.mcs.assignment3.presenter.MainActivityPresenter
import com.mcs.assignment3.presenter.UserDisplayPresenter
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.user_repo_actvitity.*

class UserRepoActivity : AppCompatActivity(), IUserDisplayActivity
{
    var KEY_USER: String  = "KEY_USER"
    private lateinit var presenter: UserDisplayPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_repo_actvitity)
        bindPresenter()
        val user = intent.getParcelableExtra(KEY_USER) as? GitUser
        requestData(user?.login.toString())


    }

    override fun requestData(username: String) {
        presenter.requestData(username)
    }

    override fun displayData(dataSet: UserProperties) {

        println("USER REPO ACTITIVTY " + dataSet?.login)
        tv_username.text = "Username: " + dataSet?.login
        tv_bio.text = "Bio: " + dataSet?.bio
        tv_email.text = "Email: " +dataSet?.email
        tv_followers.text = "Followers: " + dataSet?.followers.toString()
        tv_following.text = "Following: " + dataSet?.following.toString()
        tv_join_date.text = "Join date: " + dataSet?.created_at
        tv_location.text = "Location: " + dataSet?.location
        Picasso.get().load(dataSet?.avatar_url).into(imageView)
    }

    override fun bindPresenter() {
        presenter = UserDisplayPresenter()
        presenter.bindView(this)
    }
}