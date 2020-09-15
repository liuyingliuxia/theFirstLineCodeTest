package com.zeasn.thefirstlinecode.thirdchapter

import android.app.Activity

/**
 * author : Miracle.lin
 * time   : 2020/09/14
 * desc   :
 * e-mail : miracle.lin@zeasn.com
 */
object ActivityCollector {
    private val activities = ArrayList<Activity>()

    fun addActivity(activity:Activity) {
        activities.add(activity)
    }

    fun removeActivity(activity: Activity) {
        activities.remove(activity)
    }

    fun finishAll() {
        for (activity in activities ){
            if(!activity.isFinishing){
                activity.finish()
            }
        }
        activities.clear()
    }
   //杀掉当前进程： android.os.Process.killProcess(android.os.Process.myPid())
}

