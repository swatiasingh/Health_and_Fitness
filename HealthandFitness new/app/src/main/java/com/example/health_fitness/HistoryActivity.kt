package com.example.health_fitness

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_final.*
import kotlinx.android.synthetic.main.activity_history.*

class HistoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
        setSupportActionBar(history_toolbar)
        val actionbar = supportActionBar
        if(actionbar!=null)
            actionbar.setDisplayHomeAsUpEnabled(true)
        history_toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
        val db = SqliteOpenHelper(this, null)
        val dates = db.getDates()

        if (dates.size > 0) {
            tv_1.visibility= View.GONE
            tv_2.visibility=View.GONE
            history_RecyclerView.visibility=View.VISIBLE
            val adapterObj = HistoryAdapter(this, dates)
            history_RecyclerView.layoutManager=LinearLayoutManager(this)
            history_RecyclerView.adapter=adapterObj
        }
    }
}