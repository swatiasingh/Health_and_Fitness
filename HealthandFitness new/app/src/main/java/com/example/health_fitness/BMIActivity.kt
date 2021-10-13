package com.example.health_fitness

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_b_m_i.*

class BMIActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b_m_i)
        setSupportActionBar(BMI_Toolbar)
        val actionbar = supportActionBar
        if(actionbar!=null)
            actionbar.setDisplayHomeAsUpEnabled(true)
        BMI_Toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
        bmi_btn.setOnClickListener { v ->
            calculateBMI()
        }
    }

    fun calculateBMI() {
             val weight = weight_tv.text.toString()
             val height = height_tv.text.toString()
                 if (weight.isEmpty() || height.isEmpty())
                 {
                     Toast.makeText(this, "Enter the required field", Toast.LENGTH_SHORT).show()
                 }
                 else
                 {
                     val w=weight.toDouble()
                     val h=height.toDouble()
                     var result = w / (h * h)
                     bmi_tv.text = "BMI Index: ${result}"
                 }
           }
}