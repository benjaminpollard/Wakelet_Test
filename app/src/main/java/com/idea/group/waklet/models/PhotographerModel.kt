package com.idea.group.waklet.models

import com.squareup.moshi.Json

data class PhotographerModel(@Json(name = "image")
                             val image: String? = "",
                             @Json(name = "name")
                             val name: String? = "",
                             @Json(name = "description")
                             val description: String? = "",
                             @Json(name = "bio")
                             val bio: String? = "")