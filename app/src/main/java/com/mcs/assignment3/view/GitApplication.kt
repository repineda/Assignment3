package com.mcs.assignment3.view

import android.app.Application
import android.content.Context

class GitApplication : Application()
{
    override fun onCreate() {
        super.onCreate()
        gitContext = applicationContext
    }
    companion object{
        lateinit var gitContext: Context
    }
}