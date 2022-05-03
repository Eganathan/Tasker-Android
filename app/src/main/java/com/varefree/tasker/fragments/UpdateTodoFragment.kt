package com.varefree.tasker.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.varefree.tasker.R
import com.varefree.tasker.databinding.FragmentCreateNewTodoBinding
import com.varefree.tasker.databinding.FragmentUpdateTodoBinding


class UpdateTodoFragment : Fragment() {

    //Declaring the binding
    private lateinit var updateFragmentBind:FragmentUpdateTodoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //initializing the binding with an inflater
        updateFragmentBind = FragmentUpdateTodoBinding.inflate(inflater,container,false)

        //Declaring and initializing view
        val view = updateFragmentBind.root

        //returning the view
        return view
    }
}