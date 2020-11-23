package com.mcs.assignment3.presenter

import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mcs.assignment3.model.GitNetwork
import com.mcs.assignment3.model.GitUser
import com.mcs.assignment3.view.IMainActivity
import org.json.JSONObject

class MainActivityPresenter{
    private var view: IMainActivity? = null
    private val gitNetwork = GitNetwork()

    var TAG: String = "MainActivityPresenter"

    fun bindView(view: IMainActivity)
    {
        this.view = view
    }

    fun requestData(username: String)
    {
        Log.d(TAG, "Right before gitNetwork.initVolley")
        gitNetwork.initVolley(username,

                {
            Log.d(TAG, "getGitAccounts: Network error $it")
        },
                {
            insertListUsers(it)
        } )
    }
    fun insertListUsers(stringResponse: JSONObject)
    {
        val gson = Gson()
        val dataSet: List<GitUser> =
        gson.fromJson(stringResponse.getJSONArray("items").toString(),
        object: TypeToken<List<GitUser>>() {}.getType())

        val listOfUsers = mutableListOf<GitUser>()
        for( user in dataSet){
            val itemUser = GitUser(
                    user.name,
                    user.login,
                    user.avatar_url,
                    user.followers_url,
                    user.following_url,
                    user.repos_url,
                    user.events_url,
                    user.received_events_url,
                    user.userRepos,
                    user.email,
                    user.created_at,
                    user.following,
                    user.followers,
                    user.public_repos,
                    user.bio,
                    user.location
            )
            listOfUsers.add(itemUser)
        }
        updateViewData(listOfUsers)
    }
    private fun updateViewData(dataSet:List<GitUser>){
        view?.displayData(dataSet)
    }
    fun unBind(){
        view = null
    }

}