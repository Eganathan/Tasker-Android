package com.varefree.tasker.retrofitAPI

//Data class for task
 data class Task(
    val id:Long,
    val title:String,
    val description:String,
    val isCompleted:Boolean,
    val isVisible:Boolean
)
