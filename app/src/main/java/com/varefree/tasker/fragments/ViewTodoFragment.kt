package com.varefree.tasker.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.TouchDelegate
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.varefree.tasker.R
import com.varefree.tasker.Tasker
import com.varefree.tasker.databinding.FragmentUpdateTodoBinding
import com.varefree.tasker.databinding.FragmentViewTodoBinding
import com.varefree.tasker.localTransactions.LocalVM
import kotlinx.coroutines.selects.select

class ViewTodoFragment : Fragment() {

    //Declaring the binding
    private lateinit var viewFragmentBind: FragmentViewTodoBinding
    private lateinit var task: Tasker
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //initializing the binding with an inflater
        viewFragmentBind = FragmentViewTodoBinding.inflate(inflater, container, false)


        var ID: Long? = arguments?.getLong("ID")

        if (ID != null) {
            task = LocalVM.searchWithID(ID)!!
        }
        viewFragmentBind.titleV.setText(task.Title)
        viewFragmentBind.descriptionV.setText(task.Description)
        viewFragmentBind.radioIsComplete.setChecked(task.isCompleted)

        viewFragmentBind.viewMarkComplete.setOnClickListener {
            LocalVM.swithchCompletion(task)
            Toast.makeText(this.context,"isCompleted ? : ${task.isCompleted}",Toast.LENGTH_SHORT)
            viewFragmentBind.radioIsComplete.setChecked(task.isCompleted)
        }
        viewFragmentBind.viewEdit.setOnClickListener {

                var bundle:Bundle = Bundle()
            bundle.putLong("ID",task.ID);
            var nc: NavController = this.findNavController()
            nc.navigate(R.id.action_viewTodoFragment_to_updateTodoFragment,bundle)
        }
        viewFragmentBind.viewDelete.setOnClickListener {


        }
        return viewFragmentBind.root
    }

}