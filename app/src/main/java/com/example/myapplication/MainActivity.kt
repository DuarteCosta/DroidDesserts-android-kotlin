package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

     var message: String = "Select Order"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        floats.isEnabled = false;
        floats.setOnClickListener { view ->
            buyView(view)

        }

    }


    private fun display (message: String) =
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

    fun showDonut(view: View){
        message = getString(R.string.donut_order_message)
        display(message)
        floats.isEnabled = true;
    }

    fun showIce(view: View){
        message = getString(R.string.ice_cream_order_message)
        display(message)

        floats.isEnabled = true;
    }

    fun showFroyo(view: View){
        message = getString(R.string.froyo_order_message)
        display(message)
        floats.isEnabled = true;

    }

    private fun buyView(view: View){
        val intent = Intent(this, OrderActivity::class.java)
        intent.putExtra("messag",message)
        startActivity(intent)
    }

}