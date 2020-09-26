package com.assignment.sparklive.model

import com.google.gson.annotations.SerializedName
import java.time.Duration

class VideoModel {
    @SerializedName("name")
    var name: String? = null
        private set

    @SerializedName("media_details")
    var mediaDetails: ArrayList<String>? = null
        private set

    @SerializedName("transcoding_id")
    var transcodingId: String? = null
        private set

    @SerializedName("duration")
    var duration: Double? = null
        private set

    @SerializedName("shoot_location")
    var shootLocation: Duration? = null
        private set

    @SerializedName("is_live")
    var isLive: Boolean? = null
        private set

    @SerializedName("aspect_ratio")
    var aspectRatio: String? = null
        private set

    @SerializedName("state")
    var state: String? = null
        private set
}