package com.varefree.tasker.localTransactions

import com.varefree.tasker.Tasker
import com.varefree.tasker.TaskerViewModel.DummyData
import com.varefree.tasker.retrofitAPI.Task

object LocalVM {

    private var taskerList = mutableListOf<Tasker>()
    private var tasId:Long = generateUID()


   private fun generateUID():Long{

       if(taskerList.size > 0)
           tasId = taskerList.get(taskerList.size-1).ID

       return ++tasId
   }

    //Getter
     fun getList(): List<Tasker> {
        if(taskerList.size <= 0) taskerList.addAll(DummyData.dummyList)
        return taskerList
    }

    //Insertion of task
    fun insertTask(title:String,desc:String):Boolean{

        //checking if the charachter os
       if( title.length > 0 && desc.length > 0)
       {
           //adding it to the list
           taskerList.add(Tasker(generateUID(),title,desc))
           taskerList.removeAll(DummyData.dummyList) //REMOVIG THE DUMMY DATA

           return true
       }

        return false
    }

    //TODO OPTION TO SERACH WITH ID
    fun searchWithID(ID: Long)
    {
    }

    //TODO OPTION TO MARK COMPLETION
    fun swithchCompletion(ID:Long)
    {}

    //TODO OPTION TO MODIFY CONTENT
    fun updateContent(ID:Long, title:String, description:String)
    {}

    //TODO TEMP DEL/HIDE SWITCHING

    //TODO OPTION TO DELETE COMPLETLY

    //TODO OPTION MULTIPLE SELECT !NOT IMPORTANT

}