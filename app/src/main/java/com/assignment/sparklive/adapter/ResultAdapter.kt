package com.assignment.sparklive.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.assignment.sparklive.R
import com.assignment.sparklive.listeners.OnResultItemClick
import com.assignment.sparklive.model.ResultsModel
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

class ResultAdapter(val context: Context, val resultList : ArrayList<ResultsModel>
                    , val itemClick : OnResultItemClick) : RecyclerView.Adapter<ResultAdapter.ItemViewHolder>() {
    var mInflater: LayoutInflater? = null

    init {
        mInflater = LayoutInflater.from(context)
    }

    class ItemViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var mUserImg: AppCompatImageView = itemView.findViewById(R.id.userImg)
        internal var mUserName: AppCompatTextView = itemView.findViewById(R.id.userName)
        internal var mUserDesc: AppCompatTextView = itemView.findViewById(R.id.userDesc)
        internal var mPostImg: AppCompatImageView = itemView.findViewById(R.id.postImg)
        internal var mPostLike: AppCompatImageView = itemView.findViewById(R.id.like)
        internal var mViewsCount: AppCompatTextView = itemView.findViewById(R.id.viewCount)
        internal var mLikeCount: AppCompatTextView = itemView.findViewById(R.id.likeCount)
        internal var mPostDesc: AppCompatTextView = itemView.findViewById(R.id.postDesc)
        internal var mPostDate: AppCompatTextView = itemView.findViewById(R.id.postDate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(context).
            inflate(R.layout.custom_result_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return resultList.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        val resultData: ResultsModel = resultList[position]

        Picasso.with(context).load(resultData.publisher?.thumbnail)
            .placeholder(R.drawable.ic_user)
            .error(R.drawable.ic_user).into(holder.mUserImg, object : Callback {
                override fun onSuccess() {
                    Log.d("UserImg", "onSuccess")
                }
                override fun onError() {
                    Log.d("UserImg", "onError")
                }
            })

        holder.mUserName.text = resultData.publisher?.name

        holder.mUserDesc.text = resultData.publisher?.description

        Picasso.with(context).load(resultData.thumbnail)
            .placeholder(R.drawable.ic_gallery)
            .error(R.drawable.ic_gallery).into(holder.mPostImg, object : Callback {
                override fun onSuccess() {
                    Log.d("UserImg", "onSuccess")
                }
                override fun onError() {
                    Log.d("UserImg", "onError")
                }
            })

        if(resultData.isLike == null || resultData.isLike == false){
            holder.mPostLike.setBackgroundResource(R.drawable.ic_like)
        }else{
            holder.mPostLike.setBackgroundResource(R.drawable.ic_like_red)
        }

        holder.mPostLike.setOnClickListener {

            if(resultData.isLike == null || resultData.isLike == false){
                resultData.isLike = true
                resultData.actionCounts?.like = resultData.actionCounts?.like?.plus(1)
            }else{
                resultData.isLike = false
                resultData.actionCounts?.like = resultData.actionCounts?.like?.minus(1)
            }

            notifyDataSetChanged()
        }

        holder.mViewsCount.text = "100 Views"

        holder.mLikeCount.text = resultData.actionCounts?.like.toString() + " likes"

        holder.mPostDesc.text = resultData.description

        holder.mPostDate.text = resultData.publishedAt

    }
}