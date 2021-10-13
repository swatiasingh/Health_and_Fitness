package com.example.health_fitness

data class exerciseModel(
    val id:Int,
    val name:String,
    val image:Int,
    var isSelected:Boolean,
    var isCompleted:Boolean
)