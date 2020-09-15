package com.zeasn.thefirstlinecode.fifthchapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zeasn.thefirstlinecode.R
import kotlinx.android.synthetic.main.activity_news.*
import kotlinx.android.synthetic.main.fragment_news_title.*

/**
 * author : Miracle.lin
 * time   : 2020/09/15
 * desc   :
 * e-mail : miracle.lin@zeasn.com*/

class NewsTitleFragment : Fragment() {
    private var isTwoPane = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_news_title, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        isTwoPane = activity?.findViewById<View>(R.id.llContent) != null
        val layoutManager = LinearLayoutManager(activity)
        newsTitleRecyclerView.layoutManager = layoutManager
        val adapter = NewsAdapter(getNews())
        newsTitleRecyclerView.adapter = adapter
    }

    private fun getNews(): List<News> {
        val newsList = ArrayList<News>()
        repeat(50) {
            val news = News("新闻标题：${it+1}", getRandomLengthString("新闻内容:${it+1}."))
            newsList.add(news)
        }
        return newsList
    }

    private fun getRandomLengthString(str: String): String {
        val n = (1..50).random()
        val builder = StringBuffer()
        repeat(n) {
            builder.append(str)
        }
        return builder.toString()
    }

    inner class NewsAdapter(private val newsList: List<News>) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val newsTitle: TextView = view.findViewById(R.id.tvNewsTitle)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.news_item, parent, false)
            val holder = ViewHolder(view)
            holder.itemView.setOnClickListener {
                val news = newsList[holder.adapterPosition]
                if (isTwoPane) {
                    val fragment = newsContentFrag as NewsContentFragment
                    fragment.refresh(news.title, news.content)
                } else {
                    NewsContentActivity.actionStart(parent.context, news.title, news.content)
                }
            }
            return holder
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val news = newsList[position]
            holder.newsTitle.text = news.title
        }

        override fun getItemCount() = newsList.size

    }


}