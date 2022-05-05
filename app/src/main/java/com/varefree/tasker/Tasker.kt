package com.varefree.tasker

import java.io.Serializable

data class Tasker(
    val ID:Long,
    var Title:String,
    var Description:String,
    var isCompleted:Boolean = false
) : Serializable {
}