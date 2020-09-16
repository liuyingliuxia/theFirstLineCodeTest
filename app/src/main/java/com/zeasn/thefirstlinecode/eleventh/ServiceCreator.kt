package com.zeasn.thefirstlinecode.eleventh

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * author : Miracle.lin
 * time   : 2020/09/16
 * desc   :
 * e-mail : miracle.lin@zeasn.com
 */
object ServiceCreator {
    private const val BASE_URL = "http://10.0.2.2/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    //inline fun <reified T> create():T = create(T::class.java)
}