package com.zeasn.thefirstlinecode.fourthchapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zeasn.thefirstlinecode.R
import kotlinx.android.synthetic.main.qq_left_item.view.*
import java.lang.IllegalArgumentException

/**
 * author : Miracle.lin
 * time   : 2020/09/15
 * desc   :
 * e-mail : miracle.lin@zeasn.com
 */

class MsgAdapter (val msgList:List<Msg> ):RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    inner class LeftViewHolder(view : View) :RecyclerView.ViewHolder(view) {
        val leftMsg: TextView = view.findViewById(R.id.tvLeftMsg)
    }

    inner class RightViewHolder(view : View) :RecyclerView.ViewHolder(view) {
        val rightMsg: TextView = view.findViewById(R.id.tvRightMsg)
    }

    override fun getItemViewType(position: Int): Int {
        val msg = msgList[position]
        return msg.type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = if(viewType == Msg.TYPE_RECEIVED){
        val view = LayoutInflater.from(parent.context).inflate(R.layout.qq_left_item , parent , false)
        LeftViewHolder(view)
    }else {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.qq_right_item,parent , false)
        RightViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val msg= msgList[position]
        when(holder){
            is LeftViewHolder -> holder.leftMsg.text = msg.content
            is RightViewHolder -> holder.rightMsg.text = msg.content
            else -> throw IllegalArgumentException()
        }
    }

    override fun getItemCount() = msgList.size

}