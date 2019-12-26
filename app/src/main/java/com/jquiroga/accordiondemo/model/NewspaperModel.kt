package com.jquiroga.accordiondemo.model

import com.google.gson.annotations.SerializedName

data class NewspaperModel(
    @SerializedName("name")
    var paperName: String? = null,
    @SerializedName("headlines")
    var paperHeadlines: List<HeadlinesModel>? = null,
    @SerializedName("is_expanded")
    var isExpanded: Boolean? = false
)