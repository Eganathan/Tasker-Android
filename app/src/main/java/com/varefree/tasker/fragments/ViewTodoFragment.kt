package com.varefree.tasker.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.TouchDelegate
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import com.varefree.tasker.R
import com.varefree.tasker.databinding.FragmentUpdateTodoBinding
import com.varefree.tasker.databinding.FragmentViewTodoBinding

class ViewTodoFragment : Fragment() {

    //Declaring the binding
    private lateinit var viewFragmentBind: FragmentViewTodoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //initializing the binding with an inflater
        viewFragmentBind = FragmentViewTodoBinding.inflate(inflater, container, false)

        viewFragmentBind.viewMarkComplete.setOnClickListener {

        }
        viewFragmentBind.viewEdit.setOnClickListener {
                view: View -> view.findNavController().navigate(R.id.action_viewTodoFragment_to_updateTodoFragment)
        }
        viewFragmentBind.viewDelete.setOnClickListener {

        }




        return viewFragmentBind.root
    }

}