package com.example.laboratorio04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText


class MainActivity : AppCompatActivity() {

    private lateinit var saveButton: Button
    private lateinit var nameTextInputEditText: TextInputEditText
    private lateinit var emailTextInputEditText: TextInputEditText
    private lateinit var phoneTextInputEditText: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bind()
        addListener()
    }

    private fun bind(){
        saveButton = findViewById(R.id.save_button)
        nameTextInputEditText = findViewById(R.id.name_text_input_edit_text)
        emailTextInputEditText = findViewById(R.id.email_text_input_edit_text)
        phoneTextInputEditText = findViewById(R.id.phone_text_input_edit_text)
    }

    private fun addListener() {

        saveButton.setOnClickListener {
            var intent = Intent(MainActivity@this, SecondActivity::class.java)
            intent.putExtra(USER_NAME, nameTextInputEditText.text.toString())
            intent.putExtra(USER_EMAIL, emailTextInputEditText.text.toString())
            intent.putExtra(USER_PHONE, phoneTextInputEditText.text.toString())
            startActivity(intent)
        }

    }

    companion object {
        const val USER_NAME = "USER_NAME"
        const val USER_EMAIL = "USER_EMAIL"
        const val USER_PHONE = "USER_PHONE"
    }

}