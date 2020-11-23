package com.mcs.assignment3.presenter

import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mcs.assignment3.model.GitNetwork
import com.mcs.assignment3.model.GitUser
import com.mcs.assignment3.model.UserProperties
import com.mcs.assignment3.view.IMainActivity
import com.mcs.assignment3.view.IUserDisplayActivity
import org.json.JSONArray
import org.json.JSONObject

class UserDisplayPresenter {
    private var view: IUserDisplayActivity? = null
    private val gitNetwork = GitNetwork()

    var TAG: String = "UserDisplayPresenter"

    fun bindView(view: IUserDisplayActivity)
    {
        this.view = view
    }

    fun requestData(username: String)
    {
        Log.d(TAG, "Right before gitNetwork.getData")
        gitNetwork.getData(username,

                {
                    Log.d(TAG, "getGitAccounts: Network error $it")
                },
                {
                    collectData(it)
                } )
    }
    fun collectData(stringResponse: JSONObject)
    {
        val gson = Gson()
        println("HERE IN COLLECT DATA")
        val dataSet: UserProperties =
                gson.fromJson(stringResponse.toString(),
                        object: TypeToken<UserProperties>() {}.getType())
            val itemUser = UserProperties(
                    dataSet.name,
                    dataSet.login,
                    dataSet.avatar_url,
                    dataSet.followers_url,
                    dataSet.following_url,
                    dataSet.repos_url,
                    dataSet.events_url,
                    dataSet.received_events_url,
                    dataSet.email,
                    dataSet.created_at,
                    dataSet.following,
                    dataSet.followers,
                    dataSet.public_repos,
                    dataSet.bio,
                    dataSet.location
            )
            updateViewData(itemUser)

    }
    private fun updateViewData(dataSet:UserProperties){
        println("USER DISPLAY PRESENTER " + dataSet?.login)
        view?.displayData(dataSet)
    }
    fun unBind(){
        view = null
    }
}

