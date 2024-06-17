package com.example.stores.common.database

import android.content.Context
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley

class ReqResApi constructor(context: Context) {
    companion object{
        @Volatile
        private var INSTANCE: ReqResApi? = null

        fun getInstance(context: Context) = INSTANCE?: synchronized(this){
            INSTANCE ?: ReqResApi(context).also { INSTANCE = it }
        }
    }

    private val requestQueue: RequestQueue by lazy {
        Volley.newRequestQueue(context.applicationContext)
    }

    fun <T> addToRequestQueue(req: Request<T>){
        requestQueue.add(req)
    }
}