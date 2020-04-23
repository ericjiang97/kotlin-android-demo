package dev.ericjiang.kotlin.example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import dev.ericjiang.kotlin.example.model.States

class MainActivity : AppCompatActivity() {

    private val TAG = "@@ACTIVITY/MAIN"

    private val states = enumValues<States>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner = findViewById<Spinner>(R.id.state)
        if(spinner != null){
            val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, states)
            spinner.adapter = spinnerAdapter
            spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
                override fun onNothingSelected(parent: AdapterView<*>?) {

                }

                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

                    Log.d(TAG, "test")
                    Log.d(TAG, "${states.get(position)}")
                }

            }
        }

    }
}
