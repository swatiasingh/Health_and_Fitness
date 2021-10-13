package com.example.health_fitness

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        start.setOnClickListener { v->
            val intent= Intent(this,ExerciseActivity::class.java)
            startActivity(intent)
        }
        history.setOnClickListener { v->
            val intent = Intent(this,HistoryActivity::class.java)
            startActivity(intent)
        }
        bmi.setOnClickListener { v->
            val intent=Intent(this,BMIActivity::class.java)
            startActivity(intent)
        }
    }
}