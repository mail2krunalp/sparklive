package com.assignment.sparklive.model

import com.google.gson.annotations.SerializedName

class ExpertCategoriesModel {
    @SerializedName("id")
    var id: String? = null
        private set

    @SerializedName("name")
    var name: String? = null
        private set

    @SerializedName("language")
    var language: String? = null
        private set

    @SerializedName("description")
    var description: String? = null
        private set

    @SerializedName("image_url")
    var imageUrl: String? = null
        private set
}