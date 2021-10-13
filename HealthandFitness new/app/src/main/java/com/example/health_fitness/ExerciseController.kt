package com.example.health_fitness

object exerciseController
{
    fun getExercise():ArrayList<exerciseModel>
    {
        val exercises=ArrayList<exerciseModel>()
        val e1=exerciseModel(1,"Push Up",R.drawable.pushup,false,false)
        exercises.add(e1)
        val e2=exerciseModel(2,"Squats",R.drawable.squats,false,false)
        exercises.add(e2)
        val e3=exerciseModel(3,"Abs",R.drawable.abs,false,false)
        exercises.add(e3)
        val e4=exerciseModel(4,"Plank",R.drawable.planks,false,false)
        exercises.add(e4)
        val e5=exerciseModel(5,"Jumping Jacks",R.drawable.jumping_jacks,false,false)
        exercises.add(e5)
        return exercises
    }
}