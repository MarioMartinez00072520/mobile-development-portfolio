package com.example.labo02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat


class MainActivity : AppCompatActivity() {

    private lateinit var weightEditText: EditText
    private lateinit var heightEditText: EditText
    private lateinit var calculateActionButton: Button
    private lateinit var  bmiResultText: TextView
    private lateinit var healthResultText: TextView
    private lateinit var descriptionResultText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bind()
        setListener()
    }

    private fun bind(){
        weightEditText = findViewById(R.id.weight_edit_text)
        heightEditText = findViewById(R.id.height_edit_text)
        calculateActionButton = findViewById(R.id.calculate_action_button)
        bmiResultText = findViewById(R.id.bmi_result_text_view)
        healthResultText = findViewById(R.id.health_result_text_view)
        descriptionResultText = findViewById(R.id.description_result_text_view)
    }

    private fun setListener(){
        calculateActionButton.setOnClickListener {
            val weight = weightEditText.text.toString()
            val height = heightEditText.text.toString()

            if (weight.isNullOrBlank() || height.isNullOrBlank()){
                Toast.makeText(this, "El Dato esta vacio!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val bmiresult = (weight.toFloat())/((height.toFloat()/100)*(height.toFloat()/100))

            result(bmiresult)
        }
    }

    private fun result(bmi: Float){

        bmiResultText.text = bmi.toString()
        bmiResultText.setTextColor(ContextCompat.getColor(this, R.color.white))

        if (bmi <= 18.5){
            healthResultText.text = "Underweight"
            healthResultText.setTextColor(ContextCompat.getColor(this, R.color.obese))
        }
        if (bmi in 18.5..24.99){
            healthResultText.text = "Healthy"
            healthResultText.setTextColor(ContextCompat.getColor(this, R.color.normal_weight))
        }
        if (bmi in 25.0..29.99){
            healthResultText.text = "Overweight"
            healthResultText.setTextColor(ContextCompat.getColor(this, R.color.over_weight))
        }
        if (bmi >= 30){
            healthResultText.text = "Obese"
            healthResultText.setTextColor(ContextCompat.getColor(this, R.color.obese))
        }
    }
}