package com.example.health_fitness


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.speech.tts.TextToSpeech
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_excercise.*
import java.util.*
import kotlin.collections.ArrayList

class ExerciseActivity : AppCompatActivity(), TextToSpeech.OnInitListener {
    var restProgress=0
    var exerciseProgress=0
    var exerciseNumber=0
    var restTimer:CountDownTimer?=null
    var exerciseTimer:CountDownTimer?=null
    var exerciseList:ArrayList<exerciseModel>?=null
    var tts:TextToSpeech?=null
    var adapterObj:RecyclerViewAdapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_excercise)
        setSupportActionBar(toolbar)
        val actionbar = supportActionBar
        if(actionbar!=null)
            actionbar.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
        tts= TextToSpeech(this,this)
        exerciseList=exerciseController.getExercise()
        setupRecyclerView()
        setupRestView()
    }

    override fun onDestroy() {
        if(restTimer!=null)
        {
            restTimer!!.cancel()
            restProgress=0
        }
        if(exerciseTimer!=null)
        {
            exerciseTimer!!.cancel()
            exerciseProgress=0
        }
        if(tts!=null)
        {
            tts!!.stop()
            tts!!.shutdown()
        }
        super.onDestroy()
    }

    fun callnextActivity()
    {
        val intent= Intent(this,FinalActivity::class.java)
        startActivity(intent)
        finish()
    }

       fun setupRestProgressBar()
       {
           restTimer = object:CountDownTimer(10000,1000){

               override fun onTick(millisUntilFinished: Long) {
                  RestProgressbar.progress= 10-restProgress
                   restProgress_tv.text=(10-restProgress).toString()
                   ++restProgress
               }
               override fun onFinish() {
                     ++exerciseNumber
                     exerciseList!![exerciseNumber-1].isSelected=true
                      adapterObj!!.notifyDataSetChanged()
                     setupExerciseView()
               }
           }.start()
       }

       fun setupExerciseProgressBar()
       {
           exerciseTimer = object:CountDownTimer(30000,1000){

               override fun onTick(millisUntilFinished: Long) {
                   ExerciseProgressbar.progress= 30-exerciseProgress
                   ExerciseProgress_tv.text=(30-exerciseProgress).toString()
                   ++exerciseProgress
               }
               override fun onFinish() {

                   if(exerciseNumber<=exerciseList!!.size-1) {
                       exerciseList!![exerciseNumber-1].isCompleted=true
                       exerciseList!![exerciseNumber-1].isSelected=false
                       adapterObj!!.notifyDataSetChanged()
                       setupRestView()
                   }
                   else
                       callnextActivity()
               }
           }.start()
       }
    fun setupRestView()
    {
        Exerciselayout.visibility= View.GONE
        Restlayout.visibility=View.VISIBLE
        if(restTimer!=null)
        {
            restTimer!!.cancel()
            restProgress=0
        }
        upcoming_exercise.text=exerciseList!![exerciseNumber].name
        saytheword("Rest Time")
        setupRestProgressBar()
    }
    fun setupExerciseView()
    {
        Exerciselayout.visibility= View.VISIBLE
        Restlayout.visibility=View.GONE
        if(exerciseTimer!=null)
        {
            exerciseTimer!!.cancel()
            exerciseProgress=0
        }
        image.setImageResource(exerciseList!![exerciseNumber-1].image)
        exercise_name.text=exerciseList!![exerciseNumber-1].name
        saytheword(exerciseList!![exerciseNumber-1].name)
        setupExerciseProgressBar()
    }

    override fun onInit(status: Int) {
      if(status==TextToSpeech.SUCCESS)
      {
          val result=tts!!.setLanguage(Locale.US)
          if(result==TextToSpeech.LANG_MISSING_DATA||result==TextToSpeech.LANG_NOT_SUPPORTED)
          {
              Log.e("Error","Language not supported")
          }
          else
              Log.e("Error","Text to speech not found")
      }
    }
    fun saytheword(text:String)
    {
        tts!!.speak(text,TextToSpeech.QUEUE_ADD,null,null)
    }
    fun setupRecyclerView()
    {
        recycler_view.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        adapterObj= RecyclerViewAdapter(exerciseList!!,this)
        recycler_view.adapter=adapterObj
    }
}