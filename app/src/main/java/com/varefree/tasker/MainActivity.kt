package com.varefree.tasker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.fragment.NavHostFragment
import com.varefree.tasker.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    //Binding activity
    private lateinit var activityBinding: ActivityMainBinding
    private val TAG = "MainActivity"
    //overriding the default onCreate function
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //inflating the inflated to the variable
        activityBinding = ActivityMainBinding.inflate(layoutInflater)

        //getting the view from the inflated layout
        val view = activityBinding.root

        //setting the content of the screen
        setContentView(view)
    }

}