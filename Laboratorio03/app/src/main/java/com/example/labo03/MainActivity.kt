package com.example.labo03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    private lateinit var fiveCentsImageView: ImageView
    private lateinit var tenCentsImageView: ImageView
    private lateinit var quarterImageView: ImageView
    private lateinit var oneDollarImageView: ImageView
    private lateinit var balanceTextView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()
        setListener()
    }

    private fun bind(){
        balanceTextView = findViewById(R.id.balance_text_view)
        fiveCentsImageView = findViewById(R.id.five_cents_image_view)
        tenCentsImageView = findViewById(R.id.ten_cents_image_view)
        quarterImageView = findViewById(R.id.quarter_image_view)
        oneDollarImageView = findViewById(R.id.dollar_image_view)
    }

    private fun setListener(){
        fiveCentsImageView.setOnClickListener {
            addMoneyToBalance(0.05)
        }
        tenCentsImageView.setOnClickListener {
            addMoneyToBalance(0.10)
        }
        quarterImageView.setOnClickListener {
            addMoneyToBalance(0.25)
        }
        oneDollarImageView.setOnClickListener {
            addMoneyToBalance(1.00)
        }
    }

    private fun addMoneyToBalance(coinValue: Double) {
        var balanceAmount = balanceTextView.text.toString().toDouble()
        balanceAmount += coinValue
        var round = (balanceAmount*1000.0).roundToInt().toDouble() /1000.0
        balanceTextView.text = round.toString()
    }
}