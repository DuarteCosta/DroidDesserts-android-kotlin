package com.example.myapplication


import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import kotlinx.android.synthetic.main.activity_order.*


class OrderActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private val channelID = "com.example.myapplication"

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        // Get the intent and its data.
        val intent = intent.extras
        val mes = intent?.getString("mes")
        orderss.text = mes
        val phoneLabels = resources.getStringArray(R.array.labels_array)

        if (phone_text != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, phoneLabels
            )
            phone_text.adapter = adapter
        }

        setSupportActionBar(my_toolbar2)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        notificationChannel()

        floats2.setOnClickListener {

            sendN()

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

    @RequiresApi(Build.VERSION_CODES.O)
    private fun notificationChannel() {
        val name = "Order"
        val descriptionT = "You have ordered"
        val important = NotificationManager.IMPORTANCE_DEFAULT
        val channel = NotificationChannel(channelID,name,important).apply {
            description= descriptionT
        }
        val notificationManager: NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)

    }

    private fun sendN(){

        val builder = NotificationCompat.Builder(this, channelID)
            .setSmallIcon(R.drawable.ic_shopping_cart)
            .setContentTitle("Droid Order")
            .setContentText("it's on its way")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        with(NotificationManagerCompat.from(this)){
            notify(101, builder.build())
        }
    }
}