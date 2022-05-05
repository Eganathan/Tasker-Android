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
    fun searchWithID(ID: Long):Tasker?
    {
        for(task in taskerList)
        {
            if(task.ID === ID)
                return task
        }
       return null
    }

    //TODO OPTION TO MARK COMPLETION
    fun swithchCompletion(task:Tasker)
    {
        task.isCompleted = !task.isCompleted
    }

    //TODO OPTION TO MODIFY CONTENT
    fun updateContent(task:Tasker, title:String, description:String,isCompleted:Boolean)
    {
        task.Title = title
        task.Description = description
        task.isCompleted = isCompleted
    }

    //Recycler option
    fun moveToRecycler(task:Tasker)
    {
        //TODO TEMP DEL/HIDE SWITCHING
    }

    //TODO OPTION TO DELETE COMPLETLY

    //TODO OPTION MULTIPLE SELECT !NOT IMPORTANT

}