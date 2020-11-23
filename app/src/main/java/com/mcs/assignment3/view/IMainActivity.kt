package com.mcs.assignment3.view

import com.mcs.assignment3.model.GitAccountsResponse
import com.mcs.assignment3.model.GitUser

interface IMainActivity {
    fun requestData(username: String)
    fun displayData(dataSet: List<GitUser>)
    fun bindPresenter()
}