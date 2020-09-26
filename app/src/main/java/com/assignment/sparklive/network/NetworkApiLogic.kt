package com.assignment.sparklive.network

import android.content.Context
import com.assignment.sparklive.model.ResultMainModel
import com.google.gson.Gson
import kotlinx.coroutines.delay
import java.io.InputStream

class NetworkApiLogic {

    suspend fun getResultData(context: Context) : ResultMainModel {
        //to fake the network call
        delay(1000)
        val gson = Gson()
        return gson.fromJson(readJSONFromAsset(context), ResultMainModel::class.java)
    }

    fun readJSONFromAsset(context: Context): String? {
        var json: String? = null
        try {
            val inputStream: InputStream = context.assets.open("items.json")
            json = inputStream.bufferedReader().use{it.readText()}
        } catch (ex: Exception) {
            ex.printStackTrace()
            return null
        }
        return json
    }

}