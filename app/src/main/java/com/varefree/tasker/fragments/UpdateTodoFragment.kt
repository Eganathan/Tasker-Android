package com.varefree.tasker.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.varefree.tasker.Tasker
import com.varefree.tasker.databinding.FragmentUpdateTodoBinding
import com.varefree.tasker.localTransactions.LocalVM


class UpdateTodoFragment : Fragment() {

    //Declaring the binding
    private lateinit var updateFragmentBind:FragmentUpdateTodoBinding
    private lateinit var task:Tasker
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //initializing the binding with an inflater
        updateFragmentBind = FragmentUpdateTodoBinding.inflate(inflater,container,false)

        var ID: Long? = arguments?.getLong("ID")

        if (ID != null) {
            task = LocalVM.searchWithID(ID)!!
        }

        updateFragmentBind.updateTitleET.setText(task.Title)
        updateFragmentBind.updateDescriptionET.setText(task.Description)
        updateFragmentBind.isCompleteCB.setChecked(task.isCompleted)

        updateFragmentBind.updateBtn.setOnClickListener{

            LocalVM.updateContent(task,
            updateFragmentBind.updateTitleET.text.toString(),
            updateFragmentBind.updateDescriptionET.text.toString(),
                updateFragmentBind.isCompleteCB.isChecked
        )
            //TODO ADD TOAST AND SEND BACK TO VIEW

            val navController: NavController = this.findNavController()
            val bund :Bundle = Bundle()
            bund.putLong("ID",task.ID)
            //navController.navigate(R.id.action,bund)
        }

        //Declaring and initializing view
        val view = updateFragmentBind.root

        //returning the view
        return view
    }
}