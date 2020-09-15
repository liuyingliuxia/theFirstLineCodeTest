package com.zeasn.thefirstlinecode.sixth

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
        login.setOnClickListener {
            val account = accountEdit.text.toString()
            val password = passwordEdit.text.toString()
            if (account == "root" && password == "root") {
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