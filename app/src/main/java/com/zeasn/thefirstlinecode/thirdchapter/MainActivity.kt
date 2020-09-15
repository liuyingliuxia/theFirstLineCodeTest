package com.zeasn.thefirstlinecode.thirdchapter

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.google.android.material.floatingactionbutton.FloatingActionButton
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.zeasn.thefirstlinecode.R

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("MainActivity " ,this.toString())
        Log.e("Second Activity" , "Task id is $taskId")
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            //提示文字
           /* Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()*/
            //打开一个网页
          /*  val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.tmall.com")
            startActivity(intent)*/
            //打开拨号器
       /*     val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:10086")
            startActivity(intent)*/
            //数据回传
           // val intent=Intent(this , TestActivity::class.java)
           // startActivityForResult(intent , 1 )
            //返回生命周期界面
            val intent=Intent(this , TestActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode ) {
            1 -> if(resultCode == RESULT_OK){
                val returnedData = data?.getStringExtra("data_return")
                Log.e("this Main " , "从Test界面返回的数据是 $returnedData ")
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("Main" , "onDestroy")
    }
}