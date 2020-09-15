package com.zeasn.thefirstlinecode.fifthchapter

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zeasn.thefirstlinecode.R
import kotlinx.android.synthetic.main.activity_news_content.*

class NewsContentActivity : AppCompatActivity() {

    companion object {
        fun actionStart(context:Context , title:String , content:String ){
            val intent = Intent (context ,NewsContentActivity::class.java).apply{
                putExtra("新闻标题：",title)
                putExtra("新闻内容：",content)
            }
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_content)
        val title = intent.getStringExtra("新闻标题：")
        val content = intent.getStringExtra("新闻内容：")
        if (title!= null && content!=null ) {
            val fragment = newsContentFrag as NewsContentFragment
            fragment.refresh(title , content )
        }
    }
}