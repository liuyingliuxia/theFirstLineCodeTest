package com.zeasn.thefirstlinecode.thirteenth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.zeasn.thefirstlinecode.R
import kotlinx.android.synthetic.main.activity_room.*
import kotlin.concurrent.thread

class RoomActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)

        val userDao = AppDatabase.getDatabase(this).userDao()
        val user1 = User("Maria", "Mike", 12)
        val user2 = User("Tom", "Tony", 22)
        btnAddData.setOnClickListener {
            thread {
                user1.id = userDao.insertUser(user1)
                user2.id = userDao.insertUser(user2)
            }
        }

        btnUpdateData.setOnClickListener {
            thread {
                user1.age = 43
                userDao.updateUser(user1)
            }
        }

        btnDeleteData.setOnClickListener {
            thread {
                userDao.deleteUserByLastName("Tony")
            }
        }

        btnQueryData.setOnClickListener {
            Log.d("Room: ", "click btnQueryData")
            thread {
                 Log.d("Room: ", "click btnQueryData")
                for (user in userDao.loadAllUsers()) {
                    Log.d("Room: ", user.toString())
                }
            }
        }
    }
}