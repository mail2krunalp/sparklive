package com.assignment.sparklive.model

import com.google.gson.annotations.SerializedName

class ResultMainModel {
    @SerializedName("results")
    var resultsModel: ArrayList<ResultsModel>? = null
        private set
}