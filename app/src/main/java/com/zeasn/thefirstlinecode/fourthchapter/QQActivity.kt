package com.zeasn.thefirstlinecode.fourthchapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.zeasn.thefirstlinecode.R
import kotlinx.android.synthetic.main.activity_q_q.*

class QQActivity : AppCompatActivity() {
    private val msgList = ArrayList<Msg>()
    private lateinit var adapter: MsgAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_q_q)
        initMsg()
        val layoutManager = LinearLayoutManager(this)
        rvMsg.layoutManager = layoutManager
        if (!::adapter.isInitialized)
            adapter = MsgAdapter(msgList)
        rvMsg.adapter = adapter
        btnSend.setOnClickListener {
            val content = etInput.text.toString()
            if (content.isNotEmpty()) {
                val msg = Msg(content, Msg.TYPE_SENT)
                msgList.add(msg)
                adapter.notifyItemInserted(msgList.size - 1)
                rvMsg.scrollToPosition(msgList.size - 1)
                etInput.setText("")
            }
        }
    }


    private fun initMsg() {
        val msg1 = Msg("在", Msg.TYPE_RECEIVED)
        msgList.add(msg1)
        val msg2 = Msg("有事吗?", Msg.TYPE_SENT)
        msgList.add(msg2)
        val msg3 = Msg("然后呢? ", Msg.TYPE_RECEIVED)
        msgList.add(msg3)
    }
}