package com.assignment.sparklive.model

import com.google.gson.annotations.SerializedName

class ActionCountModel {
    @SerializedName("like")
    var like: Int? = null

    @SerializedName("click")
    var click: Int? = null
        private set

    @SerializedName("share")
    var share: Int? = null
        private set

    @SerializedName("web_click")
    var webClick: Int? = null
        private set

}