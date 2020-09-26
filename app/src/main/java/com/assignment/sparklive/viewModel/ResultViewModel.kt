package com.assignment.sparklive.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.assignment.sparklive.network.NetworkApiLogic
import com.assignment.sparklive.network.Resource
import kotlinx.coroutines.Dispatchers

class ResultViewModel: ViewModel() {

    fun fetchResultData(context:Context)
            = liveData(Dispatchers.IO){
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = NetworkApiLogic().getResultData(context)))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }

}