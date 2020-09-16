package com.zeasn.thefirstlinecode.eighth

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.zeasn.thefirstlinecode.R
import kotlinx.android.synthetic.main.activity_content_provider.*
import java.util.jar.Manifest

class ContentProviderActivity : AppCompatActivity() {
    private var contactsList = ArrayList<String>()
    private lateinit var adapter : ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_provider)

        adapter = ArrayAdapter(this , android.R.layout.simple_list_item_1 , contactsList )
        lvContacts.adapter = adapter
        //获取授权
        if(ContextCompat.checkSelfPermission(this ,
                android.Manifest.permission.READ_CONTACTS )!= PackageManager.PERMISSION_GRANTED ){
            ActivityCompat.requestPermissions(this ,
                arrayOf(android.Manifest.permission.READ_CONTACTS), 1)

        }else{
            readContacts()
        }

        btnCall.setOnClickListener {
          if(ContextCompat.checkSelfPermission(this ,
                  android.Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED ){
              ActivityCompat.requestPermissions(this ,
                  arrayOf(android.Manifest.permission.CALL_PHONE), 1)

          }else{
              call()
          }
        }

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode) {
            1 -> {
                if(grantResults.isNotEmpty()&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    call()
                }else{
                    Toast.makeText(this , "你拒绝了授权" ,Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
    private fun call() {
        try {
            val intent = Intent(Intent.ACTION_CALL)
            intent.data = Uri.parse("tel:10086")
            startActivity(intent)
        }catch (e:Exception){
            e.printStackTrace()
        }
    }

    private fun readContacts() {
        contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI ,
            null , null , null ,null  )?.apply {
            while (moveToNext()){
                val displayName = getString(getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME))

                val number = getString(getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER ))

                contactsList.add("$displayName \n$number ")
            }

            adapter.notifyDataSetChanged()
            close()
        }
    }
}