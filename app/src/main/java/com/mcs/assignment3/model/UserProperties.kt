package com.mcs.assignment3.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserProperties (
        val name: String? = "N/A",
        val login: String? = "N/A",
        val avatar_url: String,
        val followers_url :String? = "N/A",
        val following_url : String? = "N/A",
        val repos_url : String? = "N/A",
        val events_url : String? = "N/A",
        val received_events_url : String? = "N/A",
        var email : String?= "N/A",
        var created_at : String? = "N/A",
        var following : Int,
        val followers : Int,
        val public_repos: Int,
        var bio : String? = "N/A",
        var location : String? = "N/A"
):Parcelable