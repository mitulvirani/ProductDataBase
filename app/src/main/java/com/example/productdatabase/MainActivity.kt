package com.example.databaseproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.widget.AppCompatButton
import com.example.productdatabase.R

class MainActivity : AppCompatActivity() {
    lateinit var btnInsertData: AppCompatButton
    lateinit var btnDisplayData: AppCompatButton
    lateinit var edtUserName: EditText
    lateinit var edtMobileNumber: EditText
    lateinit var edtPassword: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        initview()
    }

    private fun initview() {

        btnInsertData = findViewById(R.id.btnInsertData)
        btnDisplayData = findViewById(R.id.btnDisplayData)
        edtUserName = findViewById(R.id.edtUserName)
        edtMobileNumber = findViewById(R.id.edtMobileNumber)
        edtPassword = findViewById(R.id.edtPassword)


        var userName = edtUserName.text.toString()
        var mobileNumber = edtMobileNumber.text.toString()
        var password = edtPassword.text.toString()

        var db = DataBase(this)

        btnInsertData.setOnClickListener {
            db.dataInsert(userName,mobileNumber,password)
        }

        btnDisplayData.setOnClickListener {
            db.dataDisplay()
        }


    }
}