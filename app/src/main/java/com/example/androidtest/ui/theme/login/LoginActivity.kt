package com.example.androidtest.ui.theme.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.androidtest.R
import com.example.androidtest.ui.theme.employeelist.EmployeeListActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        findViewById<Button>(R.id.loginButton).setOnClickListener {
            val id = findViewById<EditText>(R.id.inputUserId).text.toString()
            if (id.isNotEmpty()) {
                startActivity(Intent(this, EmployeeListActivity::class.java))
                finish()
            }
        }
    }
}