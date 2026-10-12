package com.example.mycalculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.DecimalFormat

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvResult = findViewById<TextView>(R.id.tvResult)
        val tvBMI = findViewById<TextView>(R.id.tvBMI)
        val tvDescription = findViewById<TextView>(R.id.tvDescription)
        val btnRecalculate = findViewById<Button>(R.id.btnRecalculate)

        val height = intent.getIntExtra("EXTRA_HEIGHT", 140)
        val weight = intent.getIntExtra("EXTRA_WEIGHT", 65)

        val heightMeters = height / 100.0
        val bmi = weight / (heightMeters * heightMeters)

        val df = DecimalFormat("#.##")
        tvBMI.text = df.format(bmi)

        when {
            bmi < 18.5 -> {
                tvResult.text = "BAJO PESO"
                tvResult.setTextColor(resources.getColor(android.R.color.holo_orange_light))
                tvDescription.text = "Estás por debajo del peso normal."
            }
            bmi in 18.5..24.9 -> {
                tvResult.text = "NORMAL"
                tvResult.setTextColor(resources.getColor(android.R.color.holo_green_light))
                tvDescription.text = "Tienes un peso corporal normal. ¡Buen trabajo!"
            }
            else -> {
                tvResult.text = "SOBREPESO"
                tvResult.setTextColor(resources.getColor(android.R.color.holo_red_light))
                tvDescription.text = "Estás por encima del peso normal."
            }
        }

        btnRecalculate.setOnClickListener {
            finish()
        }
    }
}