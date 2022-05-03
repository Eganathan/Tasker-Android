package com.varefree.tasker.fragments

import android.icu.text.CaseMap
import android.icu.text.Edits
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.findNavController
import com.varefree.tasker.MainActivity
import com.varefree.tasker.R
import com.varefree.tasker.databinding.FragmentCreateNewTodoBinding
import com.varefree.tasker.localTransactions.LocalVM

class CreateNewTodoFragment : Fragment() {

    //declaring the binding
    private lateinit var createFragmentBinding:FragmentCreateNewTodoBinding
    private lateinit var eTitle: EditText
    private lateinit var eDescription: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //initializing the binding with an inflater
        createFragmentBinding = FragmentCreateNewTodoBinding.inflate(inflater)

        eTitle = createFragmentBinding.createTitle
        eDescription = createFragmentBinding.createDescription

        createFragmentBinding.createAddBtn.setOnClickListener {

            var titleValue = eTitle.text.trim()
            var titleDescription = eDescription.text.trim()

            //adding to local repo
            if(LocalVM.insertTask(titleValue.toString(),titleDescription.toString()))
            {
                eTitle.setText("")
                eDescription.setText("")
                Toast.makeText(this.context,"Task created successfully", Toast.LENGTH_SHORT).show()
            }else{
               Toast.makeText(this.context,"Please try again!", Toast.LENGTH_SHORT).show()
            }
        }

        return createFragmentBinding.root
    }

}