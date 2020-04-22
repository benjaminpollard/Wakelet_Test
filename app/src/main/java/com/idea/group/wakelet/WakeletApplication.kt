package com.idea.group.wakelet

import android.app.Application
import android.content.Context


class WakeletApplication : Application() {

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