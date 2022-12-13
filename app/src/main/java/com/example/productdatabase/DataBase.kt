package com.example.databaseproject

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import kotlin.math.log

class DataBase(val context: Context) : SQLiteOpenHelper(context,"StudentData.db",null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val data = "Create table StudentTb(StudentId integer primary key autoincrement,StudentName text,MobileNo integer,Password text)"
        db?.execSQL(data)

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {


    }

    fun dataInsert(userName: String, mobileNumber: String, password: String)
    {
        val db = writableDatabase
        val c= ContentValues()
        c.put("StudentName",userName)
        c.put("MobileNo",mobileNumber)
        c.put("Password",password)


        val result = db.insert("StudentTb",null,c)
        Log.e("TAG", "dataInsert: result "+result )

    }

    fun dataDisplay() {
        val db=readableDatabase
        val sql ="select * from StudentTb"
        val cursor=db.rawQuery(sql,null)

        if (cursor.count > 0)
        {

            if (cursor.moveToFirst())
            {
                do {
                    val id = cursor.getInt(0)
                    val name = cursor.getString(1)
                    val number = cursor.getInt(2)
                    val pwd = cursor.getInt(3)

                    Log.e("TAG", "dataDisplay: "+id+""+name+""+number+""+pwd )
                }while (cursor.moveToNext())
            }
        }
        else
        {
            Log.e("TAG", "dataDisplay: "+"No Data Found" )
        }
    }


}
