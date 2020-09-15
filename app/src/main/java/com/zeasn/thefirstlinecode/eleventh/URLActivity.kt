package com.zeasn.thefirstlinecode.eleventh

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.zeasn.thefirstlinecode.R
import kotlinx.android.synthetic.main.activity_url.*
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.lang.Exception
import java.lang.StringBuilder
import java.net.HttpURLConnection
import java.net.URL
import java.nio.Buffer
import kotlin.concurrent.thread

class URLActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_url)
        sendRequestBtn.setOnClickListener {
            sendRequestWithHttpURLConnection()
            //Toast.makeText(this, "ping...", Toast.LENGTH_SHORT).show()
        }
    }

    private fun sendRequestWithHttpURLConnection() {
        /* 使用 HttpURLConnection 实现网络请求
        thread {
            var connection: HttpURLConnection? = null
            try {
                val response = StringBuilder()
                val url = URL("https://www.baidu.com")
                connection = url.openConnection() as HttpURLConnection
                connection.connectTimeout = 8000
                connection.readTimeout = 8000
                val input = connection.inputStream
                val reader = BufferedReader(InputStreamReader(input))
                reader.use {
                    reader.forEachLine {
                        response.append(it)
                    }
                }
                showResponse(response.toString())
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                connection?.disconnect()
            }
        }*/

        //使用OKHttpClient 实现网络请求
        try {
            Toast.makeText(this, "TRY!!!", Toast.LENGTH_SHORT).show()
            val client = OkHttpClient()
            val request = Request.Builder()
                .url("https://www.baidu.com")
                .build()
            val response = client.newCall(request).execute()
            val responseData = response.body?.string()
            if (responseData != null) {
                Toast.makeText(this, "有数据不为空", Toast.LENGTH_SHORT).show()
                showResponse(responseData)
            } else {
                Toast.makeText(this, "Null", Toast.LENGTH_SHORT).show()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
      /*  thread{

        }*/
    }

    private fun showResponse(response: String) {
        runOnUiThread {
            responseText.text = response
        }
    }
}