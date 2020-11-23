package com.mcs.assignment3.view

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.widget.SearchView
import android.widget.Toast
import androidx.core.view.LayoutInflaterCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.mcs.assignment3.R
import com.mcs.assignment3.databinding.ActivityMainBinding
import com.mcs.assignment3.model.GitUser
import com.mcs.assignment3.presenter.MainActivityPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), IMainActivity, SearchView.OnQueryTextListener {

    private lateinit var presenter: MainActivityPresenter
    private lateinit var binding: ActivityMainBinding

    var KEY_USER: String  = "KEY_USER"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bindPresenter()
        sv_search_user.setOnQueryTextListener(this)

    }

    override fun requestData(username: String) {
        presenter.requestData(username)
    }

    override fun displayData(dataSet: List<GitUser>) {
        binding.rvGitUsers.layoutManager = LinearLayoutManager(this)
        binding.rvGitUsers.adapter = GitUsersAdapter(dataSet)
        {
            openUserDisplay(it)
        }
    }

    override fun bindPresenter() {
        presenter = MainActivityPresenter()
        presenter.bindView(this)
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if (query != null) {
            requestData(query)
        }
        else
        {
            Toast.makeText(this, "failed to find user", Toast.LENGTH_SHORT).show()
        }
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return true
    }
    fun openUserDisplay(dataSet: GitUser)
    {
        val intent = Intent()
        intent.putExtra(KEY_USER,  dataSet)
        intent.setClass(this, UserRepoActivity::class.java)
        startActivity(intent)
    }

}