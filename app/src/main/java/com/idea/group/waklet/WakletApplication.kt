package com.idea.group.waklet

import android.app.Application
import android.content.Context


class WakletApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        context = this
    }

    companion object {
        private var context: Context? = null
        val appContext: Context?
            get() = context
    }
}