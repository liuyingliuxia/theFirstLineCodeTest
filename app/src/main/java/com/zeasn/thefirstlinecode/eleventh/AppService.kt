package com.zeasn.thefirstlinecode.eleventh

import retrofit2.Call
import retrofit2.http.GET

/**
 * author : Miracle.lin
 * time   : 2020/09/16
 * desc   :
 * e-mail : miracle.lin@zeasn.com
 */
interface AppService {

    @GET("my_data.json")
    fun getAppData(): Call<List<App>>
}