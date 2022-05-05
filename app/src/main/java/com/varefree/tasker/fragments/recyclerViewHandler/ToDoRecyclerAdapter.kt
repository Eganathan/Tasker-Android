package com.varefree.tasker.fragments.recyclerViewHandler


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.varefree.tasker.R
import com.varefree.tasker.Tasker
import com.varefree.tasker.TaskerViewModel.DummyData
import com.varefree.tasker.localTransactions.LocalVM
import org.w3c.dom.Text

class ToDoRecyclerAdapter(val data:List<Tasker> ,val listner:onItemClickListner): RecyclerView.Adapter<ToDoRecyclerAdapter.ViewHolder>() {

    //var data = DummyData.dummyList

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ToDoRecyclerAdapter.ViewHolder {

        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_todo_recycler_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data.get(position)
        holder.titleView.setText(item.Title)
        holder.desView.setText(item.Description)
    }

    //Inner class
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener{
        var titleView: TextView
        var desView :TextView

        init
        {
            titleView = itemView.findViewById(R.id.titleTextR)
            desView = itemView.findViewById(R.id.descriptionTextR)
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            var position = adapterPosition

            if(position != RecyclerView.NO_POSITION)
            {listner.onItemClick(position)}

        }
    }
}

interface onItemClickListner{
    fun onItemClick(position: Int)
}