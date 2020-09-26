package com.assignment.sparklive.model

import com.google.gson.annotations.SerializedName

class ExpertModel {
    @SerializedName("id")
    var id: Int? = null
        private set

    @SerializedName("user_id")
    var userId: String? = null
        private set

    @SerializedName("slug")
    var slug: String? = null
        private set

    @SerializedName("name")
    var name: String? = null
        private set

    @SerializedName("email")
    var email: String? = null
        private set

    @SerializedName("profile_pic")
    var profilePic: String? = null
        private set

    @SerializedName("banner")
    var banner: String? = null
        private set

    @SerializedName("is_profile_pic_set")
    var isProfilePicSet: Boolean? = null
        private set

    @SerializedName("language")
    var language: String? = null
        private set

    @SerializedName("is_expert")
    var isExpert: Boolean? = null
        private set

    @SerializedName("is_expert_live")
    var isExpertLive: Boolean? = null
        private set

    @SerializedName("is_tick_verified")
    var isTickVerified: Boolean? = null
        private set

    @SerializedName("expert_verification_state")
    var expertVerificationState: Int? = null
        private set

    @SerializedName("short_bio")
    var shortBio: String? = null
        private set

    @SerializedName("bio")
    var bio: String? = null
        private set

    @SerializedName("order")
    var order: Int? = null
        private set

    @SerializedName("location")
    var location: String? = null
        private set

    @SerializedName("city")
    var city: String? = null
        private set

    @SerializedName("gender")
    var gender: String? = null
        private set

    @SerializedName("expert_categories")
    var expertCategories: ArrayList<ExpertCategoriesModel>? = null
        private set

//    @SerializedName("expert_misc")
//    var expertMisc: String? = null
//        private set

    @SerializedName("intro_video_url")
    var introVideoUrl: String? = null
        private set

    @SerializedName("payment_url")
    var paymentUrl: String? = null
        private set

    @SerializedName("known_languages")
    var knownLanguages: ArrayList<String>? = null
        private set

    @SerializedName("country_code")
    var countryCode: String? = null
        private set
}