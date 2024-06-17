package com.example.loginapirest

import android.app.Application
import com.example.stores.common.database.ReqResApi


class LoginApplication : Application() {
    companion object{
        lateinit var reqResApi: ReqResApi
    }

    override fun onCreate() {
        super.onCreate()

        //Volley
        reqResApi = ReqResApi.getInstance(this)
    }
}