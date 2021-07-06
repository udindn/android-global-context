package com.arrayyan.context

import android.app.Application
import android.content.Context
import android.util.Log

open class FastApp : Application() {

    companion object {
        private lateinit var mAppContext: Context

        private fun setAppContext(con: Context) {
            mAppContext = con
        }
        fun getAppContext() : Context {
            return mAppContext
        }
    }


    override fun onCreate() {
        super.onCreate()
        setAppContext(this)
        initiate(mAppContext)
    }

    /**
     * initate will be called inside oncreate,
     * implement / override this method if there is any library need to initiate on application created
     * @param context parameter context will be supplied from application context mAppContext
     * */
    open fun initiate(context: Context) {
        Log.i(FastApp::class.java.name,Thread.currentThread().stackTrace[5].methodName + " called")
    }
}