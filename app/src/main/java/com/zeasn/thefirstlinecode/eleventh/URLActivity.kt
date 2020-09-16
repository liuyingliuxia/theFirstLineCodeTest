package com.zeasn.thefirstlinecode.eleventh

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.zeasn.thefirstlinecode.R
import kotlinx.android.synthetic.main.activity_url.*
import okhttp3.*
import org.json.JSONArray
import org.xml.sax.InputSource
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.*
import java.lang.Exception
import java.lang.StringBuilder
import java.net.HttpURLConnection
import java.net.URL
import java.nio.Buffer
import javax.xml.parsers.SAXParserFactory
import kotlin.concurrent.thread

class URLActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_url)
        sendRequestBtn.setOnClickListener {
            sendRequestWithHttpURLConnection()
        }

        btnRetrofit.setOnClickListener {
            val retrofit = Retrofit.Builder()
                .baseUrl("http://10.0.2.2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            val appService = retrofit.create(AppService::class.java)
            appService.getAppData().enqueue(object : Callback<List<App>> {
                @SuppressLint("LongLogTag")
                override fun onResponse(call: Call<List<App>>, response: Response<List<App>>) {
                    val list = response.body()
                    if (list != null) {
                        for (app in list) {
                            Log.d("URLActivity with Retrofit ", "id is ${app.id}")
                            Log.d("URLActivity with Retrofit ", "name is ${app.name}")
                            Log.d("URLActivity with Retrofit ", "version is ${app.version}")
                        }
                    }
                }

                override fun onFailure(call: Call<List<App>>, t: Throwable) {
                    t.printStackTrace()
                }

            })
        }
    }

    private fun sendRequestWithHttpURLConnection() {
        // 使用 HttpURLConnection 实现网络请求 成功！
        /*thread {
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
                Log.d("UPDATE", "OnResponse: $response")
                showResponse(response.toString())
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                connection?.disconnect()
            }
        }*/

        //使用OKHttp 实现网络请求
        thread {
            try {
                val client = OkHttpClient()
                val request = Request.Builder().get()
                    .url("http://10.0.2.2/my_data.json")
                    .build()
                val response = client.newCall(request).execute()
                val responseData = response.body?.string()
                if (responseData != null) {
                    // showResponse(responseData)
                    //解析XML
                    //parseXMLWithPull(responseData)
                    //parseXMLWithSAX(responseData)
                    //用JSONObject解析Json
                    // parseJSONWithJSONObject(responseData)
                    //用GSON 解析Json
                    parseJSONWithGSON(responseData)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        //网上的例子
        /*try {
            val client = OkHttpClient()
            val request = Request.Builder().get()
                .url("https://www.baidu.com")
                .build()

            val call = client.newCall(request)
            //异步请求
            call.enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    Log.d("UPDATE", "onFailure: $e")
                }

                @Throws(IOException::class)
                override fun onResponse(call: Call, response: Response) {
                    // showResponse(response.body?.string())
                    Log.d("UPDATE", "OnResponse: " + response.body?.string())
                }
            })
        } catch (e: Exception) {
            Log.e("UPDATE ERROR:", "", e)
        }*/
    }

    private fun showResponse(response: String?) {
        runOnUiThread {
            responseText.text = response
        }
    }

    private fun parseXMLWithPull(xmlData: String) {
        try {
            val factory = XmlPullParserFactory.newInstance()
            val xmlPullParser = factory.newPullParser()
            xmlPullParser.setInput(StringReader(xmlData))
            var eventType = xmlPullParser.eventType
            var id = ""
            var name = ""
            var version = ""
            while (eventType != XmlPullParser.END_DOCUMENT) {
                val nodeName = xmlPullParser.name
                when (eventType) {
                    XmlPullParser.START_TAG -> {
                        when (nodeName) {
                            "id" -> id = xmlPullParser.nextText()
                            "name" -> name = xmlPullParser.nextText()
                            "version" -> version = xmlPullParser.nextText()
                        }
                    }

                    XmlPullParser.END_TAG -> {
                        if ("app" == nodeName) {
                            Log.d("URLActivity", "id is $id")
                            Log.d("URLActivity", "name is $name")
                            Log.d("URLActivity", "version is $version")
                        }
                    }
                }
                eventType = xmlPullParser.next()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun parseXMLWithSAX(xmlData: String) {
        try {
            val factory = SAXParserFactory.newInstance()
            val xmlReader = factory.newSAXParser().xmlReader
            val handler = ContentHandler()
            xmlReader.contentHandler = handler
            xmlReader.parse(InputSource(StringReader(xmlData)))
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun parseJSONWithJSONObject(jsonData: String) {
        try {
            val jsonArray = JSONArray(jsonData)
            for (i in 0 until jsonArray.length()) {
                val jsonObject = jsonArray.getJSONObject(i)
                var id = jsonObject.getString("id")
                var name = jsonObject.getString("name")
                var version = jsonObject.getString("version")
                Log.d("URLActivity with JSON ", "id is $id")
                Log.d("URLActivity with JSON ", "name is $name")
                Log.d("URLActivity with JSON ", "version is $version")
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun parseJSONWithGSON(jsonData: String) {
        val gson = Gson()
        val typeOf = object : TypeToken<List<App>>() {}.type
        val appList = gson.fromJson<List<App>>(jsonData, typeOf)
        for (app in appList) {
            Log.d("URLActivity with GSON ", "id is ${app.id}")
            Log.d("URLActivity with GSON ", "name is ${app.name}")
            Log.d("URLActivity with GSON ", "version is ${app.version}")
        }


    }
}