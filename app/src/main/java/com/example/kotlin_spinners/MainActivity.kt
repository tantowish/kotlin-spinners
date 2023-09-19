package com.example.kotlin_spinners

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.kotlin_spinners.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var type: Array<String>
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        type=resources.getStringArray(R.array.tickets)

        with(binding){
            val adapterType = ArrayAdapter(this@MainActivity, androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item, type)
            spinnerTicket.adapter = adapterType


            val selectedDate = "${datePicker.dayOfMonth}-${datePicker.month+1}-${datePicker.year}"

            var selectedTime = ""
            timePicker.setOnTimeChangedListener{
                    view, hourOfDay, minute ->
                selectedTime = "$hourOfDay : $minute"
            }
            btnPesan.setOnClickListener{
                val toastValue = "Ticket ${spinnerTicket.selectedItem.toString()} $selectedDate $selectedTime has been ordered"
                Toast.makeText(this@MainActivity, toastValue, Toast.LENGTH_SHORT).show()
            }
        }


    }
}