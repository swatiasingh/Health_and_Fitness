package com.example.health_fitness

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_final.*
import java.text.SimpleDateFormat
import java.util.*

class FinalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)
        setSupportActionBar(Final_toolbar)
        val actionbar = supportActionBar
        if(actionbar!=null)
            actionbar.setDisplayHomeAsUpEnabled(true)
        Final_toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
        finish.setOnClickListener {
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        calculateDate()
    }
    private fun calculateDate()
    {
        val calendar= Calendar.getInstance()
        val dateTime=calendar.time
        val sdf=SimpleDateFormat("dd MM yyyy HH mm ss", Locale.US)
        val date=sdf.format(dateTime)
        val dbHandler=SqliteOpenHelper(this,null)
        dbHandler.addDate(date)
    }
}