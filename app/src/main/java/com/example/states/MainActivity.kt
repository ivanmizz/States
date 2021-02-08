package com.example.states

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ActionMode
import android.view.LayoutInflater
import android.widget.Toast
import com.example.states.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
   // var data=getSharedPreferences("myData", MODE_PRIVATE)
    //var editdata = data.edit()


    private lateinit var binding: ActivityMainBinding
    lateinit var data:SharedPreferences
    lateinit var editdata: SharedPreferences.Editor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        var view=binding.root
        setContentView(view)

        data=applicationContext.getSharedPreferences("myData", MODE_PRIVATE)
        editdata=data.edit()

        Toast.makeText(applicationContext, "onCreate", Toast.LENGTH_SHORT).show()
        binding.save.setOnClickListener{
            saveData()
        }
        binding.retrieve.setOnClickListener{
            retrieveData()
        }
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(applicationContext, "onStart", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
       binding.message.setText(data.getString("message",""))
        Toast.makeText(applicationContext, "onResume", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
       saveData()
        Toast.makeText(applicationContext, "onPause", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(applicationContext, "onStop", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(applicationContext, "onDestroy", Toast.LENGTH_SHORT).show()
    }

    override fun onRestart() {
        super.onRestart()
        Toast.makeText(applicationContext, "onRestart", Toast.LENGTH_SHORT).show()
    }

    fun saveData(){
        editdata=data.edit()
        editdata.putString("message", binding.message.text.toString())
        editdata.apply()
    }
    fun retrieveData(){
       binding.message.setText(data.getString("message","") )
    }
}