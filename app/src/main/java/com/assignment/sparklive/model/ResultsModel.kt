package com.assignment.sparklive.model
import com.google.gson.annotations.SerializedName

class ResultsModel {
    @SerializedName("uid")
    var uid: String? = null
        private set

    @SerializedName("title")
    var title: String? = null
        private set

    @SerializedName("score")
    var score: Double? = null
        private set

    @SerializedName("description")
    var description: String? = null
        private set

    @SerializedName("category")
    var category: ArrayList<String>? = null
        private set

    @SerializedName("video")
    var video: VideoModel? = null
        private set

    @SerializedName("slug")
    var slug: String? = null
        private set

    @SerializedName("is_like")
    var isLike: Boolean? = null

    @SerializedName("publisher")
    var publisher: PublisherModel? = null
        private set

    @SerializedName("item_type")
    var itemType: Int? = null
        private set

    @SerializedName("published_at")
    var publishedAt: String? = null
        private set

    @SerializedName("thumbnail")
    var thumbnail: String? = null
        private set

    @SerializedName("language")
    var language: String? = null
        private set

    @SerializedName("post_type")
    var postType: String? = null
        private set

    @SerializedName("action_counts")
    var actionCounts: ActionCountModel? = null
        private set

    @SerializedName("product_url")
    var productUrl: String? = null
        private set

    @SerializedName("expert")
    var expertModel: ExpertModel? = null
        private set

}