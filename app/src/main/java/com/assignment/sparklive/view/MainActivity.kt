package com.assignment.sparklive.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.assignment.sparklive.R
import com.assignment.sparklive.adapter.ResultAdapter
import com.assignment.sparklive.listeners.OnResultItemClick
import com.assignment.sparklive.model.ResultMainModel
import com.assignment.sparklive.model.ResultsModel
import com.assignment.sparklive.network.Status
import com.assignment.sparklive.viewModel.ResultViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.no_connection_layout.*

class MainActivity : AppCompatActivity(),OnResultItemClick  {

    private  lateinit var mProgressBar: LinearLayout
    private lateinit var mRecylerView : RecyclerView
    private var mAdapter : ResultAdapter?=null
    private var resultList : ArrayList<ResultsModel> = ArrayList()
    private lateinit var viewModel: ResultViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mProgressBar = findViewById(R.id.llProgressBar)
        mRecylerView = findViewById(R.id.result_list)
        mAdapter = ResultAdapter(this, resultList, this)
        mRecylerView.layoutManager = GridLayoutManager(this, 2)
        mRecylerView.adapter = mAdapter
        getResultData()
    }

    private fun getResultData() {
        viewModel =
            ViewModelProviders.of(this).get(ResultViewModel::class.java)

        viewModel.fetchResultData(this).observe(this, androidx.lifecycle.Observer {
            it?.let{
                    resource ->
                when(resource.status){
                    Status.SUCCESS -> {
                        no_internet_layout.visibility = View.GONE

                        mRecylerView.visibility = View.VISIBLE
                        mProgressBar.visibility = View.GONE
                        resource.data?.let {
                                stream -> retrieveList(stream)
                        }
                    }
                    Status.ERROR -> {
                        mRecylerView.visibility = View.GONE
                        mProgressBar.visibility = View.GONE
                        Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                        onErrorOccured(it.message?:"Unknown Error")
                    }
                    Status.LOADING -> {
                        no_internet_layout.visibility = View.GONE
                        mProgressBar.visibility = View.VISIBLE
                        mRecylerView.visibility = View.GONE
                    }

                }
            }
        })

    }

    private fun retrieveList(stream: ResultMainModel) {
        resultList.apply {
            clear()
            if(stream.resultsModel?.isEmpty() == true){
                onErrorOccured("No Data Found!")
            }else{
                stream.resultsModel?.let { addAll(it) }
                mAdapter?.notifyDataSetChanged()
            }
        }
    }

    private fun onErrorOccured(errStr:String){
        no_internet_layout.visibility = View.VISIBLE
        no_content_image.setImageDrawable(this?.let { ContextCompat.getDrawable(it, R.drawable.ic_no_data) })
        no_content_text.text = errStr
    }

    override fun onItemClick(model: ArrayList<ResultsModel>) {
       // not required as of now
    }
}