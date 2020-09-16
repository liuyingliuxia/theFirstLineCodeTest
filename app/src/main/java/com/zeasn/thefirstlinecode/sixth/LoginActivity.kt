package com.zeasn.thefirstlinecode.sixth

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.zeasn.thefirstlinecode.R
import com.zeasn.thefirstlinecode.thirdchapter.BaseActivity
import com.zeasn.thefirstlinecode.thirdchapter.MainActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val prefs = getPreferences(Context.MODE_PRIVATE)
        val isRemember = prefs.getBoolean("remember_pwd", false )
        if(isRemember){
            val account = prefs.getString("account" , "")
            val pwd = prefs.getString("pwd" , "")
            accountEdit.setText(account)
            passwordEdit.setText(pwd)
            cbRemember.isChecked = true
        }

        login.setOnClickListener {
            val account = accountEdit.text.toString()
            val password = passwordEdit.text.toString()
            if (account == "root" && password == "root") {
                val editor = prefs.edit()
                if(cbRemember.isChecked ){
                    editor.putBoolean("remember_pwd" , true)
                    editor.putString("account" , account )
                    editor.putString("pwd" , password)
                }else{
                    editor.clear()
                }
                editor.apply()

                Toast.makeText(this, "登录成功！", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }else {
                Toast.makeText(this , "账号或密码错误！" , Toast.LENGTH_SHORT).show()
            }
        }
    }
}