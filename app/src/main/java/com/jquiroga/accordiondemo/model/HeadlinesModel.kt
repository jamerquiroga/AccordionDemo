package com.jquiroga.accordiondemo.model

import com.google.gson.annotations.SerializedName

data class HeadlinesModel(
    @SerializedName("title")
    var title: String? = null,
    @SerializedName("short_description")
    var description: String? = null
)