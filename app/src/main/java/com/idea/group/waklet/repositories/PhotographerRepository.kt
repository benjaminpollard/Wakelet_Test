package com.idea.group.waklet.repositories

import android.content.Context
import com.idea.group.waklet.models.PhotographerModel
import com.idea.group.waklet.WakletApplication
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.io.IOException
import java.lang.reflect.Type


class PhotographerRepository
{
    private val fileName = "data.json"

    fun getPhotographers() : List<PhotographerModel>
    {
        val jsonParser = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

        val listMyData: Type = Types.newParameterizedType(
            MutableList::class.java,
            PhotographerModel::class.java
        )

        val jsonAdapter: JsonAdapter<List<PhotographerModel>> =
            jsonParser.adapter<List<PhotographerModel>>(listMyData)

        val jsonString = WakletApplication.appContext?.let { getJsonDataFromAsset(it,fileName) }
            ?: return mutableListOf()

        val models : List<PhotographerModel>? =
            jsonAdapter.fromJson(jsonString)

        return models ?: mutableListOf()
    }

    private fun getJsonDataFromAsset(context: Context, fileName: String): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }
}