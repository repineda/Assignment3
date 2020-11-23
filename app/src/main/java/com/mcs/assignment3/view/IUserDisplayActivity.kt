package com.mcs.assignment3.view

import com.mcs.assignment3.model.GitUser
import com.mcs.assignment3.model.UserProperties

interface IUserDisplayActivity {
        fun requestData(username: String)
        fun displayData(dataSet: UserProperties)
        fun bindPresenter()
}