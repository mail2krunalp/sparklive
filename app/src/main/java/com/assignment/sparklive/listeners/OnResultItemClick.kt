package com.assignment.sparklive.listeners

import com.assignment.sparklive.model.ResultsModel

interface OnResultItemClick {
    fun onItemClick(model : ArrayList<ResultsModel>)
}