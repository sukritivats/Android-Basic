package com.example.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.listview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var binding : ActivityMainBinding?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        val taskList = arrayListOf<String>()
        taskList.add("kotlin")
        taskList.add("layout")
        taskList.add("activity")
        taskList.add("intent")
        taskList.add("fragments")
        taskList.add("Views")

        // data sources(array, list etc) --> adapter --> Ui component(list views, spinner,etc)
        // adapters convert data items into view items so that they can be displayed in UI components
        val adapterForMyListView = ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1,taskList)
        binding?.listview?.adapter=adapterForMyListView
        binding?.listview?.setOnItemClickListener { parent, view, position, id ->
            val text = "Clicked on item: "+(view as TextView).text.toString()
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
        }

        // spinner

        val duration = arrayListOf<String>("Today","Yesterday","Tomorrow","Previous week", "Current Month")
        val duratioAdapter = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,duration)
        binding?.spinner?.adapter=duratioAdapter
        binding?.spinner?.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                binding?.tvHeading?.text=duration[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                binding?.spinner?.setSelection(0)
            }

        }

        //autocomplete textview

        val course = arrayOf<String>("Android","Angular","Bca", "B.Tech","Computer","Crash")
        val courseAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,course)
        binding?.tvAuto?.setAdapter(courseAdapter)
    }


}