package com.mcs.assignment3.model

import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.mcs.assignment3.R
import com.mcs.assignment3.view.GitApplication
import org.json.JSONArray
import org.json.JSONObject


//https://api.github.com/
//  search/users?q={username}
//
//  // users/{username}
//
//  users/{username}/repos


class GitNetwork {
    var TAG: String = "GitNetwork"
    var BASE_URL: String = "https://api.github.com/search/users?q="
    var REPO_INFO_URL: String = "https://api.github.com/users/"
    private var enqueue = Volley.newRequestQueue(
        GitApplication.gitContext
    )
    private var queue = Volley.newRequestQueue(GitApplication.gitContext)
    fun initVolley(username: String, callBackError: (String)->Unit, callBackSuccess: (JSONObject)-> Unit)
    {
        Log.d(TAG, "IN INIT VOLLEY")
        val jsonArrayGitUser = JsonObjectRequest(
            Request.Method.GET,
            "$BASE_URL$username",
            null,
            {
                callBackSuccess.invoke(it)
            },
            {
                println(it)
                //callBackError.invoke(it.message?:"ERROR CONNECTION TO USER LIST")
            })
        Log.d(TAG, "AFTER INIT VOLLEY")
        enqueue.add(jsonArrayGitUser)
    }
    fun getData(username: String, callBackError: (String)->Unit, callBackSuccess: (JSONObject)-> Unit)
    {
        println("IN INSIDE OF GET DATA")
        val jsonArrayGitUser = JsonObjectRequest(
                Request.Method.GET,
                "$REPO_INFO_URL$username",
                null,
                {
                    callBackSuccess.invoke(it)
                },
                {
                    println("THIS IS WHERE IT FAILS")
                    println(it)

                })
        queue.add(jsonArrayGitUser)
        Log.d(TAG, "AFTER GET DATA INIT VOLLEY")
    }

}