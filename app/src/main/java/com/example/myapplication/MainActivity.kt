package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

     var message: String = "Select Order"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.my_toolbar))
        floats.isEnabled = false;
        floats.setOnClickListener { view ->
            buyView(view)

        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {

            R.id.action_status -> {
                display(getString(R.string.action_status_message))
                return true
            }
            R.id.action_favorites -> {
                display(getString(R.string.action_favorites_message))
                return true
            }
            R.id.action_contact -> {
                display(getString(R.string.action_contact_message))
                return true
            }
            else -> {
            }
        }
        return super.onOptionsItemSelected(item)
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
        intent.putExtra("mes",message)
        startActivity(intent)
    }

}