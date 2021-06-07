package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        floats.setOnClickListener { view ->
            buyView(view)

        }

    }


    fun display (message: String) =
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

    fun showDonut(view: View){
        display(getString(R.string.donut_order_message))
    }

    fun showIce(view: View){
        display(getString(R.string.ice_cream_order_message))
    }

    fun showFroyo(view: View){
        display(getString(R.string.froyo_order_message))
    }

    fun buyView(view: View){
        val intent = Intent(this, OrderActivity::class.java)
        startActivity(intent)
    }

}