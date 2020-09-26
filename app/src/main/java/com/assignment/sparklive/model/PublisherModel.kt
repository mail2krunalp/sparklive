package com.assignment.sparklive.model

import com.google.gson.annotations.SerializedName

class PublisherModel {
    @SerializedName("uid")
    var uid: String? = null
        private set

    @SerializedName("slug")
    var slug: String? = null
        private set

    @SerializedName("name")
    var name: String? = null
        private set

    @SerializedName("thumbnail")
    var thumbnail: String? = null
        private set

    @SerializedName("section_id")
    var sectionId: Int? = null
        private set

    @SerializedName("fragment")
    var fragment: String? = null
        private set

    @SerializedName("is_subscribe")
    var isSubscribe: Boolean? = null
        private set

    @SerializedName("description")
    var description: String? = null
        private set
}