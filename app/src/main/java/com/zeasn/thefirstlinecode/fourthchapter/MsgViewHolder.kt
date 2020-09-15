package com.zeasn.thefirstlinecode.fourthchapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zeasn.thefirstlinecode.R

/**
 * author : Miracle.lin
 * time   : 2020/09/15
 * desc   :
 * e-mail : miracle.lin@zeasn.com
 */
sealed class MsgViewHolder(view: View) : RecyclerView.ViewHolder(view)
class LeftViewHolder(view: View) : MsgViewHolder(view) {
    val leftMsg: TextView = view.findViewById(R.id.tvLeftMsg)
}

class RightViewHolder(view: View) : MsgViewHolder(view) {
    val rightMsg: TextView = view.findViewById(R.id.tvRightMsg)
}