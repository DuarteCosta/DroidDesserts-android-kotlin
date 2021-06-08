package com.example.myapplication


import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_order.*


class OrderActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        // Get the intent and its data.
        val intent = intent.extras
        var messag = intent?.getString("messag")
        orderss.text = messag
        val phoneLabels = resources.getStringArray(R.array.labels_array)

        if (phone_text != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, phoneLabels
            )
            phone_text.adapter = adapter
        }


    }

    private fun display(message: String) =
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

    fun onRadioButtonClicked(view: View) {
        // Is the button now checked?
        val checked = (view as RadioButton).isChecked
        // Check which radio button was clicked.
        when (view.getId()) {
            same.id -> if (checked) // Same day service
                display(getString(R.string.same_day_delivery))
            next.id -> if (checked) // Next day delivery
                display(getString(R.string.next_day_delivery))
            pickUp.id -> if (checked) // Pick up
                display(getString(R.string.pick_up))
            else -> {
            }
        }


    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        TODO("Not yet implemented")
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}